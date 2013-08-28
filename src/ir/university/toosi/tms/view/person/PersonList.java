package ir.university.toosi.tms.view.person;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.person.Person;
import ir.university.toosi.tms.model.entity.person.PersonSearchItems;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.user.UserForm;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.List;

public class PersonList extends JInternalFrame {

    public PersonList() {

        fillSearchCombo();
        jFileChooser1 = new JFileChooser();
        searchPanel = new JPanel();
        searchText = new JTextField();
        searchCombo = new JComboBox(searchItems);
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        by = new JLabel();
        filter = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public PersonList(UserForm userForm, User user, JDesktopPane jDesktopPane) {

        fillSearchCombo();
        jFileChooser1 = new JFileChooser();
        searchPanel = new JPanel();
        searchText = new JTextField();
        searchCombo = new JComboBox(searchItems);
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        by = new JLabel();
        filter = new JLabel();
        this.jDesktopPane = jDesktopPane;
        this.userForm = userForm;
        this.user = user;
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void fillSearchCombo() {
        searchItems = new String[PersonSearchItems.values().length];
        int i = 0;
        for (PersonSearchItems personSearchItem : PersonSearchItems.values()) {
            searchItems[i++] = personSearchItem.getDescription();
        }
    }

    private void initComponents() throws IOException {


        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setClosable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("PersonManagement");

        searchPanel.setBorder(BorderFactory.createTitledBorder("PERSONSEARCH"));

        searchText.setToolTipText("");
        searchText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
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

        mainPanel.setBorder(BorderFactory.createTitledBorder("PERSONLIST"));

        mainTable.setAutoCreateRowSorter(true);
        refresh();

        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        add.setText("ASSIGN");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignPersonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, tableScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(add)
                                                /*.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(delete)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(add)*/)
                                )
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(add))
                                .add(18, 18, 18)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, searchPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getAll() throws IOException {

        personService.setServiceName("/getAllPerson");
        personList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl(), personService.getServiceName()), new TypeReference<List<Person>>() {
        });
    }

    private void showData() {
        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, personList, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("NAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("LASTNAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personnelNo}"));
        columnBinding.setColumnName("PERSONNELNO");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nationalCode}"));
        columnBinding.setColumnName("NATIONALCODE");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pin}"));
        columnBinding.setColumnName("PIN");
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    public void refresh() throws IOException {

        getAll();
        showData();
    }

    private void search(DocumentEvent documentEvent) throws IOException {

        if (PersonSearchItems.values()[searchCombo.getSelectedIndex()].equals(PersonSearchItems.NAME)) {
            personService.setServiceName("/getPersonByName");
        } else if (PersonSearchItems.values()[searchCombo.getSelectedIndex()].equals(PersonSearchItems.LASTNAME)) {
            personService.setServiceName("/getPersonByLastName");
        } else if (PersonSearchItems.values()[searchCombo.getSelectedIndex()].equals(PersonSearchItems.NATIONALCODE)) {
            personService.setServiceName("/getPersonByNationalCode");
        } else if (PersonSearchItems.values()[searchCombo.getSelectedIndex()].equals(PersonSearchItems.PERSONNELNO)) {
            personService.setServiceName("/getPersonByPersonnelNo");
        }

        personList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(personService.getServerUrl(), personService.getServiceName(), searchText.getText()), new TypeReference<List<Person>>() {
        });
        showData();
    }

    private void assignPersonActionPerformed(java.awt.event.ActionEvent evt) {
        Person person = personList.get(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()));
        user.setPerson(person);
        personService.setServiceName("/editUser");
        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl(), personService.getServiceName(), new ObjectMapper().writeValueAsString(user)), Boolean.class);
            this.dispose();
            userForm.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }



    private JButton add;
    private JComboBox searchCombo;
    private JFileChooser jFileChooser1;
    private JPanel searchPanel;
    private JLabel by;
    private JLabel filter;
    private JPanel mainPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private JTextField searchText;
    private JDesktopPane jDesktopPane;

    private WebServiceInfo personService = new WebServiceInfo();
    private List<Person> personList;
    private String[] searchItems;
    private User user;
    private UserForm userForm;

    public JTable getMainTable() {
        return mainTable;
    }

}