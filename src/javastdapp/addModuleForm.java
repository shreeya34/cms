/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javastdapp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author shreeya
 */
public class addModuleForm extends javax.swing.JFrame {

    /**
     * Creates new form addModuleForm
     */
    modules crs = new modules();
    public addModuleForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_modulename = new javax.swing.JTextField();
        jButton_addModule = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jComboBox_coursename = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Add Module");

        jLabel2.setText("Module Name:");

        jLabel3.setText("Course Name:");

        jButton_addModule.setBackground(new java.awt.Color(0, 51, 51));
        jButton_addModule.setForeground(new java.awt.Color(242, 242, 242));
        jButton_addModule.setText("Add Module");
        jButton_addModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addModuleActionPerformed(evt);
            }
        });

        jButton_cancel.setBackground(new java.awt.Color(0, 51, 51));
        jButton_cancel.setForeground(new java.awt.Color(242, 242, 242));
        jButton_cancel.setText("Cancel");
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

        jComboBox_coursename.setModel(this.get_courses());
        jComboBox_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_coursenameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_modulename)
                            .addComponent(jComboBox_coursename, 0, 153, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButton_addModule)
                        .addGap(27, 27, 27)
                        .addComponent(jButton_cancel)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_modulename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_coursename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_addModule)
                    .addComponent(jButton_cancel))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addModuleActionPerformed
        if(!crs.ismodulesExist(jTextField_modulename.getText())){
            String module_name = jTextField_modulename.getText();
            String course_name = jComboBox_coursename.getSelectedItem().toString();
            // int hours = Integer.valueOf(jSpinner_courseHours.getValue().toString());
            crs.insertUpdateDeletemodules('i', null, module_name, course_name );
            try {
                Adminmodule asc = new Adminmodule();
                asc.setVisible(true);
                asc.pack();
                asc.setLocationRelativeTo(null);
                asc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
                // manageCourseForm.jTable1.setModel(new DefaultTableModel(null,new Object[]{"Id","Label","Hours"}));
                // crs.Fill_Course_Table(manageCourseForm.jTable1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton_addModuleActionPerformed

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jComboBox_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_coursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_coursenameActionPerformed

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
            java.util.logging.Logger.getLogger(addModuleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addModuleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addModuleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addModuleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addModuleForm().setVisible(true);
            }
        });
    }

    public DefaultComboBoxModel get_courses(){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
       // jComboBox_coursename.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BIT", "BBA", "BIBM" }));

        DefaultComboBoxModel courses = new javax.swing.DefaultComboBoxModel<>(new String[] {});
        try{
          ps = con.prepareStatement("SELECT name FROM `course`");
          ResultSet rs =ps.executeQuery();        
          while(rs.next())
              {
               
                String course_name = rs.getString(1);               
                courses.addElement(course_name);
              }
          } catch (SQLException ex) {
                Logger.getLogger(course.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return courses;
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addModule;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JComboBox<String> jComboBox_coursename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField_modulename;
    // End of variables declaration//GEN-END:variables
}

