/*
 * This file is part of Greta.
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
package greta.core.utilx.gui;

import greta.core.util.log.Logs;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Philippe Gauthier
 */
public class AUParserFileReaderController extends javax.swing.JFrame {
    private static final Logger LOGGER = Logger.getLogger(AUParserFileReaderController.class.getName() );


    /** Creates new form TreeNodeController */
    public AUParserFileReaderController() {
        initComponents();
        //jTable1.setDragEnabled(true);
        //jTable1.setDropMode(DropMode.INSERT_ROWS);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        directoryTextField = new javax.swing.JTextField();
        openButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButtonSetSelected = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonSelectAll = new javax.swing.JButton();
        jButtonSelectAll1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonUp = new javax.swing.JButton();
        jButtonDown = new javax.swing.JButton();

        jFileChooser1.setCurrentDirectory(new File("./"));
        sendButton = new greta.core.utilx.gui.ToolBox.LocalizedJButton("GUI.send");
        openButton = new greta.core.utilx.gui.ToolBox.LocalizedJButton("GUI.open");

        jPanel1.setLayout(new java.awt.BorderLayout(10, 10));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Choose csv directory :");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel1);

        directoryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directoryTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(directoryTextField);

        openButton.setName(""); // NOI18N
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        jPanel3.add(openButton);

        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        jPanel3.add(sendButton);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout(10, 10));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Selected"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.setDropMode(javax.swing.DropMode.ON_OR_INSERT);
        jTable1.setFillsViewportHeight(true);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jButtonSetSelected.setText("Set");
        jButtonSetSelected.setMaximumSize(new java.awt.Dimension(89, 23));
        jButtonSetSelected.setMinimumSize(new java.awt.Dimension(89, 23));
        jButtonSetSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetSelectedActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonSetSelected);
        jPanel4.add(jSeparator2);

        jButtonSelectAll.setText("Select All");
        jButtonSelectAll.setMaximumSize(new java.awt.Dimension(89, 23));
        jButtonSelectAll.setMinimumSize(new java.awt.Dimension(89, 23));
        jButtonSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectAllActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonSelectAll);

        jButtonSelectAll1.setText("Select none");
        jButtonSelectAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectAll1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonSelectAll1);
        jPanel4.add(jSeparator1);

        jButtonUp.setText("Up");
        jButtonUp.setMaximumSize(new java.awt.Dimension(89, 23));
        jButtonUp.setMinimumSize(new java.awt.Dimension(89, 23));
        jButtonUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonUp);

        jButtonDown.setText("Down");
        jButtonDown.setMaximumSize(new java.awt.Dimension(89, 23));
        jButtonDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDownActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonDown);

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);
        jPanel2.setBorder(BorderFactory.createTitledBorder("Headers"));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void directoryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directoryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_directoryTextFieldActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        // TODO add your handling code here:
        jFileChooser1.setLocale(Locale.getDefault());
        //For directoryOnly
        jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser1.updateUI();
        if(jFileChooser1.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION){
            File dir = jFileChooser1.getSelectedFile();
            if(dir!=null){
                this.directoryTextField.setText(dir.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_openButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        send(directoryTextField.getText());
    }//GEN-LAST:event_sendButtonActionPerformed

    private void jButtonUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpActionPerformed
        int selectedIndex = jTable1.getSelectedRow();
        if(selectedIndex>0)
            moveSelected(selectedIndex, selectedIndex-1);
    }//GEN-LAST:event_jButtonUpActionPerformed

    private void jButtonDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDownActionPerformed
        int selectedIndex = jTable1.getSelectedRow();
        if(selectedIndex>0)
            moveSelected(selectedIndex, selectedIndex+1);
    }//GEN-LAST:event_jButtonDownActionPerformed

    private void jButtonSetSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetSelectedActionPerformed
        try {
            String[] selected = getSelected();
            setSelectedMethod.invoke(loader, new Object[]{selected});
        } catch (Exception ex) {
            Logs.error(ex.getLocalizedMessage());
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }
    }//GEN-LAST:event_jButtonSetSelectedActionPerformed

    private void jButtonSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectAllActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(true, i, 1);
        }
    }//GEN-LAST:event_jButtonSelectAllActionPerformed

    private void jButtonSelectAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectAll1ActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(false, i, 1);
        }
    }//GEN-LAST:event_jButtonSelectAll1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField directoryTextField;
    private javax.swing.JButton jButtonDown;
    private javax.swing.JButton jButtonSelectAll;
    private javax.swing.JButton jButtonSelectAll1;
    private javax.swing.JButton jButtonSetSelected;
    private javax.swing.JButton jButtonUp;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton openButton;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables


    private void moveSelected(int old, int newIndex){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.moveRow(old, old, newIndex);
        jTable1.setRowSelectionInterval(old,newIndex);
    }

    private Method loadMethod;
    private Method listMethod;
    private Method setSelectedMethod;
    private Object loader;

    protected void send(String fileName) {
        if(fileName==null || fileName.isEmpty()) return ;
        if(loadMethod!=null){
            try {
                loadMethod.invoke(loader, fileName);
                String[] strList = (String[])listMethod.invoke(loader);
                if(strList!=null)
                    updateHeaders(strList);
            }
            catch (InvocationTargetException ex) {
                ex.getCause().printStackTrace();
            }
            catch (Exception ex) {
                System.err.println("Can not invoke method load(String) on "+loader.getClass().getCanonicalName());
            }
        }
        else{
            System.out.println("load is null");
        }
    }

    public String[] getSelected(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        List<String> selected = new ArrayList<>();
        for(int i=0;i<model.getRowCount();i++){
            if((Boolean)model.getValueAt(i, 1))
                selected.add((String)model.getValueAt(i, 0));
        }
        return selected.toArray(new String[selected.size()]);
    }

    public void updateHeaders(String headers[]){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(int i=0;i<model.getRowCount();i++)
            model.removeRow(0);

        for(String h:headers){
            model.addRow(new Object[]{h,false});
        }
    }

    public void setLoader(Object loader){
        this.loader = loader;
        try {
            loadMethod = loader.getClass().getMethod("load", String.class);
            listMethod = loader.getClass().getMethod("list");
            setSelectedMethod = loader.getClass().getMethod("setSelected",String[].class);
        } catch (Exception ex) {
            System.err.println("Can not load methods by reflection: "+loader.getClass().getCanonicalName()+"\n"+ex.getLocalizedMessage());
        }
        try {
            Method getFileFilterMethod = loader.getClass().getMethod("getFileFilter");
            final java.io.FileFilter ff = (java.io.FileFilter) getFileFilterMethod.invoke(loader);
            jFileChooser1.removeChoosableFileFilter(jFileChooser1.getAcceptAllFileFilter());
            jFileChooser1.setAcceptAllFileFilterUsed(false);
            jFileChooser1.addChoosableFileFilter(new javax.swing.filechooser.FileFilter(){

                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || ff.accept(f);
                }

                @Override
                public String getDescription() {
                    return AUParserFileReaderController.this.loader.getClass().getSimpleName()+" Files";
                }
            });

        } catch (Exception ex) {}
    }
}
