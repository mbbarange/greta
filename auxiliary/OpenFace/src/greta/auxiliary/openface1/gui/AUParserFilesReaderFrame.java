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
package greta.auxiliary.openface1.gui;

import greta.core.util.log.Logs;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Philippe Gauthier <philippe.gauthier@sorbonne-universite.fr>
 * @author Brice Donval
 */
public class AUParserFilesReaderFrame extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(AUParserFilesReaderFrame.class.getName());

    /**
     * Creates new form AUParserFilesReaderFrame
     */
    public AUParserFilesReaderFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        mainPanel = new javax.swing.JPanel();
        northPanel = new javax.swing.JPanel();
        inputsPanel = new javax.swing.JPanel();
        directoryLabel = new javax.swing.JLabel();
        inputsPanelFiller = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        directoryTextField = new javax.swing.JTextField();
        northPanelFiller1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        openButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        northPanelFiller2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        centerPanel = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        outputsPanel = new javax.swing.JPanel();
        outputsScrollPane = new javax.swing.JScrollPane();
        outputsTable = new javax.swing.JTable();
        outputsButtonsPanel = new javax.swing.JPanel();
        setButton = new javax.swing.JButton();
        buttonsPanelFiller1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        selectAllButton = new javax.swing.JButton();
        selectNoneButton = new javax.swing.JButton();
        buttonsPanelFiller2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();

        fileChooser.setCurrentDirectory(new File("./"));
        sendButton = new greta.core.utilx.gui.ToolBox.LocalizedJButton("GUI.send");
        openButton = new greta.core.utilx.gui.ToolBox.LocalizedJButton("GUI.open");

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new java.awt.BorderLayout(0, 10));

        northPanel.setLayout(new javax.swing.BoxLayout(northPanel, javax.swing.BoxLayout.LINE_AXIS));

        inputsPanel.setLayout(new javax.swing.BoxLayout(inputsPanel, javax.swing.BoxLayout.LINE_AXIS));

        directoryLabel.setText("CSV directory:");
        directoryLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        inputsPanel.add(directoryLabel);
        inputsPanel.add(inputsPanelFiller);
        inputsPanel.add(directoryTextField);

        northPanel.add(inputsPanel);
        northPanel.add(northPanelFiller1);

        openButton.setName(""); // NOI18N
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        northPanel.add(openButton);

        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        northPanel.add(sendButton);
        northPanel.add(northPanelFiller2);

        mainPanel.add(northPanel, java.awt.BorderLayout.NORTH);

        centerPanel.setLayout(new java.awt.BorderLayout(0, 10));
        centerPanel.add(separator, java.awt.BorderLayout.NORTH);

        outputsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Available outputs:"));
        outputsPanel.setLayout(new java.awt.BorderLayout(10, 0));

        outputsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        outputsTable.setDragEnabled(true);
        outputsTable.setDropMode(javax.swing.DropMode.ON_OR_INSERT);
        outputsTable.setFillsViewportHeight(true);
        outputsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        outputsTable.getTableHeader().setReorderingAllowed(false);
        outputsScrollPane.setViewportView(outputsTable);

        outputsPanel.add(outputsScrollPane, java.awt.BorderLayout.CENTER);

        outputsButtonsPanel.setLayout(new javax.swing.BoxLayout(outputsButtonsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        setButton.setText("Set");
        setButton.setMaximumSize(new java.awt.Dimension(89, 23));
        setButton.setMinimumSize(new java.awt.Dimension(89, 23));
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });
        outputsButtonsPanel.add(setButton);
        outputsButtonsPanel.add(buttonsPanelFiller1);

        selectAllButton.setText("Select All");
        selectAllButton.setMaximumSize(new java.awt.Dimension(89, 23));
        selectAllButton.setMinimumSize(new java.awt.Dimension(89, 23));
        selectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllButtonActionPerformed(evt);
            }
        });
        outputsButtonsPanel.add(selectAllButton);

        selectNoneButton.setText("Select None");
        selectNoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNoneButtonActionPerformed(evt);
            }
        });
        outputsButtonsPanel.add(selectNoneButton);
        outputsButtonsPanel.add(buttonsPanelFiller2);

        upButton.setText("Up");
        upButton.setMaximumSize(new java.awt.Dimension(89, 23));
        upButton.setMinimumSize(new java.awt.Dimension(89, 23));
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        outputsButtonsPanel.add(upButton);

        downButton.setText("Down");
        downButton.setMaximumSize(new java.awt.Dimension(89, 23));
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        outputsButtonsPanel.add(downButton);

        outputsPanel.add(outputsButtonsPanel, java.awt.BorderLayout.EAST);

        centerPanel.add(outputsPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        // TODO add your handling code here:
        fileChooser.setLocale(Locale.getDefault());
        //For directoryOnly
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.updateUI();
        if (fileChooser.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            File dir = fileChooser.getSelectedFile();
            if (dir != null) {
                this.directoryTextField.setText(dir.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_openButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        send(directoryTextField.getText());
    }//GEN-LAST:event_sendButtonActionPerformed

    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        try {
            String[] selected = getSelected();
            setSelectedMethod.invoke(loader, new Object[]{selected});
        } catch (Exception ex) {
            Logs.error(ex.getLocalizedMessage());
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }
    }//GEN-LAST:event_setButtonActionPerformed

    private void selectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)outputsTable.getModel();
        for (int i = 0; i < model.getRowCount(); ++i) {
            model.setValueAt(true, i, 1);
        }
    }//GEN-LAST:event_selectAllButtonActionPerformed

    private void selectNoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectNoneButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)outputsTable.getModel();
        for (int i = 0; i < model.getRowCount(); ++i) {
            model.setValueAt(false, i, 1);
        }
    }//GEN-LAST:event_selectNoneButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int selectedIndex = outputsTable.getSelectedRow();
        if (selectedIndex > 0)
            moveSelected(selectedIndex, selectedIndex-1);
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int selectedIndex = outputsTable.getSelectedRow();
        if (selectedIndex > 0)
            moveSelected(selectedIndex, selectedIndex+1);
    }//GEN-LAST:event_downButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler buttonsPanelFiller1;
    private javax.swing.Box.Filler buttonsPanelFiller2;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel directoryLabel;
    private javax.swing.JTextField directoryTextField;
    private javax.swing.JButton downButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel inputsPanel;
    private javax.swing.Box.Filler inputsPanelFiller;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel northPanel;
    private javax.swing.Box.Filler northPanelFiller1;
    private javax.swing.Box.Filler northPanelFiller2;
    private javax.swing.JButton openButton;
    private javax.swing.JPanel outputsButtonsPanel;
    private javax.swing.JPanel outputsPanel;
    private javax.swing.JScrollPane outputsScrollPane;
    private javax.swing.JTable outputsTable;
    private javax.swing.JButton selectAllButton;
    private javax.swing.JButton selectNoneButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JSeparator separator;
    private javax.swing.JButton setButton;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables

    private void moveSelected(int old, int newIndex) {
        DefaultTableModel model = (DefaultTableModel)outputsTable.getModel();
        model.moveRow(old, old, newIndex);
        outputsTable.setRowSelectionInterval(old, newIndex);
    }

    private Method loadMethod;
    private Method listMethod;
    private Method setSelectedMethod;
    private Object loader;

    protected void send(String fileName) {
        if (fileName == null || fileName.isEmpty()) return;
        if (loadMethod != null) {
            try {
                loadMethod.invoke(loader, fileName);
                String[] strList = (String[])listMethod.invoke(loader);
                if (strList != null) {
                    updateHeaders(strList);
                }
            }
            catch (InvocationTargetException ex) {
                ex.getCause().printStackTrace();
            }
            catch (Exception ex) {
                System.err.println("Can not invoke method load(String) on " + loader.getClass().getCanonicalName());
            }
        }
        else {
            System.out.println("load is null");
        }
    }

    public String[] getSelected() {
        DefaultTableModel model = (DefaultTableModel)outputsTable.getModel();
        List<String> selected = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); ++i) {
            if ((Boolean)model.getValueAt(i, 1)) {
                selected.add((String)model.getValueAt(i, 0));
            }
        }
        return selected.toArray(new String[selected.size()]);
    }

    public void updateHeaders(String headers[]) {
        DefaultTableModel model = (DefaultTableModel)outputsTable.getModel();
        for (int i = 0; i < model.getRowCount(); ++i) {
            model.removeRow(0);
        }
        for (String h:headers) {
            model.addRow(new Object[]{h, false});
        }
    }

    public void setLoader(Object loader) {
        this.loader = loader;
        try {
            loadMethod = loader.getClass().getMethod("load", String.class);
            listMethod = loader.getClass().getMethod("list");
            setSelectedMethod = loader.getClass().getMethod("setSelected", String[].class);
        } catch (Exception ex) {
            System.err.println("Can not load methods by reflection: " + loader.getClass().getCanonicalName() + "\n" + ex.getLocalizedMessage());
        }
        try {
            Method getFileFilterMethod = loader.getClass().getMethod("getFileFilter");
            final java.io.FileFilter ff = (java.io.FileFilter) getFileFilterMethod.invoke(loader);
            fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || ff.accept(f);
                }

                @Override
                public String getDescription() {
                    return AUParserFilesReaderFrame.this.loader.getClass().getSimpleName() + " Files";
                }
            });

        } catch (Exception ex) {}
    }
}
