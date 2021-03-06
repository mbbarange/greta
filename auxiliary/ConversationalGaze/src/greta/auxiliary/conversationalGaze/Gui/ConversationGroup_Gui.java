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
package greta.auxiliary.conversationalGaze.Gui;

import greta.auxiliary.conversationalGaze.ConversationParticipant;
import greta.auxiliary.conversationalGaze.ConversationalGroup;

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

        check_user.setText("Remove the User from participant list");
        check_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(check_user)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
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

    public void setGui (ConversationalGroup gr){
        this.group = gr;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check_user;
    // End of variables declaration//GEN-END:variables
}
