/*
 * This file is part of the auxiliaries of Greta.
 *
 * Greta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Greta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Greta.  If not, see <https://www.gnu.org/licenses/>.
 *
 */
package greta.auxiliary.socialparameters.gui;

import greta.auxiliary.socialparameters.SocialDimension;
import greta.auxiliary.socialparameters.SocialParameterEmitter;
import greta.auxiliary.socialparameters.SocialParameterEmitterImpl;
import greta.auxiliary.socialparameters.SocialParameterFrame;
import greta.auxiliary.socialparameters.SocialParameterPerformer;
import greta.core.util.Constants;
import greta.core.util.animationparameters.APFrameList;
import greta.core.util.id.ID;
import greta.core.util.id.IDProvider;
import greta.core.util.time.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author Andre-Marie Pez
 */
public class InterpersonalCircumplexFrame extends javax.swing.JFrame implements SocialParameterPerformer, SocialParameterEmitter{

    private InterpersonalCircumplexPanel circumplexPanel;
    private SocialParameterEmitterImpl performers = new SocialParameterEmitterImpl();
    private APFrameList<SocialParameterFrame> framesReceived = new APFrameList<SocialParameterFrame>(new SocialParameterFrame());

    public boolean killed = false;

    /**
     * Creates new form InterpersonalCircumplexFrame
     */
    public InterpersonalCircumplexFrame() {
        circumplexPanel = new InterpersonalCircumplexPanel();
        MouseAdapter mouseListener = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                edit(e.getX(), e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                edit(e.getX(), e.getY());
            }

            private void edit(int x, int y){
                if(jCheckBox1.isSelected()){
                    SocialParameterFrame frame = new SocialParameterFrame(Timer.getCurrentFrameNumber());
                    frame.setDoubleValue(SocialDimension.Liking, circumplexPanel.getLikingAt(x));
                    frame.setDoubleValue(SocialDimension.Dominance, circumplexPanel.getDominanceAt(y));
                    circumplexPanel.setSocialParameterFrame(frame);
                    performers.sendSocialParameter(IDProvider.createID(this.getClass().getSimpleName()), frame);
                }
            }
        };

        circumplexPanel.addMouseListener(mouseListener);
        circumplexPanel.addMouseMotionListener(mouseListener);
        initComponents();

        Thread refreshFrame = new Thread(){

            @Override
            public void run() {
                while(! killed){
                    if( ! jCheckBox1.isSelected()){
                        circumplexPanel.setSocialParameterFrame(framesReceived.getCurrentFrame());
                        Timer.sleep(Constants.FRAME_DURATION_MILLIS);
                    }
                    else{
                        Timer.sleep(Constants.FRAME_DURATION_MILLIS*4);
                    }
                }
            }

        };
        refreshFrame.start();
    }


    @Override
    protected void finalize() throws Throwable {
        killed = true;
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = circumplexPanel;

        jCheckBox1.setText("Edit");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 337, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(InterpersonalCircumplexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterpersonalCircumplexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterpersonalCircumplexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterpersonalCircumplexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterpersonalCircumplexFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void performSocialParameter(List<SocialParameterFrame> frames, ID requestId) {
        framesReceived.addFrames(frames);
        if(! jCheckBox1.isSelected()) {
            performers.sendSocialParameters(requestId, frames);
        }
    }

    @Override
    public void addSocialParameterPerformer(SocialParameterPerformer performer) {
        performers.addSocialParameterPerformer(performer);
    }

    @Override
    public void removeSocialParameterPerformer(SocialParameterPerformer performer) {
        performers.removeSocialParameterPerformer(performer);
    }

    public void setEditMode(boolean edit){
        jCheckBox1.setSelected(edit);
    }

    public boolean isEditMode(){
        return jCheckBox1.isSelected();
    }
}
