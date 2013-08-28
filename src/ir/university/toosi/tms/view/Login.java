package ir.university.toosi.tms.view;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Hashtable;
import java.util.List;

/**
 * @author a_ahmady
 */
public class Login extends javax.swing.JInternalFrame {

    /**
     * Creates new form Login
     */
    private MainForm mainForm;

    public Login(MainForm mainForm) {

        fillSearchCombo();
        this.mainForm = mainForm;
        jPanel1 = new JPanel();
        login = new JButton();
        cancel = new JButton();
        userName = new JTextField();
        password = new JTextField();
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        langLabel = new JLabel();
        language = new JComboBox(langItems);
        language.setSelectedItem(defaultedLang);
        initComponents();
    }

    private void fillSearchCombo() {

        loginService.setServiceName("/getAllLanguage");
        try {
            languagesList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName()), new TypeReference<List<Languages>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        langItems = new String[languagesList.size()];
        int i = 0;
        for (Languages languages : languagesList) {
            if(languages.isDefaulted())
                defaultedLang = languages.getName();
            langItems[i++] = languages.getName();
        }
    }


    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginService.setServiceName("/loadLanguage");
        try {
            ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(loginService.getServerUrl(), loginService.getServiceName(), defaultedLang), new TypeReference<Hashtable<String, LanguageManagement>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        login.setText(ThreadPoolManager.getLangValue("TMS_LOGIN"));

        cancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        login.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

               loginService.setServiceName("/authenticate");

                user = new User();
                user.setUsername(userName.getText());
                user.setPassword(password.getText());


                AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        try {
                            result = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName(), new ObjectMapper().writeValueAsString(user)), User.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }
                });

                if (result == null)
                    JOptionPane.showMessageDialog(new JFrame(), "user not found");
                else if (result.getUsername().equalsIgnoreCase("null")) {
                    JOptionPane.showMessageDialog(new JFrame(), "user not found");
                } else {
                    try {
                        String ipAddress = InetAddress.getLocalHost().getHostAddress();
                        boolean allowed = false;
                        for (PC pc : result.getPcs()) {
                            if (pc.getIp().equals(ipAddress)) {
                                allowed = true;
                                break;
                            }
                        }

                        if (!allowed) {
                            JOptionPane.showMessageDialog(new JFrame(), "you can not login on this pc");
                            return;
                        }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    ThreadPoolManager.me = result;
                    ThreadPoolManager.currentLanguage = languagesList.get(language.getSelectedIndex());
                    loginService.setServiceName("/loadLanguage");
                    try {
                        ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(loginService.getServerUrl(), loginService.getServiceName(), ThreadPoolManager.currentLanguage.getName()), new TypeReference<Hashtable<String, LanguageManagement>>() {
                         });

                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    JOptionPane.showMessageDialog(new JFrame(), "Welcome " + result.getUsername());
                    mainForm.getMainMenuBar().setVisible(true);
                    mainForm.getLoginForm().dispose();
                }
            }
        });


        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        userNameLabel.setText(ThreadPoolManager.getLangValue("TMS_USERNAME"));

        passwordLabel.setText(ThreadPoolManager.getLangValue("TMS_PASSWORD"));

        langLabel.setText(ThreadPoolManager.getLangValue("TMS_LANGUAGE"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(login)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cancel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(109, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(userNameLabel)
                                                        .addComponent(langLabel)
                                                        .addComponent(passwordLabel))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(password)
                                                        .addComponent(language)
                                                        .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userNameLabel)
                                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(langLabel)
                                        .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(login)
                                        .addComponent(cancel))
                                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton login;
    private JButton cancel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel langLabel;
    private JPanel jPanel1;
    private JTextField userName;
    private JTextField password;
    private JComboBox language;
    private WebServiceInfo loginService = new WebServiceInfo();;
    private User user, result;
    private String[] langItems;
    private String defaultedLang;
    private List<Languages> languagesList;

    // End of variables declaration//GEN-END:variables
}
