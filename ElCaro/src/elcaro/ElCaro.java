/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcaro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Alexy Cruz
 */
public class ElCaro extends javax.swing.JFrame {

    /**
     * Creates new form ElCaro
     */
    public ElCaro() {
        initComponents();
        /*try {
            
            String Direccion = "./nuevo.txt";
            File Archivo = null;
            Archivo = new File(Direccion);
            try {
                RandomAccessFile RAF = new RandomAccessFile(Archivo, "rw");
                RAF.writeBytes("mi mama me mima");

                RAF.seek(5);
                String Nueva = "Mi mama no me mima";
                RAF.writeBytes(Nueva);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_Crear = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jsp_ARLF_NumeroCampos = new javax.swing.JSpinner();
        jsp_ARLF_LongitudCampos = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_ARLF_ModificarTabla = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nombre_arlf = new javax.swing.JTextField();
        jpm_Menu1 = new javax.swing.JPopupMenu();
        jpm1_Menu1_Modificar = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("Numero de campos");

        jLabel2.setText("Longitud de campos");

        jLabel3.setText("CREAR TABLA");

        jButton5.setText("Crear Tabla");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jt_ARLF_ModificarTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jt_ARLF_ModificarTabla.setCellSelectionEnabled(true);
        jt_ARLF_ModificarTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_ARLF_ModificarTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jt_ARLF_ModificarTabla);

        jButton6.setText("AGREGAR CAMPO");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jLabel4.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jsp_ARLF_NumeroCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jsp_ARLF_LongitudCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nombre_arlf, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nombre_arlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jsp_ARLF_NumeroCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jsp_ARLF_LongitudCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("ARLF", jPanel1);

        javax.swing.GroupLayout jd_CrearLayout = new javax.swing.GroupLayout(jd_Crear.getContentPane());
        jd_Crear.getContentPane().setLayout(jd_CrearLayout);
        jd_CrearLayout.setHorizontalGroup(
            jd_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jd_CrearLayout.setVerticalGroup(
            jd_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jpm1_Menu1_Modificar.setText("Modificar");
        jpm1_Menu1_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpm1_Menu1_ModificarActionPerformed(evt);
            }
        });
        jpm_Menu1.add(jpm1_Menu1_Modificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Crear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Modificar");

        jButton3.setText("Eliminar");

        jButton4.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(326, 326, 326))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        jd_Crear.setModal(true);
        jd_Crear.pack();
        jd_Crear.setLocationRelativeTo(this);
        jd_Crear.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        if (contador_arlf < 1) {
            contador_arlf++;
            String Direccion = nombre_arlf.getText() + ".txt";
            fijo_fijo.setDireccion(Direccion);
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            try {
                RAF = new RandomAccessFile(Archivo, "rw");
                RAF.writeBytes(jsp_ARLF_NumeroCampos.getValue().toString());
                RAF.seek(RAF.length());
                RAF.writeBytes(";");
                RAF.writeBytes(jsp_ARLF_LongitudCampos.getValue().toString());
                RAF.seek(RAF.length());
                RAF.writeBytes(";");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            }

            DefaultTableModel Modelo = new DefaultTableModel();
            int NumeroCampos = (int) (jsp_ARLF_NumeroCampos.getValue());

            for (int i = 0; i < NumeroCampos; i++) {
                String NombreCampo = JOptionPane.showInputDialog(jd_Crear,
                        "Ingrese el nombre del campo", "NOMBRE DE CAMPO", JOptionPane.INFORMATION_MESSAGE);
                Modelo.addColumn(NombreCampo);
                try {
                    RAF.seek(RAF.length());
                    RAF.writeBytes(NombreCampo);
                    RAF.writeBytes(";");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            jt_ARLF_ModificarTabla.setModel(Modelo);
        } else {
            JOptionPane.showMessageDialog(jd_Crear, "Ya se ha creado una tabla!");
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jt_ARLF_ModificarTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_ARLF_ModificarTablaMouseClicked
        // TODO add your handling code here:
        int Row = jt_ARLF_ModificarTabla.getSelectedRow();
        int Column = jt_ARLF_ModificarTabla.getSelectedColumn();

        if (evt.isMetaDown() && jt_ARLF_ModificarTabla.getSelectedRow() != -1) {

            DefaultTableModel Modelo = (DefaultTableModel) jt_ARLF_ModificarTabla.getModel();

            jpm_Menu1.show(evt.getComponent(), evt.getX(),
                    evt.getY());
        }

        System.out.println(Row + " " + Column);
    }//GEN-LAST:event_jt_ARLF_ModificarTablaMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        int RevisarCampos = 0;
        DefaultTableModel ModeloTabla = (DefaultTableModel) jt_ARLF_ModificarTabla.getModel();
        Object[] Row = new Object[jt_ARLF_ModificarTabla.getColumnCount()];
        ArrayList<String> Campos = new ArrayList();
        for (int i = 0; i < jt_ARLF_ModificarTabla.getColumnCount(); i++) {
            String Campo = JOptionPane.showInputDialog(jd_Crear, "Ingrese el " + jt_ARLF_ModificarTabla.getModel().getColumnName(i),
                    jt_ARLF_ModificarTabla.getModel().getColumnName(i), JOptionPane.INFORMATION_MESSAGE);

            Campos.add(Campo);
        }
        for (int i = 0; i < Campos.size(); i++) {
            if (Campos.get(i).length() > Integer.parseInt(fijo_fijo.TamañoCampo())) {
                RevisarCampos++;
            } else if (Campos.get(i).length() > Integer.parseInt(fijo_fijo.TamañoCampo())) {
                RevisarCampos++;
            }
        }

        if (RevisarCampos == 0) {
            for (int i = 0; i < Campos.size(); i++) {
                System.out.println(fijo_fijo.TamañoCampo());
                if (Campos.get(i).length() < Integer.parseInt(fijo_fijo.TamañoCampo())) {
                    Row[i] = Campos.get(i);
                    for (int j = 0; j < Integer.parseInt(fijo_fijo.TamañoCampo()) - Campos.get(i).length(); j++) {
                        Row[i] = Row[i] + "-";
                    }
                } else {
                    Row[i] = Campos.get(i);
                }
                File Archivo = null;
                Archivo = new File(fijo_fijo.getDireccion());
                RandomAccessFile RAF = null;
                try {
                    RAF = new RandomAccessFile(Archivo, "rw");
                    fijo_fijo.Agregar(Row[i].toString(), RAF.length());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (i == Campos.size() - 1) {
                    ModeloTabla.addRow(Row);
                }

            }
            JOptionPane.showMessageDialog(jd_Crear, "Se Agrego un Registro");
        } else {
            JOptionPane.showMessageDialog(jd_Crear, "No se pudo agregar registro");
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jpm1_Menu1_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpm1_Menu1_ModificarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ModeloTabla = (DefaultTableModel) jt_ARLF_ModificarTabla.getModel();

        String Campo = ModeloTabla.getColumnName(jt_ARLF_ModificarTabla.getSelectedColumn());

        String ModificarCampo = JOptionPane.showInputDialog(jd_Crear, "Ingrese el " + Campo, Campo.toUpperCase(),
                JOptionPane.INFORMATION_MESSAGE);
        int Concatenar = Integer.parseInt(fijo_fijo.TamañoCampo()) - ModificarCampo.length();
        for (int j = 0; j < Concatenar; j++) {
            ModificarCampo += "-";
        }

        if (ModificarCampo.length() <= Integer.parseInt(fijo_fijo.TamañoCampo())) {
            jt_ARLF_ModificarTabla.setValueAt(ModificarCampo, jt_ARLF_ModificarTabla.getSelectedRow(),
                    jt_ARLF_ModificarTabla.getSelectedColumn());

            File Archivo = null;
            Archivo = new File(fijo_fijo.getDireccion());
            RandomAccessFile RAF = null;
            try {
                RAF = new RandomAccessFile(Archivo, "rw");
                String TamañoCampo = "";
                int ContadorDelimitador = 0;
                for (int i = 0; i < RAF.length(); i++) {
                    RAF.seek(i);
                    char TamañoCampoTemp = (char) RAF.readByte();
                    if (TamañoCampoTemp != ';') {
                        if (ContadorDelimitador == 4) {
                            int Posicion = (jt_ARLF_ModificarTabla.getSelectedRow()
                                    * Integer.parseInt(fijo_fijo.NumeroCampos())
                                    * Integer.parseInt(fijo_fijo.TamañoCampo()))
                                    + (jt_ARLF_ModificarTabla.getSelectedColumn()
                                    * Integer.parseInt(fijo_fijo.TamañoCampo()));
                            RAF.seek(i + Posicion);
                            RAF.writeBytes(ModificarCampo);
                            ContadorDelimitador++;
                        }
                    } else {
                        ContadorDelimitador++;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(jd_Crear, "No se pudo modificar campo");
        }
    }//GEN-LAST:event_jpm1_Menu1_ModificarActionPerformed

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
            java.util.logging.Logger.getLogger(ElCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElCaro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JDialog jd_Crear;
    private javax.swing.JMenuItem jpm1_Menu1_Modificar;
    private javax.swing.JPopupMenu jpm_Menu1;
    private javax.swing.JSpinner jsp_ARLF_LongitudCampos;
    private javax.swing.JSpinner jsp_ARLF_NumeroCampos;
    private javax.swing.JTable jt_ARLF_ModificarTabla;
    private javax.swing.JTextField nombre_arlf;
    // End of variables declaration//GEN-END:variables
int contador_arlf = 0;
    ARLF fijo_fijo = new ARLF();
}
