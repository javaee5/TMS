package ir.university.toosi.tms.view.basicinfo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicInfoManagement extends JInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public BasicInfoManagement() {
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();
        lookupPanel = new JPanel();
        codeField = new JTextField();
        nameField = new JTextField();
        descField = new JTextField();
        codeLabel = new JLabel();
        nameLabel = new JLabel();
        descLabel = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public BasicInfoManagement(JDesktopPane jDesktopPane, Lookup lookup) {
        jdpDesktop = jDesktopPane;
        this.lookup = lookup;
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();
        lookupPanel = new JPanel();
        codeField = new JTextField();
        nameField = new JTextField();
        descField = new JTextField();
        codeLabel = new JLabel();
        nameLabel = new JLabel();
        descLabel = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() throws IOException {


        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setClosable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("BASICINFOMANAGMENT");

        mainPanel.setBorder(BorderFactory.createTitledBorder("BASICINFOMANAGMENT"));

        mainTable.setAutoCreateRowSorter(true);
        refresh();


        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        add.setText("ADD");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    addActionPerformed(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int result = JOptionPane.showConfirmDialog(null, "DELETE_BLOOKUP", "DELETE", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    deleteActionPerformed(evt);
                }


            }
        });

        edit.setText("EDIT");
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    editActionPerformed(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(delete)
                                                .add(18, 18, 18)
                                                .add(edit))
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(add)
                                        .add(delete)
                                        .add(edit))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(133, 133, 133))
        );

        lookupPanel.setBorder(BorderFactory.createTitledBorder("LOOKUP"));

        codeField.setEditable(false);
        codeField.setText(lookup.getCode());
        nameField.setEditable(false);
        nameField.setText(lookup.getName());
        descField.setEditable(false);
        descField.setText(lookup.getDescription());


        codeLabel.setText("CODE");
        nameLabel.setText("NAME");
        descLabel.setText("DESCRIPTION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(lookupPanel);
        lookupPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(115, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(codeLabel)
                                                        .addComponent(nameLabel)
                                                        .addComponent(descLabel))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(descField)
                                                        .addComponent(nameField)
                                                        .addComponent(codeField, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(codeLabel)
                                        .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(descLabel)
                                        .addComponent(descField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(lookupPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(lookupPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("BasicInfoForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refresh() throws IOException {

        blookupService.setServiceName("/getByLookupId");
        bLookups = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(blookupService.getServerUrl(), blookupService.getServiceName(), new ObjectMapper().writeValueAsString(lookup.getId())),  new TypeReference<List<BLookup>>() {
        });

        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bLookups, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${code}"));
        columnBinding.setColumnName("CODE");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("NAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${persianName}"));
        columnBinding.setColumnName("PERSIANNAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("DESC");
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    private void deleteActionPerformed(ActionEvent evt) {

        int[] indexes = new int[mainTable.getSelectedRows().length];
        int j = 0;
        for (int i : mainTable.getSelectedRows()) {
            indexes[j++] = mainTable.convertRowIndexToModel(i);
        }

        List<BLookup> deletedBLookups = new ArrayList<>();
        for (int index : indexes) {
            deletedBLookups.add(bLookups.get(index));
        }

        blookupService.setServiceName("/deleteBLookups");
        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(blookupService.getServerUrl(), blookupService.getServiceName(), new ObjectMapper().writeValueAsString(deletedBLookups)), Boolean.class);
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void addActionPerformed(ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        BLookupForm bLookupForm = new BLookupForm(false, null, lookup, this);
        bLookupForm.setVisible(true);
        jdpDesktop.add(bLookupForm);
        bLookupForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void editActionPerformed(ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        BLookup bLookup = bLookups.get(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()));
        BLookupForm bLookupForm = new BLookupForm(true, bLookup, lookup, this);
        bLookupForm.setVisible(true);
        jdpDesktop.add(bLookupForm);
        bLookupForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton add;
    private JButton delete;
    private JButton edit;
    private JPanel mainPanel;
    private JPanel lookupPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private JDesktopPane jdpDesktop;
    private JLabel codeLabel;
    private JLabel nameLabel;
    private JLabel descLabel;
    private JTextField codeField;
    private JTextField nameField;
    private JTextField descField;
    private WebServiceInfo blookupService = new WebServiceInfo();
    private List<BLookup> bLookups = new ArrayList<>();
    private Lookup lookup;

    public JTable getMainTable() {
        return mainTable;
    }
    // End of variables declaration//GEN-END:variables
}