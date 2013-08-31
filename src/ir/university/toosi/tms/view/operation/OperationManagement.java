package ir.university.toosi.tms.view.operation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Operation;
import ir.university.toosi.tms.model.entity.OperationSearchItems;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OperationManagement extends TMSInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public OperationManagement() {
        fillSearchCombo();
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();
        searchPanel = new JPanel();
        searchCombo = new JComboBox(searchItems);
        searchText = new JTextField();
        filter = new JLabel();
        by = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public OperationManagement(JDesktopPane jDesktopPane) {
        fillSearchCombo();
        jdpDesktop = jDesktopPane;
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();
        searchPanel = new JPanel();
        searchCombo = new JComboBox(searchItems);
        searchText = new JTextField();
        filter = new JLabel();
        by = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void fillSearchCombo() {
        searchItems = new String[OperationSearchItems.values().length];
        int i = 0;
        for (OperationSearchItems operationSearchItem : OperationSearchItems.values()) {
            searchItems[i++] = operationSearchItem.getDescription();
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
        setTitle("ROLEMANAGEMENT");

        mainPanel.setBorder(BorderFactory.createTitledBorder("ROLEMANAGEMENT"));

        mainTable.setAutoCreateRowSorter(true);
        refresh();


        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addActionPerformed(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int result = JOptionPane.showConfirmDialog(null, "DELETE_USER", "DELETE", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    deleteActionPerformed(evt);
                }


            }
        });

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        searchPanel.setBorder(BorderFactory.createTitledBorder("SEARCHROLE"));
//        searchCombo.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        searchText.setToolTipText("");
        searchText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        filter.setText("FILTER");

        by.setText("BY");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(searchPanel);
        searchPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(filter)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(by)
                                .add(18, 18, 18)
                                .add(searchCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(filter)
                                        .add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(searchCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(by))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("OperationForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getAll() throws IOException {
        operationService.setServiceName("/getAllOperation");
        operationList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(operationService.getServerUrl(), operationService.getServiceName()), new TypeReference<List<Operation>>() {
        });
    }

    public void refresh() throws IOException {
        getAll();
        showData();
    }

    private void showData() {
        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, operationList, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("NAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("DESCRIPTION");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${enabled}"));
        columnBinding.setColumnName("ENABLED");
        columnBinding.setColumnClass(Boolean.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    private void search(DocumentEvent documentEvent) throws IOException {

        if (OperationSearchItems.values()[searchCombo.getSelectedIndex()].equals(OperationSearchItems.NAME)) {
            operationService.setServiceName("/getOperationByName");
            Operation searchOperation = new Operation();
            searchOperation.setName(searchText.getText());
            searchOperation.setEffectorUser(ThreadPoolManager.me.getUsername());
            operationList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(operationService.getServerUrl(), operationService.getServiceName(), new ObjectMapper().writeValueAsString(searchOperation)), new TypeReference<List<Operation>>() {
            });

            showData();
        }
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        int[] indexes = new int[mainTable.getSelectedRows().length];
        int j = 0;
        for (int i : mainTable.getSelectedRows()) {
            indexes[j++] = mainTable.convertRowIndexToModel(i);
        }

        List<Operation> deletedOperations = new ArrayList<>();
        for (int index : indexes) {
            Operation operation = operationList.get(index);
            operation.setEffectorUser(ThreadPoolManager.me.getUsername());
            deletedOperations.add(operation);
        }

        operationService.setServiceName("/deleteOperationList");
        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(operationService.getServerUrl(), operationService.getServiceName(), new ObjectMapper().writeValueAsString(deletedOperations)), Boolean.class);
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        OperationForm operationForm = new OperationForm(false, null, this);
        operationForm.setVisible(true);
        jdpDesktop.add(operationForm);
        operationForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void editActionPerformed(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        Operation operation = operationList.get(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()));
        OperationForm operationForm = new OperationForm(true, operation, this);
        operationForm.setVisible(true);
        jdpDesktop.add(operationForm);
        operationForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton add;
    private JButton delete;
    private JButton edit;
    private JComboBox searchCombo;
    private JLabel by;
    private JLabel filter;
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private JDesktopPane jdpDesktop;
    private JTextField searchText;
    private WebServiceInfo operationService = new WebServiceInfo();
    private List<Operation> operationList = new ArrayList<>();
    private String[] searchItems;

    public JTable getMainTable() {
        return mainTable;
    }
    // End of variables declaration//GEN-END:variables
}
