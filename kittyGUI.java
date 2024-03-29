/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KittyGame;
import java.applet.*;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author JWONG
 */
public class kittyGUI extends javax.swing.JFrame {

    private AudioClip introSong;
    
    /**
     * Creates new form kittyGUI
     */
    public kittyGUI() {
        initComponents();
        introSong = Applet.newAudioClip(this.getClass().getResource("introSong.wav"));
        introSong.loop();
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kitty Catcher");
        setPreferredSize(new java.awt.Dimension(783, 437));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton3.setText("Controls");
        getContentPane().add(jButton3);
        jButton3.setBounds(290, 360, 210, 30);
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null,"Left Arrow - Move Left" + "\n" + "Down Arrow - Shield" + "\n" + "Right Arrow - Move Right");
            }
        });

        jButton1.setText("Play!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 360, 200, 30);

        jButton2.setText("Quit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(550, 360, 200, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KittyGame/introGUI.gif"))); // NOI18N
        jLabel2.setLabelFor(jLabel2);
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(560, 438));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 830, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        InputStream music;
        try{
        music = new FileInputStream(new File("src\\kittycatcher\\introSong.wav"));
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Thread gameThread = new Thread(){
            public void run(){
                KittyDriver g = new KittyDriver();
                g.start(60);
                
                try{
                    Thread.sleep(1000 / 60);
                }catch(Exception e){
                    e.printStackTrace();
                }
               
            }
            
        };
        gameThread.start();
        this.setVisible(false);
        this.dispose();
        introSong.stop();
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(kittyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kittyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kittyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kittyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new kittyGUI().setVisible(true);
                
                
                
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
