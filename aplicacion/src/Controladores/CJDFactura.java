/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Factura;
import Modelo.FacturaConsultas;
import Modelo.Alquiler;
import Modelo.AlquilerConsultas;
import Modelo.VehiculoConsultas;
import Vistas.JDFactura;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador del JDialog de factura.
 * Recoge los datos de la vista y los pasa al modelo y viceversa.
 * @author  grupo2
 */
public class CJDFactura {

    private JDFactura vistafacturas;
    private DefaultTableModel tablaExtra;
    private DefaultTableModel tablafactura;
    private double igv = 0.18;

    public CJDFactura(JDFactura vistafacturas) {
        this.vistafacturas = vistafacturas;
    }

    /**
     * Método que imprimirá los datos del arrayliat de Extras en la tabla que
     * tenemos en nuestro JDialog de facturas
     */
    public void rellenaTablaExtras() {

        // Creamos una nueva tabla la cual le sobreescribiremos un parámetro para que no se puedan editar las celdas.
        tablaExtra = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Creamos las columnas de nuestra tabla.
        tablaExtra.addColumn("Id");
        tablaExtra.addColumn("Nombre");
        tablaExtra.addColumn("Descripcion");
        tablaExtra.addColumn("Precio");
        
        Alquiler r;
        if (vistafacturas.getIdAlquiler().equals("")){
            int idalquiler = Integer.parseInt((String) vistafacturas.getTMJTablefacturas().getValueAt(0, 1));
            r = AlquilerConsultas.consulta().buscaId(idalquiler);
        }else {
            r = AlquilerConsultas.consulta().buscaId(Integer.parseInt(vistafacturas.getIdAlquiler()));
        }
         
        String[] datos = new String[4];
        datos[0] = String.valueOf(r.getExtra().getIdExtra());
        datos[1] = r.getExtra().getNombre();
        datos[2] = r.getExtra().getDescripcion();
        datos[3] = String.valueOf(r.getExtra().getPrecioAlquiler());

        tablaExtra.addRow(datos);
        
        vistafacturas.setTMJTableExtras(tablaExtra);
    }
    
    /**
     * Método que imprimirá los datos del arraylist de facturas en la tabla que
     * tenemos en nuestro JDialog de facturas pero sólo los que sean de la misma ID que la Alquiler seleccionada.
     */
    public void rellenaTablafacturasPorId() {

        // Creamos una nueva tabla la cual le sobreescribiremos un parámetro para que no se puedan editar las celdas.
        tablafactura = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Creamos las columnas de nuestra tabla.
        tablafactura.addColumn("Número de factura");
        tablafactura.addColumn("ID Alquiler");
        tablafactura.addColumn("Fecha de Devolución de la Alquiler");
        tablafactura.addColumn("Matrícula Vehiculo de Alquiler");
        tablafactura.addColumn("Tipo de factura");
        tablafactura.addColumn("igv");
        tablafactura.addColumn("factura Final");
        tablafactura.addColumn("Fecha de Emisión");
        tablafactura.addColumn("Fecha de factura");

        Factura[] lista = FacturaConsultas.consulta().listarFacturasAlquiler(Integer.parseInt(vistafacturas.getIdAlquiler()));

        for (Factura p : lista) {
            if (p != null) {
            String[] datos = new String[9];
            datos[0] = String.valueOf(p.getNumFactura());
            datos[1] = String.valueOf(p.getAlquiler().getIdAlquiler());
            datos[2] = String.valueOf(p.getAlquiler().getFechaDevolucion());
            datos[3] = p.getAlquiler().getVehiculo().getMatricula();
            datos[4] = p.getTipofactura();
            datos[5] = String.valueOf(p.getigv());
            datos[6] = String.valueOf(p.getTotalpago());
            datos[7] = String.valueOf(p.getFechaEmision());
            datos[8] = String.valueOf(p.getFechapago());

            tablafactura.addRow(datos);
            }
        }
        vistafacturas.setTMJTablefacturas(tablafactura);
    }
    
