package ir.university.toosi.tms.view.eventlog;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.EventLog;
import ir.university.toosi.tms.model.entity.EventLogSearchItems;
import ir.university.toosi.tms.model.entity.EventLogType;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventLogList extends JInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public EventLogList() {
        fillSearchCombo();
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
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

    public EventLogList(JDesktopPane jDesktopPane) {
        fillSearchCombo();
        jdpDesktop = jDesktopPane;
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
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
        searchItems = new String[EventLogSearchItems.values().length];
        int i = 0;
        for (EventLogSearchItems logSearchItems : EventLogSearchItems.values()) {
            searchItems[i++] = logSearchItems.getDescription();
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
        setTitle("EVENTLOGLIST");

        mainPanel.setBorder(BorderFactory.createTitledBorder("EVENTLOGLIST"));

        mainTable.setAutoCreateRowSorter(true);
        refresh();


        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1Layout.createSequentialGroup()
//                                                .add(add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
//                                                .add(delete)
                                                .add(18, 18, 18)
//                                                .add(edit)
                                        )
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
//                                        .add(add)
//                                        .add(delete)
//                                        .add(edit)
                                )
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(133, 133, 133))
        );

        searchPanel.setBorder(BorderFactory.createTitledBorder("SEARCHEVENTLOG"));

        searchText.setToolTipText("");
        searchText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
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

        mainPanel.getAccessibleContext().setAccessibleName("ADDUser");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refresh() throws IOException {
        eventLogService.setServiceName("/getAllEventLog");
        logs = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(eventLogService.getServerUrl(), eventLogService.getServiceName()), new TypeReference<List<EventLog>>() {
        });

        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, logs, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${operation.name}"));
        columnBinding.setColumnName("OPERATION");
        columnBinding.setColumnClass(EventLogType.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${objectId}"));
        columnBinding.setColumnName("OBJECT_ID");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tableName}"));
        columnBinding.setColumnName("TABLE_NAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName("USER_NAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("DATE");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${time}"));
        columnBinding.setColumnName("TIME");
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox searchCombo;
    private JLabel by;
    private JLabel filter;
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private JDesktopPane jdpDesktop;
    private JTextField searchText;
    private WebServiceInfo eventLogService = new WebServiceInfo();
    private List<EventLog> logs = new ArrayList<>();
    private String[] searchItems;

    public JTable getMainTable() {
        return mainTable;
    }
    // End of variables declaration//GEN-END:variables
}
