/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Alquiler;
import Modelo.AlquilerConsultas;
import Vistas.JFrameAlquiler;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador del JFrame de Alquiler.
 * Recoge los datos de la vista y los pasa al modelo y viceversa.
 * @author  grupo2
 */
public class Calquiler {

    private JFrameAlquiler vistaAlquilers;
    private DefaultTableModel tablaAlquiler;
    private int totalregistros;

    /**
     * Constructor de la clase que enlazará el controlador con los vehiculos
     *
     * @param vistaAlquilers
     */
    public Calquiler(JFrameAlquiler vistaAlquilers) {
        this.vistaAlquilers = vistaAlquilers;
    }

    public int getTotalregistros() {
        return totalregistros;
    }

    public void setTotalregistros(int totalregistros) {
        this.totalregistros = totalregistros;
    }
    

    /**
     * Método que imprimirá los datos de la base de datos en la tabla que
     * tenemos en nuestro JFrame
     */
    public void rellenaTablaAlquiler() {

        // Creamos una nueva tabla la cual le sobreescribiremos un parámetro para que no se puedan editar las celdas.
        tablaAlquiler = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Creamos las columnas de nuestra tabla.
        tablaAlquiler.addColumn("ID Alquiler");
        tablaAlquiler.addColumn("Matricula Vehiculo");
        tablaAlquiler.addColumn("Modelo");
        tablaAlquiler.addColumn("DNI Cliente");
        tablaAlquiler.addColumn("Cliente");
        tablaAlquiler.addColumn("DNI Trabajador");
        tablaAlquiler.addColumn("Trabajador");
        tablaAlquiler.addColumn("ID Extra");
        tablaAlquiler.addColumn("Extra");
        tablaAlquiler.addColumn("Tipo de Tarifa");
        tablaAlquiler.addColumn("Fecha de Alquiler");
        tablaAlquiler.addColumn("Fecha de Recogida");
        tablaAlquiler.addColumn("Fecha de Devolución");
        tablaAlquiler.addColumn("Coste del Alquiler");
        tablaAlquiler.addColumn("Estado");

        //Creamos un Array con los datos correspondientes que extraerá de la base de datos.
        totalregistros = 0;

        Alquiler[] lista = AlquilerConsultas.consulta().listarAlquilers();
        for (Alquiler r : lista) {

            String[] datos = new String[15];
            datos[0] = String.valueOf(r.getIdAlquiler());
            datos[1] = r.getVehiculo().getMatricula();
            datos[2] = r.getVehiculo().getModelo();
            datos[3] = r.getCliente().getDni();
            datos[4] = r.getCliente().getNombre() + " " + r.getCliente().getApellidos();
            datos[5] = r.getTrabajador().getDni();
            datos[6] = r.getTrabajador().getNombre() + " " + r.getTrabajador().getApellidos();
            datos[7] = String.valueOf(r.getExtra().getIdExtra());
            datos[8] = r.getExtra().getNombre();
            datos[9] = r.getTipoTarifa();
            datos[10] = String.valueOf(r.getFechaAlquiler());
            datos[11] = String.valueOf(r.getFechaRecogida());
            datos[12] = String.valueOf(r.getFechaDevolucion());
            datos[13] = String.valueOf(r.getCostoAlquiler());
            datos[14] = r.getEstado();

            totalregistros = totalregistros + 1;
            tablaAlquiler.addRow(datos);

        }

        vistaAlquilers.setTMJTableAlquiler(tablaAlquiler);

    }

