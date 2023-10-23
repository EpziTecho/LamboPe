/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *  Esta clase se dedica a consultar la base de datos de factura
 *  Estos datos los recoge un arraylist.
 *  Tambien tiene método para mostrar los datos
 * @author grupo2
 */
public class FacturaConsultas {

    private static FacturaConsultas miConsultaFactura = null;

    private ArrayList<Factura> listaDeFacturas;
    private Connection con = ConexionBBDD.con().conectar();
    private String sSQL = "";

    public static FacturaConsultas consulta() {

        if (miConsultaFactura != null) {
            return miConsultaFactura;
        } else {
            miConsultaFactura = new FacturaConsultas();
            return miConsultaFactura;
        }
    }

    public FacturaConsultas() {
        listaDeFacturas = new ArrayList<>();
    }

    public void obtenfacturaBBDD() throws SQLException {
        sSQL = "select p.numero_factura, p.idalquiler, p.tipo_pago, p.igv, p.total_pago, "+
             "p.fecha_emision, p.fecha_pago from factura p, Alquiler r "+
             "where p.idalquiler = r.idalquiler order by numero_factura desc";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sSQL);

        while (rs.next()) {

            int numFactura = Integer.parseInt(rs.getString("numero_factura"));
            
            // Buscamos un objeto Alquiler con la id recogida de la base de datos
            // de ese objeto obtenemos su matricula y su modelo
            Alquiler r = AlquilerConsultas.consulta().buscaId(Integer.parseInt(rs.getString("idalquiler")));
         
            String tipofactura = rs.getString("tipo_pago");
            double igv = Double.parseDouble(rs.getString("igv"));
            double totalpago = Double.parseDouble(rs.getString("total_pago"));
            Date fechaEmision = Date.valueOf(rs.getString("fecha_emision"));
            Date fechapago = Date.valueOf(rs.getString("fecha_pago"));
            
            Factura p = new Factura(numFactura, r, tipofactura, igv, totalpago, fechaEmision, fechapago);
            
            guardafacturaArray(p);  
            
        }
    }

    public void guardafacturaArray(Factura p) {
        listaDeFacturas.add(p);
    }

    public void borrarfacturaArray(Factura p) {
        listaDeFacturas.remove(p);
    }
    
    public Factura[] listarfacturas() {
        Factura p[] = new Factura[listaDeFacturas.size()];

        for (int i = 0; i < listaDeFacturas.size(); i++) {
            p[i] = listaDeFacturas.get(i);
        }

        return p;
    }
    
    /**
     * Copia a un array de facturas el ArrayList de facturas, pero solo copia aquellos objetos
     * que cumplan la condición. Sea esta la de que coincida la id de la Alquiler.
     * @param idalquiler
     * @return 
     */

    public Factura[] listarFacturasAlquiler(int idalquiler) {
        Factura p[] = new Factura[listaDeFacturas.size()];

        for (int i = 0; i < listaDeFacturas.size(); i++) {
            if(idalquiler == this.listaDeFacturas.get(i).getAlquiler().getIdAlquiler())
            p[i] = listaDeFacturas.get(i);
        }

        return p;
    }

    /**
     * Método para editar mediante consulta sql un objeto de tipo factura que se
     * le haya pasado.
     *
     * @param p
     * @throws java.sql.SQLException
     */
    public void editar(Factura p) throws SQLException {
        sSQL = "update factura set idalquiler=?, tipo_pago=?, igv=?, total_pago=?, fecha_emision=?, fecha_pago=?"
                + " where numero_factura=?";

        PreparedStatement pst = con.prepareStatement(sSQL);
        pst.setInt(1, p.getAlquiler().getIdAlquiler());
        pst.setString(2, p.getTipofactura());
        pst.setDouble(3, p.getigv());
        pst.setDouble(4, p.getTotalpago());
        pst.setDate(5, p.getFechaEmision());
        pst.setDate(6, p.getFechapago());  
        pst.setInt(7, p.getNumFactura());

        pst.executeUpdate();
    }

    /**
     * Método para guardar mediante consulta sql un objeto de tipo factura que se
     * le haya pasado.
     *
     * @param p
     * @return true si se crea, false si no se puede crear
     */
    public boolean nuevo(Factura p) throws SQLException {
        sSQL = "insert into Factura (numero_factura, idalquiler, tipo_pago, igv, total_pago, fecha_emision, fecha_pago) "
                + "values (?,?,?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sSQL);
        pst.setInt(1, p.getNumFactura());
        pst.setInt(2, p.getAlquiler().getIdAlquiler());
        pst.setString(3, p.getTipofactura());
        pst.setDouble(4, p.getigv());
        pst.setDouble(5, p.getTotalpago());
        pst.setDate(6, p.getFechaEmision());
        pst.setDate(7, p.getFechapago());  

        pst.executeUpdate();
        guardafacturaArray(p);
        return true;

    }

    /**
     * Método que devuelve la nueva id en caso de que se cree un nuevo objeto.
     * Si es nula, osea no hay datos porque es la primera en introducir, la
     * iguala a 1. Si no es nula la incrementa.
     *
     * @return la id nueva asignada, o 0 en caso de no asignar ninguna que será
     * un error.
     * @throws java.sql.SQLException
     */
    public int numNuevo() throws SQLException {
        String num;

        // Creamos la sentencia que se va a ejecutar en el ResultSet
        sSQL = "SELECT MAX(numero_factura) AS numero_factura FROM Factura";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sSQL);

        while (rs.next()) {
            // Guardamos en la variable el resultado
            num = rs.getString("numero_factura");

            // Comprobamos en caso de que no haya registros en la tabla
            // que la id sea la primera
            int numNuevo;

            if (num == null) {
                numNuevo = 1;
                return numNuevo;
            } else {
                numNuevo = Integer.parseInt(num) + 1;
                return numNuevo;
            }
            
        }
        
        return -1;
    }

    /**
     * Método para borrar de la base de datos y posteriormente del arraylist un
     * objeto de tipo factura de la tabla.
     *
     * @param p
     * @throws SQLException
     */
    public void borrar(Factura p) throws SQLException {

        // Creamos la primera consulta y un prepared statement para ella.
        sSQL = "delete from factura where numero_factura=?";
        PreparedStatement pst = con.prepareStatement(sSQL);
        pst.setInt(1, p.getNumFactura());
        pst.executeUpdate();

        // borramos también la factura del arraylist.
        borrarfacturaArray(p);

    }
    
    /**
     * Método para buscar el numero de factura en el arraylist
     * @param num
     * @return 
     */

    public Factura buscaNumero(int num) {
        Factura p;
        p = null;

        for (int i = 0; i < listaDeFacturas.size(); i++) {
            if (num == (this.listaDeFacturas.get(i).getNumFactura())) {
                p = listaDeFacturas.get(i);
            }
        }
        return p;
    }
    
    /**
     * Método que busca por fecha en el arraylist la Alquiler
     * @param fechaEmision
     * @return 
     */

    public Factura[] buscarPorFecha(Date fechaEmision) {    
        
        // copiamos el arraylist a un array
        Factura p[] = new Factura[listaDeFacturas.size()];

        // recorremos ese array con un bucle for, copiando los elementos que encuentre iguales
        // a ese array que hemos creado.
        for (int i = 0; i < listaDeFacturas.size(); i++) {
            // hacemos un matches con una expresión regular para comprobar que el nombre se guala a lo que hemos introducido
            if (listaDeFacturas.get(i).getFechaEmision().equals(fechaEmision) ) {
            p[i] = listaDeFacturas.get(i);
            return p;
            }
        }
        return null;
    }

}