    /**
     * Rellena los campos del los TextField de la vista con los parámetros
     * de la Alquiler seleccionada en el JFrame Alquiler
     */
    public void rellenaCamposfacturaNuevo() {
        
        Alquiler r = AlquilerConsultas.consulta().buscaId(Integer.parseInt(vistafacturas.getIdAlquiler()));
        
        try {
            vistafacturas.setNumFactura(FacturaConsultas.consulta().numNuevo());
        } catch (SQLException ex) {
            vistafacturas.muestraExcepcionSQL();
        }
        
        vistafacturas.setMatricula(r.getVehiculo().getMatricula());
        double costeAlquiler = r.getCostoAlquiler();
        vistafacturas.setCosteAlquiler(costeAlquiler);
        vistafacturas.setigv(igv);
        
        // vamos a hacer la opreación para calcular el total del factura
        double total = (costeAlquiler*igv) + costeAlquiler;
        vistafacturas.settotalpago(total);
    }
    
    /**
     * Rellena los campos del los TextField de la vista con los parámetros
     * de la tabla de facturas
     */
    public void rellenaCamposfacturaEditar() {
        
        int seleccion = vistafacturas.getFilaSeleccionadafacturas();
        if (seleccion >= 0) {

            int numFactura = Integer.parseInt((String) vistafacturas.getTMJTablefacturas().getValueAt(seleccion, 0));
            int idalquiler = Integer.parseInt((String) vistafacturas.getTMJTablefacturas().getValueAt(seleccion, 1));
            
            Alquiler r = AlquilerConsultas.consulta().buscaId(idalquiler);
            String matriculaAlquiler = r.getVehiculo().getMatricula();
            double costeAlquiler = r.getCostoAlquiler();
            
            String tipofactura = (String) vistafacturas.getTMJTablefacturas().getValueAt(seleccion, 4);
            double totalpago = Double.parseDouble((String) vistafacturas.getTMJTablefacturas().getValueAt(seleccion, 6));
            Date fechaEmision = Date.valueOf((String) vistafacturas.getTMJTablefacturas().getValueAt(seleccion, 7));
            Date fechapago = Date.valueOf((String) vistafacturas.getTMJTablefacturas().getValueAt(seleccion, 8));

            vistafacturas.setNumFactura(numFactura);
            vistafacturas.setidalquiler(idalquiler);
            vistafacturas.setMatricula(matriculaAlquiler);
            vistafacturas.setCosteAlquiler(costeAlquiler);
            vistafacturas.setigv(igv);
            vistafacturas.setTipofactura(tipofactura);
            vistafacturas.settotalpago(totalpago);
            vistafacturas.setFechaEmision(fechaEmision);
            vistafacturas.setfechapago(fechapago);
        }
    }

