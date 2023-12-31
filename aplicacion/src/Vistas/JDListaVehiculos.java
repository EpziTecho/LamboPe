/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CJDListaVehiculos;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 * JDialog de Lista de Vehiculos del Programa.
 * Está clase contiene los constructores y métodos de creación de la Vista
 * de JDialog de Listar Vehiculos. Este dialog será una ventana que se abre desde
 * el JDialog de Alquilers.
 * La función de esta ventana es la de seleccionar el vehiculo deseado de una tabla.
 * @author  grupo2
 */
public class JDListaVehiculos extends javax.swing.JDialog {

    private CJDListaVehiculos controladorMuestraVehiculos;
    
    /**
     * Creates new form VistaVehiculos
     */
    public JDListaVehiculos(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        controladorMuestraVehiculos = new CJDListaVehiculos(this);
        controladorMuestraVehiculos.rellenaTablaVehiculos();
        ocultarColumnaId();
        
        // cambia el texto de registros por el total de registros encontrados
        jLabelTotalRegistros.setText("Total Registros " + controladorMuestraVehiculos.getTotalregistros());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaVehiculos = new javax.swing.JTable();
        jLabelTotalRegistros = new javax.swing.JLabel();
        jLabelBuscar = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(57, 92, 120));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)), "Listado de Vehiculos disponibles en este momento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

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
        jTableListaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableListaVehiculosMousePressed(evt);
            }
        });
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTotalRegistros)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonBuscar)
                        .addGap(36, 307, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBuscar)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotalRegistros)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        controladorMuestraVehiculos.setTotalregistros(0);
        controladorMuestraVehiculos.buscarVehiculo(jTextFieldBuscar.getText());
        jLabelTotalRegistros.setText("Total Registros " + controladorMuestraVehiculos.getTotalregistros());
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTableListaVehiculosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaVehiculosMousePressed
        
        // iniciamos un evento de veces de clicado en un elemento, para que sea igual a dos
        if (evt.getClickCount() == 2) {
            controladorMuestraVehiculos.vehiculoAControlador();
            this.dispose();   
        }
        
        
    }//GEN-LAST:event_jTableListaVehiculosMousePressed

    private void jTextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyPressed
        
        if( evt.getKeyCode() == KeyEvent.VK_ENTER ) {
            controladorMuestraVehiculos.setTotalregistros(0);
            controladorMuestraVehiculos.buscarVehiculo(jTextFieldBuscar.getText());
            jLabelTotalRegistros.setText("Total Registros " + controladorMuestraVehiculos.getTotalregistros());
        }
        
    }//GEN-LAST:event_jTextFieldBuscarKeyPressed

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
            java.util.logging.Logger.getLogger(JDListaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDListaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDListaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDListaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDListaVehiculos dialog = new JDListaVehiculos(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelTotalRegistros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaVehiculos;
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
    
     public int getFilaSeleccionada() {
        return jTableListaVehiculos.getSelectedRow();
     }
     
     /**
     * Método que muestra una excepción de sql
     */
    public void muestraExcepcionVehiculoNulo() {
        JOptionPane.showMessageDialog(this, "No se ha encontrado el vehiculo con ese modelo", "Error en Vehiculo", JOptionPane.ERROR_MESSAGE);
    }

}
