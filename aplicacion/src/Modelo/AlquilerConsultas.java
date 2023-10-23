/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *  Esta clase se dedica a consultar la base de datos de Alquiler.
 *  Estos datos los recoge un arraylist.
 *  Tambien tiene método para mostrar los datos
 * @author grupo2
 */
public class AlquilerConsultas {

    private static AlquilerConsultas miConsultaAlquileres = null;

    private ArrayList<Alquiler> listaDeAlquileres;
    private Connection con = ConexionBBDD.con().conectar();
    private String sSQL = "";

    public static AlquilerConsultas consulta() {

        if (miConsultaAlquileres != null) {
            return miConsultaAlquileres;
        } else {
            miConsultaAlquileres = new AlquilerConsultas();
            return miConsultaAlquileres;
        }
    }

    public AlquilerConsultas() {
        listaDeAlquileres = new ArrayList<>();
    }

    public void obtenAlquilerBBDD() throws SQLException {
        sSQL = "select r.idalquiler, r.matricula_vehiculo, r.dni_cliente, r.dni_trabajador, r.idextra,"+
             "r.tipo_tarifa, r.fecha_Alquiler, r.fecha_recogida, r.fecha_devolucion, r.costo_alquiler, r.estado "+
             "from Alquiler r, vehiculo v where r.matricula_vehiculo = v.matricula order by idalquiler desc";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sSQL);

