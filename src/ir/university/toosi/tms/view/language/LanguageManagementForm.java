package ir.university.toosi.tms.view.language;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.LanguageKeySearchItems;
import ir.university.toosi.tms.model.entity.LanguageKeyValue;
import ir.university.toosi.tms.model.entity.LanguageManagement;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

public class LanguageManagementForm extends TMSInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public LanguageManagementForm() {
        fillSearchCombo();
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        save = new JButton();
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

    public LanguageManagementForm(JDesktopPane jDesktopPane) {
        fillSearchCombo();
        jdpDesktop = jDesktopPane;
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        save = new JButton();
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
        searchItems = new String[LanguageKeySearchItems.values().length];
        int i = 0;
        for (LanguageKeySearchItems languageKeySearchItems : LanguageKeySearchItems.values()) {
            searchItems[i++] = languageKeySearchItems.getDescription();
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
        setTitle(ThreadPoolManager.getLangValue("TMS_LANGMANAGEMENT"));

        mainPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_LANGMANAGEMENT")));

        mainTable.setAutoCreateRowSorter(true);
        refresh();


        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        mainTable.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                int index = mainTable.convertRowIndexToModel(mainTable.getSelectedRow());
                langList.get(index).setEdited(true);
            }

            @Override
            public void editingCanceled(ChangeEvent e) {

            }
        });


        save.setText(ThreadPoolManager.getLangValue("TMS_SAVE"));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
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
                                                .add(save))
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(save))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(133, 133, 133))
        );

        searchPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_SEARCHBY")));
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

//        filter.setText("FILTER");
//
//        by.setText("BY");

       /* org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(searchPanel);
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
        );*/

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        /*.add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))*/
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                               /* .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)*/
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("OperationForm");

        if (ThreadPoolManager.currentLanguage.isRtl())
            getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        else
            getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void refresh() throws IOException {
        langList = ThreadPoolManager.getLangList();
        showData();
    }

    private void showData() {
        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, langList, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${key}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_KEY"));
        columnBinding.setEditable(false);
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${value}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_VALUE"));
        columnBinding.setEditable(true);
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    private void search(DocumentEvent documentEvent) throws IOException {

      /*  if (!ThreadPoolManager.langHash.containsKey(searchText.getText())) {
            langList = ThreadPoolManager.getLangList();
            showData();
            return;
        }

        langList = new ArrayList<>();
        String value = ThreadPoolManager.langHash.get(searchText.getText());
        LanguageKeyValue languageKeyValue = new LanguageKeyValue();
        languageKeyValue.setKey(searchText.getText());
        languageKeyValue.setValue(value);
        langList.add(languageKeyValue);

        showData();*/
    }

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {

        List<LanguageManagement> languageManagements = new ArrayList<>();
        for (LanguageKeyValue languageKeyValue : langList) {
            if (!languageKeyValue.isEdited())
                continue;

            LanguageManagement changedLanguageManagement = ThreadPoolManager.langHash.get(languageKeyValue.getKey());
            changedLanguageManagement.setTitle(languageKeyValue.getValue());
            languageManagements.add(changedLanguageManagement);
        }

        langService.setServiceName("/editLanguageManagementList");
        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(langService.getServerUrl(), langService.getServiceName(), new ObjectMapper().writeValueAsString(languageManagements)), Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        langService.setServiceName("/loadLanguage");
        try {
            ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(langService.getServerUrl(), langService.getServiceName(), ThreadPoolManager.currentLanguage.getName()), new TypeReference<Hashtable<String, LanguageManagement>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton save;
    private JComboBox searchCombo;
    private JLabel by;
    private JLabel filter;
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private JDesktopPane jdpDesktop;
    private JTextField searchText;
    private List<LanguageKeyValue> langList = new ArrayList<>();
    private String[] searchItems;
    private WebServiceInfo langService = new WebServiceInfo();

    public JTable getMainTable() {
        return mainTable;
    }
    // End of variables declaration//GEN-END:variables
}
