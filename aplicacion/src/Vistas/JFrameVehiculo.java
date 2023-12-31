/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.Cvehiculo;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 * JFrame de Vehiculo del Programa.
 * Está clase contiene los constructores y métodos de creación de la Vista
 * de JFrame de Vehiculo. Este frame se llama desde el Escritorio del programa.
 * Esta ventana tiene por función mostrar una tabla con la lista de Vehiculo
 * y unos botones para añadirlos, editarlos o borrarlos.
 * @author grupo2
 */
public class JFrameVehiculo extends javax.swing.JFrame {

    private Cvehiculo controladorVehiculos;

    /**
     * Creates new form JFrameVehiculo
     */
    public JFrameVehiculo() {
        
        initComponents();
        
        // Declaramos el degault operation para que al cerrar la ventana no salga de la aplicación
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        
        // declaramos el controlador
        controladorVehiculos = new Cvehiculo(this);

        // pintará la tabla
        controladorVehiculos.rellenaTablaVehiculos();
        
        // oculta la columna de la ID
        ocultarColumnaId();
        
        // cambia el texto de registros por el total de registros encontrados
        jLabelTotalRegistros.setText("Total Registros " + controladorVehiculos.getTotalregistros() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListado = new javax.swing.JTable();
        jLabelVehiculos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaVehiculos = new javax.swing.JTable();
        jLabelTotalRegistros = new javax.swing.JLabel();
        jLabelBuscar = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonNuevo1 = new javax.swing.JButton();
        jMenuVehiculos = new javax.swing.JMenuBar();

        jTableListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableListado);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelVehiculos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVehiculos.setText("Vehiculos");

        jPanel1.setBackground(new java.awt.Color(57, 92, 120));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)), "Listado de Vehiculos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jTableListaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableListaVehiculos);

        jLabelTotalRegistros.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalRegistros.setText("Total de Registros:");

        jLabelBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBuscar.setText("Buscar:");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(255, 232, 66));
        jButtonBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/buscar.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(255, 232, 66));
        jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/nuevo.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(255, 232, 66));
        jButtonEliminar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/borrar.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonNuevo1.setBackground(new java.awt.Color(255, 232, 66));
        jButtonNuevo1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/nuevo2.png"))); // NOI18N
        jButtonNuevo1.setText("Nuevo");
        jButtonNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonEliminar)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonNuevo1)
                        .addGap(0, 8, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTotalRegistros)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBuscar)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonNuevo1))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTotalRegistros)
                .addContainerGap())
        );

        setJMenuBar(jMenuVehiculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelVehiculos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
    }//GEN-LAST:event_jTableListadoMouseClicked

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "Va a eliminar un vehiculo ¿Está seguro?",
                "Eliminar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (confirmacion == 0) {
            controladorVehiculos.borraVehiculo();
            jLabelTotalRegistros.setText("Total Registros " + controladorVehiculos.getTotalregistros());
        }

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try {
            controladorVehiculos.editarVehiculo();
            jLabelTotalRegistros.setText("Total Registros " + controladorVehiculos.getTotalregistros() );
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(rootPane, "No hay datos");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        
        controladorVehiculos.setTotalregistros(0);
        controladorVehiculos.buscarVehiculo(jTextFieldBuscar.getText());  
        jLabelTotalRegistros.setText("Total Registros " + controladorVehiculos.getTotalregistros());

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyPressed
        
        if( evt.getKeyCode() == KeyEvent.VK_ENTER ) {
            controladorVehiculos.setTotalregistros(0);
            controladorVehiculos.buscarVehiculo(jTextFieldBuscar.getText());  
            jLabelTotalRegistros.setText("Total Registros " + controladorVehiculos.getTotalregistros());
        }
        
    }//GEN-LAST:event_jTextFieldBuscarKeyPressed

    private void jButtonNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevo1ActionPerformed
          // Creamos un nuevo JDialog de tipo Vehiculo
        JDialog dialog = new JDVehiculo(JFrameVehiculo.this, true, true);
        // Creamos un WindowListener, que no hará más que escuchar para un posible evento de ventana
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            //llamamos al metodo windowClosed que hará algo cuando la ventana que escuchamos se cierre, en este caso el JDialog
            public void windowClosed(WindowEvent evt) {
                // El metodo rellenatabla actualizará la tabla
                controladorVehiculos.rellenaTablaVehiculos();
                ocultarColumnaId();
                jLabelTotalRegistros.setText("Total Registros " + controladorVehiculos.getTotalregistros());
            }
        });
        // hacemos visible la ventana JDClientes
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonNuevo1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonNuevo1;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelTotalRegistros;
    private javax.swing.JLabel jLabelVehiculos;
    private javax.swing.JMenuBar jMenuVehiculos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListaVehiculos;
    private javax.swing.JTable jTableListado;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables

    /**
     * Método que oculta la columna de la ID puesto que el usuario no 
     * debe de poder editar la ID de nuestro registro.
     */
    public void ocultarColumnaId() {
        jTableListaVehiculos.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableListaVehiculos.getColumnModel().getColumn(0).setMinWidth(0);
        jTableListaVehiculos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    /**
     * Desde el controlador enviamos el modelo por defecto de la tabla.
     *
     * @param tm
     */
    public void setTMJTableVehiculos(TableModel tm) {
        jTableListaVehiculos.setModel(tm);
    }

    /**
     * Tenemos también un método get por si necesitamos que nos devuelva el
     * modelo.
     *
     * @return modelo de la tabla
     */
    public TableModel getTMJTableVehiculos() {
        return jTableListaVehiculos.getModel();
    }

    /**
     * Metodo que nos devuelve la fila que hemos seleccionado en la tabla. En
     * caso de no seleccionar fila muestra error.
     *
     * @return devuelve la fila seleccionada, menos uno si no se ha seleccionado
     */
    public int getFilaSeleccionada() {

        if (jTableListaVehiculos.getSelectedRowCount() > 0) {
            return jTableListaVehiculos.getSelectedRow();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione al menos una fila", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    /**
     * Este método recoge los datos extraidos de la tabla en el controlador y
     * los envia hacia un JDialog nuevo. Además añade un listener para que
     * cuando se cierre la ventana segun hayamos programado repintará la tabla
     *
     * @param id
     * @param matricula
     * @param modelo
     * @param caracteristicas
     * @param estado
     * @param tipo
     * @param precio
     *
     */
    public void AbreEditarVehiculo(int id, String matricula, String modelo, String caracteristicas, double precio, String estado, String tipo) {
        // Creamos un nuevo JDialog de tipo cliente
        JDialog dialog = new JDVehiculo(id, matricula, modelo, caracteristicas, precio, estado, tipo, JFrameVehiculo.this, true);
        // Creamos un WindowListener, que no hará más que escuchar para un posible evento de ventana
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            //llamamos al metodo windowClosed que hará algo cuando la ventana que escuchamos se cierre, en este caso el JDialog
            public void windowClosed(WindowEvent evt) {
                // El metodo rellenatabla actualizará la tabla
                controladorVehiculos.rellenaTablaVehiculos();
                ocultarColumnaId();
            }
        });
        // hacemos visible la ventana JDClientes
        dialog.setVisible(true);
    }
    
    /**
     * Método que muestra una excepción de sql
     */
    public void muestraExcepcionSQL() {
        JOptionPane.showMessageDialog(this, "Error en introducción de datos SQL", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Método que muestra una excepción de sql
     */
    public void muestraExcepcionVehiculoNulo() {
        JOptionPane.showMessageDialog(this, "No se ha encontrado el vehiculo con ese modelo", "Error en Vehiculo", JOptionPane.ERROR_MESSAGE);
    }

}
