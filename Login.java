/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import gestock.GeStock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Login extends javax.swing.JFrame {
    
    private static ResourceBundle bundle = ResourceBundle.getBundle("seconnecter_" + GeStock.language);
    
    String userName = bundle.getString("login.username");
    String pass = bundle.getString("login.password");
    String login = bundle.getString("login.login");
    String exit = bundle.getString("login.exit");
    String title = bundle.getString("login.title");
    
    String langue;
    Connection conn = null;
    Statement stm;
    PreparedStatement pstmet = null;
    ResultSet rs = null;
    modele.Utilisateur util = null;
    JTable tbPro;
    DefaultTableModel model;

    Login(String langue) {
       this.langue = langue;
    }
    
    
    public void getConnection() {
         String serveur = "localhost";
         int port = 3306;
         String database = "gestock";
         String username = "root";
         String password = "";
         
         try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             String url = "jdbc:mysql://"+serveur+ ":" + port + "/" +database;
             conn = DriverManager.getConnection(url, username, password);
             System.out.println("Connected");
             
             //return conn;
         } catch(Exception e){
             e.printStackTrace();
         }
     }
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        jLNomUtil.setText(userName);
        jLPasse.setText(pass);
        bLogin.setText(login);
        bExit.setText(exit);
        jLtitre.setText(title);
    }
    
    
    void userVerification(String username, String password) {
        try {
            String requete ="select * from utilisateur where Username=? and Password=?";
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestock", "root", "");
            pstmet = (PreparedStatement) conn.prepareStatement(requete);
            pstmet.setString(1, username);
            pstmet.setString(2, password);
            ResultSet rs=pstmet.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Connexion reussi");
                home home = new home();
                home.show();
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Nom d'utilisateur ou Mot de passe incorrect!");
            }
        }catch(Exception e) {
            
        }
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
        jLPasse = new javax.swing.JLabel();
        jLNomUtil = new javax.swing.JLabel();
        tUsername = new javax.swing.JTextField();
        bExit = new javax.swing.JButton();
        bLogin = new javax.swing.JButton();
        labError = new javax.swing.JLabel();
        jPass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLtitre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLPasse.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLPasse.setText("Mot de passe :");
        jPanel1.add(jLPasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 210, 30));

        jLNomUtil.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLNomUtil.setText("Nom d'utilisateur :");
        jPanel1.add(jLNomUtil, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 210, 30));
        jPanel1.add(tUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 200, 40));

        bExit.setBackground(new java.awt.Color(0, 0, 0));
        bExit.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        bExit.setForeground(new java.awt.Color(255, 255, 255));
        bExit.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\GeStock\\src\\icons\\exit.png")); // NOI18N
        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });
        jPanel1.add(bExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 130, 40));

        bLogin.setBackground(new java.awt.Color(0, 0, 0));
        bLogin.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        bLogin.setForeground(new java.awt.Color(255, 255, 255));
        bLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\GeStock\\src\\icons\\login.png")); // NOI18N
        bLogin.setText("Login");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        jPanel1.add(bLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 130, 40));

        labError.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labError.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(labError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 236, 470, 30));
        jPanel1.add(jPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 162, 200, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 730, 410));

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLtitre.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 38)); // NOI18N
        jLtitre.setForeground(new java.awt.Color(255, 255, 255));
        jLtitre.setText("LOGIN");
        jPanel2.add(jLtitre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 100, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\GeStock\\src\\icons\\admin.png")); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 70, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        String username = tUsername.getText();
        String password = jPass.getText();
        
        if(username.trim().equals("")||password.trim().equals(""))
        {
            labError.setText("SVP Veillez entrer le Nom d'utilisateur et le Mot de passe !!");
        }
        else {
            userVerification(username,password);
        }
    }//GEN-LAST:event_bLoginActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExit;
    private javax.swing.JButton bLogin;
    private javax.swing.JLabel jLNomUtil;
    private javax.swing.JLabel jLPasse;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLtitre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPass;
    private javax.swing.JLabel labError;
    private javax.swing.JTextField tUsername;
    // End of variables declaration//GEN-END:variables
}