        while (rs.next()) {

            int idalquiler = Integer.parseInt(rs.getString("idalquiler"));
            
            // Buscamos un objeto vehiculo con la matricula recogida de la base de datos
            // de ese objeto obtenemos su matricula y su modelo
            Vehiculo v = VehiculoConsultas.consulta().BuscarporMatricula( rs.getString("matricula_vehiculo") );
            
            // Buscamos un objeto cliente con el dni recogido de la base de datos
            // de ese objeto obtenemos su dni, nombre y apellidos
            Cliente c = ClienteConsultas.consulta().buscarporDNI( rs.getString("dni_cliente") );
            
            // Idem con trabajador
            Trabajador t = TrabajadorConsultas.consulta().buscarporDNI(  rs.getString("dni_trabajador")  );
            
            //Idem con extra
            Extras e = ExtrasConsultas.consulta().buscaId( Integer.parseInt(rs.getString("idextra")) );
         
            String tipoTarifa = rs.getString("tipo_tarifa");
            Date fechaAlquiler = Date.valueOf(rs.getString("fecha_alquiler"));
            Date fechaRecogida = Date.valueOf(rs.getString("fecha_recogida"));
            Date fechaDevolucion = Date.valueOf(rs.getString("fecha_devolucion"));
            double costoAlquiler = Double.parseDouble(rs.getString("costo_alquiler"));
            String estado = rs.getString("estado");
            
            Alquiler r = new Alquiler(idalquiler, v, c, t, e, tipoTarifa, fechaAlquiler, fechaRecogida, fechaDevolucion, costoAlquiler, estado);
            
            guardaAlquilerArray(r);  
            
        }
    }

    public void guardaAlquilerArray(Alquiler r) {
        listaDeAlquileres.add(r);
    }

    public void borrarAlquilerArray(Alquiler r) {
        listaDeAlquileres.remove(r);
    }

    public Alquiler[] listarAlquilers() {
        Alquiler r[] = new Alquiler[listaDeAlquileres.size()];

        for (int i = 0; i < listaDeAlquileres.size(); i++) {
            r[i] = listaDeAlquileres.get(i);
        }

        return r;
    }

    /**
     * Método para editar mediante consulta sql un objeto de tipo extra que se
     * le haya pasado.
     *
     * @param r
     * @throws java.sql.SQLException
     */
    public void editar(Alquiler r) throws SQLException {
        sSQL = "update Alquiler set matricula_vehiculo=?, dni_cliente=?, dni_trabajador=?, idextra=?, tipo_tarifa=?, fecha_Alquiler=?, fecha_recogida=?, fecha_devolucion=?, costo_alquiler=?, estado=?"
                + " where idalquiler=?";

        PreparedStatement pst = con.prepareStatement(sSQL);
        pst.setString(1, r.getVehiculo().getMatricula());
        pst.setString(2, r.getCliente().getDni());
        pst.setString(3, r.getTrabajador().getDni());
        pst.setInt(4, r.getExtra().getIdExtra() );
        pst.setString(5, r.getTipoTarifa());
        pst.setDate(6, r.getFechaAlquiler());
        pst.setDate(7, r.getFechaRecogida());
        pst.setDate(8, r.getFechaDevolucion());
        pst.setDouble(9, r.getCostoAlquiler());
        pst.setString(10, r.getEstado());
        pst.setInt(11, r.getIdAlquiler());

        pst.executeUpdate();

    }
    
    /**
     * Actualiza el estado del Alquiler en la base de datos según la id de ese Alquiler
     * El estado es el pasado por el controlador
     * @param idalquiler
     * @param estado
     * @throws SQLException 
     */
    
    public void actualizaEstado(int idalquiler, String estado) throws SQLException {
        sSQL = "update Alquiler set estado=? where idalquiler=?";
        
        PreparedStatement pst = con.prepareStatement(sSQL);
        pst.setString(1, estado);
        pst.setInt(2, idalquiler);
        
        pst.executeUpdate();
        
    }

    /**
     * Método para guardar mediante consulta sql un objeto de tipo extra que se
     * le haya pasado.
     *
     * @param r
     * @return true si se crea, false si no se puede crear
     */
    public boolean nuevo(Alquiler r) throws SQLException {
        sSQL = "insert into Alquiler (idalquiler, matricula_vehiculo, dni_cliente, dni_trabajador, idextra, tipo_tarifa, fecha_Alquiler, fecha_recogida, fecha_devolucion, costo_alquiler, estado) "
                + "values (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sSQL);

        pst.setInt(1, r.getIdAlquiler());
        pst.setString(2, r.getVehiculo().getMatricula());
        pst.setString(3, r.getCliente().getDni());
        pst.setString(4, r.getTrabajador().getDni());
        pst.setInt(5, r.getExtra().getIdExtra());
        pst.setString(6, r.getTipoTarifa());
        pst.setDate(7, r.getFechaAlquiler());
        pst.setDate(8, r.getFechaRecogida());
        pst.setDate(9, r.getFechaDevolucion());
        pst.setDouble(10, r.getCostoAlquiler());
        pst.setString(11, r.getEstado());

        pst.executeUpdate();
        guardaAlquilerArray(r);
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
    public int idNueva() throws SQLException {
        String id;

        // Creamos la sentencia que se va a ejecutar en el ResultSet
        sSQL = "SELECT MAX(idalquiler) AS idalquiler FROM Alquiler";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sSQL);

        while (rs.next()) {
            // Guardamos en la variable el resultado
            id = rs.getString("idalquiler");

            // Comprobamos en caso de que no haya registros en la tabla
            // que la id sea la primera
            int idNuevo;

            if (id == null) {
                idNuevo = 1;
                return idNuevo;
            } else {
                idNuevo = Integer.parseInt(id) + 1;
                return idNuevo;
            }
        }
        return -1;
    }

    /**
     * Método para borrar de la base de datos y posteriormente del arraylist un
     * objeto de tipo extra de la tabla.
     *
     * @param r
     * @throws SQLException
     */
    public void borrar(Alquiler r) throws SQLException {

        // Creamos la primera consulta y un prepared statement para ella.
        sSQL = "delete from Alquiler where idalquiler=?";
        PreparedStatement pst = con.prepareStatement(sSQL);
        pst.setInt(1, r.getIdAlquiler());
        pst.executeUpdate();

        // borramos también la Alquiler del arraylist.
        borrarAlquilerArray(r);

    }
    
    /**
     * Método para buscar la ID de la Alquiler en el arraylist
     * @param id
     * @return 
     */

    public Alquiler buscaId(int id) {
        Alquiler r;
        r = null;

        for (int i = 0; i < listaDeAlquileres.size(); i++) {
            if (id == (this.listaDeAlquileres.get(i).getIdAlquiler())) {
                r = listaDeAlquileres.get(i);
            }
        }
        return r;
    }
    
    /**
     * Método que busca por fecha en el arraylist la Alquiler
     * @param fechaAlquiler
     * @return 
     */

    public Alquiler[] buscarPorFecha(Date fechaAlquiler) {    
        
        // copiamos el arraylist a un array
        Alquiler r[] = new Alquiler[listaDeAlquileres.size()];

        // recorremos ese array con un bucle for, copiando los elementos que encuentre iguales
        // a ese array que hemos creado.
        for (int i = 0; i < listaDeAlquileres.size(); i++) {
            // hacemos un matches con una expresión regular para comprobar que el nombre se guala a lo que hemos introducido
            if (listaDeAlquileres.get(i).getFechaAlquiler().equals(fechaAlquiler) ) {
            r[i] = listaDeAlquileres.get(i);
            return r;
            }
        }
        return null;
    }

}