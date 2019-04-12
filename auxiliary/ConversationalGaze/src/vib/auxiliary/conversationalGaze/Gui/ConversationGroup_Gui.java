/*
 *  This file is part of the auxiliaries of VIB (Virtual Interactive Behaviour).
 */
package vib.auxiliary.conversationalGaze.Gui;

import vib.auxiliary.conversationalGaze.AgentGazeUser;
import vib.auxiliary.conversationalGaze.ConversationParticipant;
import vib.auxiliary.conversationalGaze.ConversationalGroup;

/**
 *
 * @author donat
 */
public class ConversationGroup_Gui extends javax.swing.JFrame {

    private ConversationalGroup group;
    private boolean start = false;
    /**
     * Creates new form ConversationGroup_Gui
     */
    public ConversationGroup_Gui() {
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

        check_user = new javax.swing.JCheckBox();
        start_thread = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        check_user.setText("Remove the User from participant list");
        check_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_userActionPerformed(evt);
            }
        });

        start_thread.setText("Start multi-part gaze");
        start_thread.setToolTipText("");
        start_thread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_threadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start_thread)
                    .addComponent(check_user))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(start_thread)
                .addGap(18, 18, 18)
                .addComponent(check_user)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_userActionPerformed
        if (check_user.isEnabled()){
            boolean found = false;
            for(ConversationParticipant c : group.listParticipants){
                if(c.getName().equals("user"))
                    found = true;   
            }
            if (found)
                group.groupActive = false;
                group.listParticipants.remove("user");     
                group.groupActive = true;
                group.start();
        }else {
            group.groupActive = false;
            group.listParticipants.add(new ConversationParticipant("user"));   
            group.groupActive = true;
            group.start();
        }
    }//GEN-LAST:event_check_userActionPerformed

    private void start_threadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_threadActionPerformed
        
        if(!start && !start_thread.getText().equals("Stop")){
            start = true;
            group.groupActive = true;
            start_thread.setText("Stop");
            group.run();
        }else{
            start = false;
            group.groupActive = false;
            start_thread.setText("Start multi-part gaze");
        }
    }//GEN-LAST:event_start_threadActionPerformed

    public void setGui (ConversationalGroup gr){
        this.group = gr;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check_user;
    private javax.swing.JButton start_thread;
    // End of variables declaration//GEN-END:variables
}