    /**
     * Metodo que revisa la fila seleccionada. Después crea un nuevo objeto e
     * inicializa la id del objeto vehiculo a la de la posición 0 de nuestra
     * tabla. Posteriormente crea una sentencia SQL y prepara un Statement para
     * que el borrado del registro sea satisfactorio. Finalmente repinta la
     * tabla.
     */
    public void borraAlquiler() {

        int seleccion = vistaAlquilers.getFilaSeleccionada();
        if (seleccion >= 0) {

            String id = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 0);
            Alquiler r = AlquilerConsultas.consulta().buscaId(Integer.parseInt(id));

            try {
                AlquilerConsultas.consulta().borrar(r);
                rellenaTablaAlquiler();
                vistaAlquilers.repaint();
                vistaAlquilers.ocultarColumnas();
            } catch (SQLException esql) {
                vistaAlquilers.muestraExcepcionSQL();
                esql.printStackTrace();
            }

        }

    }

    /**
     * Método que recoge todos los datos de la tabla y los envia a otro método
     * de la vista que se encargará de abrir un JDialog con esos datos.
     */
    public void editarAlquiler() {
        int seleccion = vistaAlquilers.getFilaSeleccionada();
        if (seleccion >= 0) {

            int idalquiler = Integer.parseInt((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 0));
            String matricula = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 1);
            String modelo = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 2);
            String dniCliente = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 3);
            String nyapCliente = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 4);
            String dniTrabajador = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 5);
            String nyapTrabajador = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 6);
            int idExtra = Integer.parseInt((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 7));
            String nombreExtra = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 8);
            String tipoTarifa = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 9);
            Date fechaAlquiler = Date.valueOf((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 10));
            Date fechaRecogida = Date.valueOf((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 11));
            Date fechaDevolucion = Date.valueOf((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 12));
            double costoAlquiler = Double.parseDouble((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 13));
            String estado = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 14);

            vistaAlquilers.abreEditarAlquiler(idalquiler, matricula, modelo, dniCliente, nyapCliente, dniTrabajador, nyapTrabajador, idExtra, nombreExtra, tipoTarifa, fechaAlquiler, fechaRecogida, fechaDevolucion, costoAlquiler, estado);

        }
    }
    
    /**
     * Método que recoge todos los datos de la tabla y los envia a otro método
     * de la vista que se encargará de abrir un JDialog con esos datos.
     */
    public void realizarfactura() {
        int seleccion = vistaAlquilers.getFilaSeleccionada();
        if (seleccion >= 0) {
            int idalquiler = Integer.parseInt((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 0));
            String estado = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 14);
                
            if(estado.equals("En Alquiler") || estado.equals("factura Eliminado")) vistaAlquilers.abreRealizarfactura(idalquiler);
            
            else vistaAlquilers.muestraExcepcionNoPuedeRealizar();
        }
    }
    
    /**
     * Método que recoge todos los datos de la tabla y los envia a otro método
     * de la vista que se encargará de abrir un JDialog con esos datos.
     */
    public void verfactura() {
        int seleccion = vistaAlquilers.getFilaSeleccionada();
        if (seleccion >= 0) {
            int idalquiler = Integer.parseInt((String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 0));
            String estado = (String) vistaAlquilers.getTMJTableAlquiler().getValueAt(seleccion, 14);
                
            if(estado.equals("Pagada")) vistaAlquilers.abreVerfactura(idalquiler);
            
            else vistaAlquilers.muestraExcepcionNoPuedeRealizar2();
        }
    }
    
    /**
     * Método para buscar por fecha de la Alquiler un objeto de tipo Alquiler
     * Este será almacenado en un arraylist que será enviado desde la consulta de la Alquiler
     * esta consulta comprobará que haya algún elemento en ese arraylist que devuelva esa fecha de Alquiler
     * @param f 
     */

    public void buscarAlquiler(Date f) {

        Alquiler[] lista = AlquilerConsultas.consulta().buscarPorFecha(f);

        if (lista != null) {

            //Borramos el contenido de la tabla
            int numero_filas = tablaAlquiler.getRowCount();

            for (int i = numero_filas - 1; i > -1; i--) {
                tablaAlquiler.removeRow(i);
            }

            totalregistros = 0;

            for (int i = 0; i < lista.length; i++) {
                if (lista[i] != null) {
                    String[] datos = new String[15];
                    datos[0] = String.valueOf(lista[i].getIdAlquiler());
                    datos[1] = lista[i].getVehiculo().getMatricula();
                    datos[2] = lista[i].getVehiculo().getModelo();
                    datos[3] = lista[i].getCliente().getDni();
                    datos[4] = lista[i].getCliente().getNombre() + " " + lista[i].getCliente().getApellidos();
                    datos[5] = lista[i].getTrabajador().getDni();
                    datos[6] = lista[i].getTrabajador().getNombre() + " " + lista[i].getTrabajador().getApellidos();
                    datos[7] = String.valueOf(lista[i].getExtra().getIdExtra());
                    datos[8] = lista[i].getExtra().getNombre();
                    datos[9] = lista[i].getTipoTarifa();
                    datos[10] = String.valueOf(lista[i].getFechaAlquiler());
                    datos[11] = String.valueOf(lista[i].getFechaRecogida());
                    datos[12] = String.valueOf(lista[i].getFechaDevolucion());
                    datos[13] = String.valueOf(lista[i].getCostoAlquiler());
                    datos[14] = lista[i].getEstado();

                    totalregistros = totalregistros + 1;
                    tablaAlquiler.addRow(datos);
                }
            }
        } else {
            vistaAlquilers.muestraExcepcionAlquilerNula();
        }
    }

}
