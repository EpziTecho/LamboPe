/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CJDTrabajador;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * JDialog de Trabajador del Programa.
 * Está clase contiene los constructores y métodos de creación de la Vista
 * de JDialog de Trabajador. Este dialog será una ventana que se abre desde el JFrame de Trabajador.
 * La función de esta ventana es la de introducir o editar Trabajadores.
 * @author  grupo2
 */
public class JDTrabajador extends javax.swing.JDialog {
    
    private CJDTrabajador controladorTrabajador;
    private boolean funcion = false;

    /**
     * Creates new form JDTrabajador
     */
    public JDTrabajador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controladorTrabajador = new CJDTrabajador(this);
    }

    public JDTrabajador(java.awt.Frame parent, boolean modal, boolean funcion) {
        super(parent, modal);
        initComponents();
        setFuncion(funcion);
        controladorTrabajador = new CJDTrabajador(this);
    }

    /**
     * Creamos un constructor para el JDialog que se le puedan pasar los
     * parametros desde el JFrame de vehiculo. Esto servirá para editar
     *
     * @param dni
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param telefono
     * @param parent
     * @param sueldo
     * @param acceso
     * @param usuario
     * @param contrasena
     * @param email
     * @param estado
     * @param modal
     */
    public JDTrabajador(String dni, String nombre, String apellidos, String direccion, int telefono, String email, String acceso, String usuario, String contrasena, String estado, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controladorTrabajador = new CJDTrabajador(this);

        jTextFieldDni.setText(dni);
        jTextFieldNombre.setText(nombre);
        jTextFieldApellidos.setText(apellidos);
        jTextFieldDireccion.setText(direccion);
        jTextFieldTelefono.setText(String.valueOf(telefono));
        jTextFieldEmail.setText(email);
        jComboBoxAcceso.setSelectedItem(acceso);
        jTextFieldUsuario.setText(usuario);
        jTextFieldContrasena.setText(contrasena);
        jComboBoxEstado.setSelectedItem(estado);
        
        // desactiva el campo dni cuando sea la opcion editar
        jTextFieldDni.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelAcceso = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelContraseña = new javax.swing.JLabel();
        jTextFieldContrasena = new javax.swing.JTextField();
        jLabelEstado = new javax.swing.JLabel();
        jComboBoxAcceso = new javax.swing.JComboBox<>();
        jComboBoxEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Datos de Trabajador");

        jPanel1.setBackground(new java.awt.Color(57, 92, 120));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Datos de los trabajadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButtonGuardar.setBackground(new java.awt.Color(255, 232, 66));
        jButtonGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/guardar.gif"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(255, 232, 66));
        jButtonLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/borrar.png"))); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 232, 66));
        jButtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");

        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("Email:");

        jLabelDni.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDni.setText("DNI:");

        jLabelApellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellidos.setText("Apellidos:");

        jLabelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDireccion.setText("Dirección:");

        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Teléfono:");

        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jLabelAcceso.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAcceso.setText("Acceso:");

        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario:");

        jLabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContraseña.setText("Contraseña:");

        jLabelEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstado.setText("Estado:");

        jComboBoxAcceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Digitador" }));

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "D" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombre)
                    .addComponent(jButtonGuardar)
                    .addComponent(jLabelDni)
                    .addComponent(jLabelApellidos)
                    .addComponent(jLabelDireccion)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelAcceso)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabelContraseña)
                    .addComponent(jLabelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonLimpiar)
                        .addGap(48, 48, 48)
                        .addComponent(jButtonCancelar))
                    .addComponent(jTextFieldUsuario)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jTextFieldTelefono)
                    .addComponent(jTextFieldDireccion)
                    .addComponent(jTextFieldApellidos)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldDni)
                    .addComponent(jComboBoxAcceso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldContrasena))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDni))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAcceso))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelContraseña))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        if (getDni().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes introducir un DNI", "Error DNI", JOptionPane.ERROR_MESSAGE);
            jTextFieldDni.requestFocus();
            return;
        }

        if (getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes introducir un Nombre", "Error nombre", JOptionPane.ERROR_MESSAGE);
            jTextFieldNombre.requestFocus();
            return;
        }

        if (getApellidos().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes introducir almenos un Apellido", "Error Apellidos", JOptionPane.ERROR_MESSAGE);
            jTextFieldApellidos.requestFocus();
            return;
        }
               
        if (getUsuario().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes introducir un Usuario", "Error Usuario", JOptionPane.ERROR_MESSAGE);
            jTextFieldUsuario.requestFocus();
            return;
        }
        
        if (getContrasena().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes introducir una Clave", "Error Contraseña", JOptionPane.ERROR_MESSAGE);
            jTextFieldContrasena.requestFocus();
            return;
        }

        // Si el metodo ha devuelto true se cierra la ventana, sino permanece en ella.
        if (controladorTrabajador.guardar() == true) {
            this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

        jTextFieldDni.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldEmail.setText("");

    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        this.setVisible(false);
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped

        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
            || (caracter > '9'))
        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
        evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(JDTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDTrabajador dialog = new JDTrabajador(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxAcceso;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabelAcceso;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldContrasena;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    public String getDni() {
        return jTextFieldDni.getText();
    }
    
    public String getNombre() {
        return jTextFieldNombre.getText();
    }

    public String getApellidos() {
        return jTextFieldApellidos.getText();
    }

    public String getDireccion() {
        return jTextFieldDireccion.getText();
    }
    
    public String getTelefono() {
        return jTextFieldTelefono.getText();
    }
    
    public String getEmail() {
        return jTextFieldEmail.getText();
    }
    
    public String getacceso() {
        String acceso = (String) jComboBoxAcceso.getSelectedItem();

        return acceso;
    }

    public String getUsuario() {
        return jTextFieldUsuario.getText();
    }

    public String getContrasena() {
        return jTextFieldContrasena.getText();
    }
    
    public String getEstado() {
        String estado = (String) jComboBoxEstado.getSelectedItem();

        return estado;
    }

    public boolean getFuncion() {
        return funcion;
    }

    public void setFuncion(boolean funcion) {
        this.funcion = funcion;
    }

    /**
     * Método que muestra una excepción de sql
     */
    public void muestraExcepcion() {
        JOptionPane.showMessageDialog(this, "Error en introducción de datos SQL", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void excepcionDNI() {
        JOptionPane.showMessageDialog(this, "El dni introducido ya existe, introduzca otro", "Error DNI", JOptionPane.ERROR_MESSAGE);
    }
    
    public void excepcionDNI2() {
        JOptionPane.showMessageDialog(this, "El dni introducido es invalido", "Error DNI", JOptionPane.ERROR_MESSAGE);
    }

}
