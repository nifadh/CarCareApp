/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.EmployeeController;
import Models.Employee;

import javax.swing.*;

/**
 *
 * @author moham
 */
public class EmployeeUpdateView extends JFrame {

    /**
     * Creates new form EmployeeDetailsView
     */
    public EmployeeUpdateView() {
        initComponents();
        setResizable(false);
        empSaveDetailsBtn.setVisible(false);
    }

    public void populateFields(Employee employee) {
        empIdField.setText(String.valueOf(employee.getEmpID()));
        empNameField.setText(employee.getEmpName());
        empPositionField.setText(employee.getPosition());
        empNICField.setText(employee.getNic());
        empPhoneField.setText(employee.getPhone());
        empAddressField.setText(employee.getAddress());
        empEmailField.setText(employee.getEmail());
        empSalaryField.setText(String.valueOf(employee.getSalary()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        empIdLabel = new JLabel();
        empNameLabel = new JLabel();
        empPositionLabel = new JLabel();
        empNICLabel = new JLabel();
        empPhoneLabel = new JLabel();
        empAddressLabel = new JLabel();
        empEmailLabel = new JLabel();
        empSalaryLabel = new JLabel();
        empIdField = new JTextField();
        empNameField = new JTextField();
        empPositionField = new JTextField();
        empNICField = new JTextField();
        empPhoneField = new JTextField();
        empAddressField = new JTextField();
        empEmailField = new JTextField();
        empSalaryField = new JTextField();
        empDeleteButton = new JButton();
        empSaveDetailsBtn = new JButton();
        empUpdateButton = new JButton();


        empIdField.setEditable(false);
        empNameField.setEditable(false);
        empPositionField.setEditable(false);
        empNICField.setEditable(false);
        empPhoneField.setEditable(false);
        empAddressField.setEditable(false);
        empEmailField.setEditable(false);
        empSalaryField.setEditable(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setText("Update/Delete Employee");

        empIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empIdLabel.setText("Employee ID:");

        empNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empNameLabel.setText("Name:");

        empPositionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empPositionLabel.setText("Position:");

        empNICLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empNICLabel.setText("NIC: ");

        empPhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empPhoneLabel.setText("Phone:");

        empAddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empAddressLabel.setText("Address:");

        empEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empEmailLabel.setText("Email: ");

        empSalaryLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empSalaryLabel.setText("Salary: ");

        empIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empIdFieldActionPerformed(evt);
            }
        });

        empEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empEmailFieldActionPerformed(evt);
            }
        });

        empDeleteButton.setBackground(new java.awt.Color(255, 0, 0));
        empDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        empDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        empDeleteButton.setText("Delete");
        empDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empDeleteButtonActionPerformed(evt);
            }
        });

        empSaveDetailsBtn.setBackground(new java.awt.Color(0, 204, 102));
        empSaveDetailsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        empSaveDetailsBtn.setForeground(new java.awt.Color(255, 255, 255));
        empSaveDetailsBtn.setText("Save");
        empSaveDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empSaveDetailsBtnActionPerformed(evt);
            }
        });

        empUpdateButton.setBackground(new java.awt.Color(153, 153, 153));
        empUpdateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        empUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        empUpdateButton.setText("Update");
        empUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empUpdateButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(empNICLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empNICField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(empPhoneLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empPhoneField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(empAddressLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empAddressField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(empEmailLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empEmailField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(empIdLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(empIdField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(empNameLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                            .addComponent(empPositionLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(empPositionField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
                            .addComponent(empNameField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(empSalaryLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(empUpdateButton, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(empSaveDetailsBtn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(empDeleteButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                            .addComponent(empSalaryField, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(194, 194, 194))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empIdLabel)
                    .addComponent(empIdField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empNameLabel)
                    .addComponent(empNameField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empPositionField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(empPositionLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empNICField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(empNICLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empPhoneField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(empPhoneLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empAddressField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(empAddressLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empEmailField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(empEmailLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empSalaryField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(empSalaryLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(empSaveDetailsBtn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addComponent(empDeleteButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                    .addComponent(empUpdateButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empSaveDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int empId = Integer.parseInt(empIdField.getText());
        String empName = empNameField.getText();
        String empPosition = empPositionField.getText();
        String empNIC = empNICField.getText();
        String empPhone = empPhoneField.getText();
        String empAddress = empAddressField.getText();
        String empEmail = empEmailField.getText();
        String empSalary = empSalaryField.getText();

        Employee employee = new Employee(empId, empName, empPosition, empNIC, empPhone, empEmail, empAddress, empSalary);
        EmployeeController employeeController = new EmployeeController();
        if(employeeController.updateEmployeeInDatabase(employee)){
            JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Employee Update Failed");
        }

    }

    private void empDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empDeleteButtonActionPerformed
        // TODO add your handling code here:
        int empId = Integer.parseInt(empIdField.getText());
        EmployeeController employeeController = new EmployeeController();
        if(employeeController.deleteEmployeeFromDatabase(empId)){
            JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Employee Deletion Failed");
        }
    }//GEN-LAST:event_empDeleteButtonActionPerformed

    private void empIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empIdFieldActionPerformed

    private void empEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empEmailFieldActionPerformed

    private void empUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empUpdateButtonActionPerformed
        // TODO add your handling code here:
        empSaveDetailsBtn.setVisible(true);
        empUpdateButton.setEnabled(false);
        empDeleteButton.setVisible(false);

        empNameField.setEditable(true);
        empPositionField.setEditable(true);
        empNICField.setEditable(true);
        empPhoneField.setEditable(true);
        empAddressField.setEditable(true);
        empEmailField.setEditable(true);
        empSalaryField.setEditable(true);

    }//GEN-LAST:event_empUpdateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeUpdateView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField empAddressField;
    private JLabel empAddressLabel;
    private JButton empDeleteButton;
    private JTextField empEmailField;
    private JLabel empEmailLabel;
    private JTextField empIdField;
    private JLabel empIdLabel;
    private JTextField empNICField;
    private JLabel empNICLabel;
    private JTextField empNameField;
    private JLabel empNameLabel;
    private JTextField empPhoneField;
    private JLabel empPhoneLabel;
    private JTextField empPositionField;
    private JLabel empPositionLabel;
    private JTextField empSalaryField;
    private JLabel empSalaryLabel;
    private JButton empSaveDetailsBtn;
    private JButton empUpdateButton;
    private JLabel jLabel1;
    private JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}