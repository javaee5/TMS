/*
 * Copyright (c) 2010, Oracle. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of Oracle nor the names of its contributors
 *   may be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package ir.university.toosi.tms.view.operation;


import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Operation;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;

import javax.swing.*;
import java.io.IOException;

public class OperationForm extends TMSInternalFrame {

    /**
     * Creates new form ContactEditor
     */

    public OperationForm(boolean editMode, Operation operation, OperationManagement operationManagement) {
        this.editMode = editMode;
        this.operation = operation;
        this.operationManagement = operationManagement;
        mainPanel = new JPanel();
        nameLabel = new JLabel();
        operationName = new JTextField();
        descLabel = new JLabel();
        operationDesc = new JTextField();
        cancel = new JButton();
        ok = new JButton();
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setClosable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ROLEMANAGEMENT");

        mainPanel.setBorder(BorderFactory.createTitledBorder("ROLE"));

        nameLabel.setText("ROLENAME");

        if (editMode)
            operationName.setText(operation.getName());
        else
            operationName.setText("");

        descLabel.setText("ROLEDESCRIPTION");

        if (editMode)
            operationDesc.setText(operation.getDescription());
        else
            operationDesc.setText("");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(30, 30, 30)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(nameLabel)
                                        .add(descLabel))
                                .add(18, 18, 18)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, operationDesc, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                        .add(operationName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(nameLabel)
                                        .add(operationName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(operationDesc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(descLabel))
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               close(evt);
            }
        });

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (editMode)
                    edit(evt);
                else
                    add(evt);
            }
        });


        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(120, Short.MAX_VALUE)
                                .add(ok)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cancel)
                                .add(104, 104, 104))
        );

        layout.linkSize(new java.awt.Component[]{cancel, ok}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(cancel)
                                        .add(ok))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("User");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add(java.awt.event.ActionEvent evt) {

        Operation newOperation = new Operation();
        newOperation.setName(operationName.getText());
        newOperation.setDescription(operationDesc.getText());
        newOperation.setEnabled(true);
        newOperation.setDeleted("0");
        newOperation.setEffectorUser(ThreadPoolManager.me.getUsername());

        operationService.setServiceName("/createOperation");

        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(operationService.getServerUrl(), operationService.getServiceName(), new ObjectMapper().writeValueAsString(newOperation)), Operation.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        this.dispose();
        try {
            operationManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void edit(java.awt.event.ActionEvent evt) {

        operation.setName(operationName.getText());
        operation.setDescription(operationDesc.getText());
        operation.setEffectorUser(ThreadPoolManager.me.getUsername());

        operationService.setServiceName("/editOperation");

        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(operationService.getServerUrl(), operationService.getServiceName(), new ObjectMapper().writeValueAsString(operation)), Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        this.dispose();
        try {
            operationManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void close(java.awt.event.ActionEvent evt) {
        this.dispose();
        try {
            operationManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton cancel;
    private JButton ok;
    private JLabel nameLabel;
    private JLabel descLabel;
    private JPanel mainPanel;
    private JTextField operationName;
    private JTextField operationDesc;

    private boolean editMode;
    private Operation operation;
    private OperationManagement operationManagement;
    private WebServiceInfo operationService = new WebServiceInfo();
    // End of variables declaration//GEN-END:variables

}
