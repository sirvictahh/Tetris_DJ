/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tetris.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;


/**
 *
 * @author IPT
 */
public class MainApp extends javax.swing.JFrame {
    private boolean isBtPlayActivated = false;
    private Clip currentClip;

    /**
     * Creates new form MainApp
     */
    public MainApp() {
        initComponents();
        setLocationRelativeTo(null);
        playSound("/tetris/resources/sounds/menu.wav");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btPlay = new javax.swing.JButton();
        btAbout1 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TETRIS D&J");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 43, 91));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(228, 220, 207));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/tetris01.png"))); // NOI18N
        jLabel1.setText("    TETRIS D&J");

        jPanel2.setBackground(new java.awt.Color(0, 43, 91));
        jPanel2.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        btPlay.setBackground(new java.awt.Color(249, 245, 235));
        btPlay.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btPlay.setForeground(new java.awt.Color(234, 84, 85));
        btPlay.setText("Play");
        btPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlayActionPerformed(evt);
            }
        });
        jPanel2.add(btPlay);

        btAbout1.setBackground(new java.awt.Color(249, 245, 235));
        btAbout1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btAbout1.setForeground(new java.awt.Color(234, 84, 85));
        btAbout1.setText("Rules");
        btAbout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAbout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbout1ActionPerformed(evt);
            }
        });
        jPanel2.add(btAbout1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlayActionPerformed
        isBtPlayActivated = true;
        dispose(); // Close the MainApp window
        stopSound();
        
        java.awt.EventQueue.invokeLater(() -> {
            GraphicsTetrisDialog graphicsDialog = new GraphicsTetrisDialog(MainApp.this, true);
            graphicsDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (!isVisible()) {
                        new MainApp().setVisible(true);
                    }
                }
            });
            graphicsDialog.setVisible(true);
        });
       
        isBtPlayActivated = false;
        
    }//GEN-LAST:event_btPlayActionPerformed

    
    private void playSound(String soundFilePath) {
        
        try {
            if (isBtPlayActivated) {
                return; // Exit the method without playing the sound
            }
            stopSound(); // Stop any currently playing sound

            // Obtain the audio input stream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundFilePath));

            // Get the audio format
            AudioFormat audioFormat = audioInputStream.getFormat();

            // Create a data line info with the audio format
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);

            // Open the audio line
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
            
            // Set the loop count to indefinitely loop the sound
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Assign the current clip
            currentClip = clip;

            // Start playing the audio clip
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void stopSound() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop();
        }
    }
    
    private void btAbout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbout1ActionPerformed
        new RulesDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btAbout1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/tetris/resources/tetris01.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbout1;
    private javax.swing.JButton btPlay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