    /**
     * Método que guarda los facturas en la base de datos y el arraylist
     */   
    public boolean guardafactura() {
        
            int numFactura = Integer.parseInt(vistafacturas.getNumFactura());
            Alquiler r = AlquilerConsultas.consulta().buscaId(Integer.parseInt(vistafacturas.getIdAlquiler()));
            String tipofactura = vistafacturas.getTipofactura();
            double totalpago = Double.parseDouble(vistafacturas.getTotal());
            Date fechaEmision = vistafacturas.getFechaEmision();
            Date fechapago = vistafacturas.getFechapago();
            
            Factura p = new Factura(numFactura, r, tipofactura, igv, totalpago, fechaEmision, fechapago);
            try {
                p.getAlquiler().setEstado("Pagada");
                p.getAlquiler().getVehiculo().setEstado("Disponible");
                AlquilerConsultas.consulta().actualizaEstado(r.getIdAlquiler(), r.getEstado());
                VehiculoConsultas.consulta().actualizaEstado(r.getVehiculo().getIdVehiculo(), r.getVehiculo().getEstado());
                
                FacturaConsultas.consulta().nuevo(p);
                return true;
            } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException em) {
                vistafacturas.excepcionRepetida();
                return false;
            } catch (SQLException ex) {
                vistafacturas.muestraExcepcionSQL();
                ex.printStackTrace();
                return false;
            }
    }
    
    /**
     * Método que guarda los facturas en la base de datos y el arraylist
     */   
    public void editafactura() {
        
            int numFactura = Integer.parseInt(vistafacturas.getNumFactura());
            Alquiler r = AlquilerConsultas.consulta().buscaId(Integer.parseInt(vistafacturas.getIdAlquiler()));
            String tipofactura = vistafacturas.getTipofactura();
            double totalpago = Double.parseDouble(vistafacturas.getTotal());
            Date fechaEmision = vistafacturas.getFechaEmision();
            Date fechapago = vistafacturas.getFechapago();
            
            Factura p = FacturaConsultas.consulta().buscaNumero(numFactura);
            
            p.setAlquiler(r);
            p.setTipofactura(tipofactura);
            p.setigv(igv);
            p.settotalpago(totalpago);
            p.setFechaEmision(fechaEmision);
            p.setfechapago(fechapago);
            
            try {
                FacturaConsultas.consulta().editar(p);
            } catch (SQLException ex) {
                vistafacturas.muestraExcepcionSQL();
                ex.printStackTrace();
            }
    }
    
    /**
     * Metodo que revisa la fila seleccionada.
     * Posteriormente crea una sentencia SQL y prepara un Statement para
     * que el borrado del registro sea satisfactorio. Finalmente repinta la
     * tabla.
     */
    public void borrafactura() {

        int seleccion = vistafacturas.getFilaSeleccionadafacturas();
        if (seleccion >= 0) {

            int numFactura = Integer.parseInt((String) vistafacturas.getTMJTablefacturas().getValueAt(seleccion, 0));
            Factura p = FacturaConsultas.consulta().buscaNumero(numFactura);

            try {
                FacturaConsultas.consulta().borrar(p);
                p.getAlquiler().setEstado("Factura Eliminada");
                AlquilerConsultas.consulta().actualizaEstado(p.getAlquiler().getIdAlquiler(), p.getAlquiler().getEstado());
                rellenaTablafacturasPorId();
                vistafacturas.repaint();
            } catch (SQLException esql) {
                vistafacturas.muestraExcepcionSQL();
                esql.printStackTrace();
            }
        }
    }
    
    /**
     * Método que calcula la fecha actual del sistema.
     * @return 
     */
    
    public Date fechaActual() {
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int d = fecha.get(Calendar.DAY_OF_MONTH);
        int m = fecha.get(Calendar.MONTH);
        int a = fecha.get(Calendar.YEAR) -1900;
        
        return new Date(a, m, d);
    }
    // Metodo que genera un txt con una factura, aun pendiente ;(
    public void generarTXT() {
        String[] datatxt = new String[9];

        Factura[] lista = FacturaConsultas.consulta().listarFacturasAlquiler(Integer.parseInt(vistafacturas.getIdAlquiler()));

        for (Factura p : lista) {
            if (p != null) {
                datatxt[0] = String.valueOf(p.getNumFactura());
                datatxt[1] = String.valueOf(p.getAlquiler().getIdAlquiler());
                datatxt[2] = String.valueOf(p.getAlquiler().getFechaDevolucion());
                datatxt[3] = p.getAlquiler().getVehiculo().getMatricula();
                datatxt[4] = p.getTipofactura();
                datatxt[5] = String.valueOf(p.getigv());
                datatxt[6] = String.valueOf(p.getTotalpago());
                datatxt[7] = String.valueOf(p.getFechaEmision());
                datatxt[8] = String.valueOf(p.getFechapago());
            }
        }
        try {
            String ruta = "C://Facturas/Factura " + datatxt[0] + ".txt";
            String content="";
            for (int i = 0; i < datatxt.length; i++) {
                content += datatxt[i] + "\n";
            }
            content += "****************";
            String contenido = content;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}



