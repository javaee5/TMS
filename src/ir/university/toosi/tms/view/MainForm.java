package ir.university.toosi.tms.view;


import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.calendar.CalendarManagement;
import ir.university.toosi.tms.view.eventlog.EventLogList;
import ir.university.toosi.tms.view.language.LanguageAddForm;
import ir.university.toosi.tms.view.language.LanguageManagementCode;
import ir.university.toosi.tms.view.login.LoginForm;
import ir.university.toosi.tms.view.newMenu.MenuPanel;
import ir.university.toosi.tms.view.organ.OrganManagementCode;
import ir.university.toosi.tms.view.pc.PCManagementCode;
import ir.university.toosi.tms.view.person.PersonManagementCode;
import ir.university.toosi.tms.view.role.RoleManagementCode;
import ir.university.toosi.tms.view.user.UserManagementCode;
import ir.university.toosi.tms.view.workgroup.WorkGroupManagementCode;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author a_hadadi
 */
public class MainForm extends JFrame implements WindowListener {

    private TMSDesktop desktopPane;
    private WebServiceInfo webServiceInfo = new WebServiceInfo();
    private ComponentOrientation direction;
    private String lookAndFeelUser;

    public MainForm() {
        super("سامانه مدیریت تردد");//todo load from bundle
        addWindowListener(this);
        setSize();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        try {
            setDefaultLookAndFeelDecorated(true);
            if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } else {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ThreadPoolManager.mainForm = this;
    }

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.createAndShowGUI();
    }

    public void setSize() {
        setMinimumSize(new Dimension(600, 400));
        setPreferredSize(new Dimension(600, 400));
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(20, 20);
        screenSize.setSize(screenSize.getWidth() - 40, screenSize.getHeight() - 80);
        setSize(screenSize);
        setMaximumSize(screenSize);

    }

    private void createAndShowGUI() {

        LoginForm loginFormDialog = new LoginForm();
        loginFormDialog.setModal(true);
        loginFormDialog.setVisible(true);

        if (!loginFormDialog.isLogin()) {
            System.exit(1);
        }
        direction = loginFormDialog.direction;
        lookAndFeelUser = loginFormDialog.lookAndFeel;
        try {
            setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(lookAndFeelUser);
            UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Tahoma", Font.PLAIN, 11));
            Font tahoma10Font = new Font("Tahoma", Font.PLAIN, 10);
            Font tahoma11Font = new Font("Tahoma", Font.PLAIN, 11);
            Font tahoma12Font = new Font("Tahoma", Font.PLAIN, 12);
            UIManager.put("OptionPane.buttonFont", tahoma11Font);
            FontUIResource ax = new FontUIResource(tahoma12Font);
            UIManager.put("OptionPane.messageFont", ax);
            UIManager.put("OptionPane.font", tahoma11Font);
            UIManager.put("Panel.font", tahoma11Font);
            UIManager.put("TableHeader.font", tahoma10Font);
            UIManager.put("TitledBorder.font", tahoma10Font);
        } catch (Exception e) {
            System.out.println("error setting LAF and default font");
            e.printStackTrace();
        }


        // setMaximumSize(new Dimension(1024, 800));
        setBackground(new Color(234, 234, 255));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        //add graphical menu panel
        MenuPaneActionAvailable menuPaneActionAvailable = new MenuPaneActionAvailable();
        menuPaneActionAvailable.setMinimumSize(new Dimension((int) menuPaneActionAvailable.getPreferredSize().getWidth(), 100));
        menuPaneActionAvailable.setPreferredSize(new Dimension((int) menuPaneActionAvailable.getPreferredSize().getWidth(), 100));
        contentPane.add(menuPaneActionAvailable);

        //add divider
        JPanel dividerPanel = new JPanel();
        dividerPanel.setBackground(new Color(240, 240, 240));
        dividerPanel.setPreferredSize(new Dimension((int) dividerPanel.getPreferredSize().getWidth(), 2));
        contentPane.add(dividerPanel);


        //add desktopPane for handling JInternalFrames
        //desktopPane = new JDesktopPane();
        desktopPane = new TMSDesktop();
        desktopPane.setBackground(new Color(238, 238, 238));
        contentPane.add(desktopPane);

        ComponentUtil.changeComonentOrientation(this.getComponents(), direction);

        //set Main window Properties
        setVisible(true);
       /* repaint();
        revalidate();*/

    }

    public TMSDesktop getDesktopPane() {
        return desktopPane;
    }

