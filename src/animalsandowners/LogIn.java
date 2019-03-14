/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsandowners;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogIn extends javax.swing.JFrame {

    public LogIn() {
        this.getContentPane().setBackground(Color.WHITE);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().setLayout(null);

        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 170, 110, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(260, 100, 185, 20);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(260, 130, 185, 20);

        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 100, 90, 20);

        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 130, 90, 20);

        jLabel4.setFont(new java.awt.Font("Pristina", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("Julie's Animal Sanctuary");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 30, 360, 53);

        jButton2.setText("New User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 210, 110, 23);

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(440, 270, 90, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 0, 233, 287);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //NEED TO RegEx the username and MD5 Hash the password
        String enteredPassword = new String(jPasswordField1.getPassword());
        String enteredUsername = jTextField1.getText();
        boolean validLogin = false;

        if (globals.regExCheck(enteredUsername, globals.emailRegEx)) {
            try {

                ResultSet rs = globals.database("SELECT * FROM ADMIN1.USERS where username =?", enteredUsername);
                while (rs.next()) {
                    String password = rs.getString("Password");

                    //Check to see if password is correct
                    if (enteredPassword.equals(password)) {
                        validLogin = true;
                        MainMenu m = new MainMenu();
                        m.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Password does not match stored password");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnimalsAndOwners.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The email address is not a valid email address");
        }
        if(!validLogin){
            JOptionPane.showMessageDialog(null, "Invalid log on details");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NewUser n = new NewUser();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