    private void exitOP() {

        if (DialogUtil.showExitQuestionDialog(this)) {
            // saveSettings(); //save prop
            System.exit(1);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        exitOP();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    class MenuPaneActionAvailable extends MenuPanel {
        MenuPaneActionAvailable() {
            super();

            //todo change icons
            languageDefItem.setIcon(ComponentUtil.getImageIcon("lang.png"));
            importLanguage.setIcon(ComponentUtil.getImageIcon("lang.png"));
            workGroupManagementItem.setIcon(ComponentUtil.getImageIcon("workgroup-menu.png"));
            roleManagementItem.setIcon(ComponentUtil.getImageIcon("role-menu.png"));
            userManagementItem.setIcon(ComponentUtil.getImageIcon("users-menu.png"));
            eventLogListItem.setIcon(ComponentUtil.getImageIcon("event.png"));
            personManagementItem.setIcon(ComponentUtil.getImageIcon("account-menu.png"));
            pcManagementItem.setIcon(ComponentUtil.getImageIcon("pc-menu.png"));
            organManagementItem.setIcon(ComponentUtil.getImageIcon("organ.png"));
            exit.setIcon(ComponentUtil.getImageIcon("exit.png"));

            cameraItem.setIcon(ComponentUtil.getImageIcon("camera_add.png"));
            cardItem.setIcon(ComponentUtil.getImageIcon("Payment-Methods-Card-inserting-icon.png"));
            gatewayItem.setIcon(ComponentUtil.getImageIcon("gate.png"));
            zoneItem.setIcon(ComponentUtil.getImageIcon("zone.png"));
            pdpItem.setIcon(ComponentUtil.getImageIcon("pdp.png"));
            dayItem.setIcon(ComponentUtil.getImageIcon("day-icon.png"));
            calendarItem.setIcon(ComponentUtil.getImageIcon("calendar.png"));
            ruleItem.setIcon(ComponentUtil.getImageIcon("rule.png"));
            exceptionRuleItem.setIcon(ComponentUtil.getImageIcon("exception.png"));



            /*
            todo bundle
            languageDefItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            importLanguage.setText(ThreadPoolManager.getLangValue("TMS_"));
            workGroupManagementItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            roleManagementItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            userManagementItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            eventLogListItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            personManagementItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            pcManagementItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            organManagementItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            exit.setText(ThreadPoolManager.getLangValue("TMS_"));


            cameraItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            cardItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            gatewayItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            zoneItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            pdpItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            dayItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            calendarItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            ruleItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            exceptionRuleItem.setText(ThreadPoolManager.getLangValue("TMS_"));
            */
        }

        @Override
        protected void showUserManagement() {
            UserManagementCode userManagement = new UserManagementCode();
            userManagement.setVisible(true);
            desktopPane.add(userManagement);
            try {
                userManagement.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showRoleManagement() {
            RoleManagementCode roleManagementCode = new RoleManagementCode();
            roleManagementCode.setVisible(true);
            desktopPane.add(roleManagementCode);
            try {
                roleManagementCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showWorkGroupManagement() {
            WorkGroupManagementCode workGroupManagement = new WorkGroupManagementCode();
            workGroupManagement.setVisible(true);
            desktopPane.add(workGroupManagement);
            try {
                workGroupManagement.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showEventLogList() {
            EventLogList eventLogList = new EventLogList();
            eventLogList.setVisible(true);
            desktopPane.add(eventLogList);
            try {
                eventLogList.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showCalendarManagment() {
            CalendarManagement calendarManagement = new CalendarManagement(desktopPane);
            calendarManagement.setVisible(true);
            desktopPane.add(calendarManagement);
            try {
                calendarManagement.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showPersonManagment() {
            PersonManagementCode personManagementCode = new PersonManagementCode();
            personManagementCode.setVisible(true);
            desktopPane.add(personManagementCode);
            try {
                personManagementCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        @Override
        protected void showLanguageDef() {
            LanguageAddForm languageAddForm = new LanguageAddForm();
            languageAddForm.setVisible(true);
            desktopPane.add(languageAddForm);
            try {
                languageAddForm.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showLanguageForm() {
            LanguageManagementCode languageManagementCode = new LanguageManagementCode();
            languageManagementCode.setVisible(true);
            desktopPane.add(languageManagementCode);
            try {
                languageManagementCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void exit() {
            exitOP();
        }

        @Override
        protected void showPCManagment() {

            PCManagementCode pcManagement = new PCManagementCode();
            pcManagement.setVisible(true);
            desktopPane.add(pcManagement);
            try {
                pcManagement.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showOrganManagment() {
            OrganManagementCode organManagementCode = new OrganManagementCode(null);
            organManagementCode.setVisible(true);
            desktopPane.add(organManagementCode);
            try {
                organManagementCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showDayManagment() {
            //todo
        }

        @Override
        protected void showRuleManagment() {

            //todo
        }

        @Override
        protected void showExceptionRuleManagment() {
            //todo
        }

        @Override
        protected void showCameraManagment() {
            //todo
        }

        @Override
        protected void showCardManagment() {
            //todo
        }

        @Override
        protected void showGatewayManagment() {
            //todo
        }

        @Override
        protected void showZoneManagment() {
            //todo
        }

        @Override
        protected void showPDPManagment() {
            //todo
        }

    }

}
