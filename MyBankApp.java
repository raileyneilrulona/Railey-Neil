package FirstWindowpackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MyBankApp extends JFrame {
    private JTextField txtHolder, txtAccountNo, txtType, txtBalance;
    private JTable table;
    private DefaultTableModel model;
    private BankManager manager;

    public MyBankApp() {
        manager = new BankManager();

        setTitle("Bank Account Management System");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ---- LEFT PANEL: Form + Buttons ----
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Account Information"));

        txtHolder = createField(leftPanel, "Account Holder:");
        txtAccountNo = createField(leftPanel, "Account No.:");
        txtType = createField(leftPanel, "Account Type:");
        txtBalance = createField(leftPanel, "Balance:");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear = new JButton("Clear");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(buttonPanel);
        leftPanel.add(Box.createVerticalGlue());

        add(leftPanel, BorderLayout.WEST);

        // ---- RIGHT PANEL: Table ----
        model = new DefaultTableModel(new String[]{"Holder", "Account No.", "Type", "Balance"}, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Account List"));
        add(scrollPane, BorderLayout.CENTER);

        // ---- ACTION LISTENERS ----
        btnAdd.addActionListener(e -> addAccount());
        btnUpdate.addActionListener(e -> updateAccount());
        btnDelete.addActionListener(e -> deleteAccount());
        btnClear.addActionListener(e -> clearFields());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    txtHolder.setText(model.getValueAt(row, 0).toString());
                    txtAccountNo.setText(model.getValueAt(row, 1).toString());
                    txtType.setText(model.getValueAt(row, 2).toString());
                    txtBalance.setText(model.getValueAt(row, 3).toString());
                }
            }
        });

        setVisible(true);
    }

    private JTextField createField(JPanel panel, String label) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row.add(new JLabel(label));
        JTextField field = new JTextField(15);
        row.add(field);
        panel.add(row);
        return field;
    }

    // ---- SAME METHODS FOR add/update/delete/validation ----
    private void addAccount() {
        if (!validateInput()) return;

        double balance = parseBalance();
        if (balance < 0) return;

        manager.addAccount(new BankAccount(
            txtHolder.getText(),
            txtAccountNo.getText(),
            txtType.getText(),
            balance
        ));
        loadTable();
        clearFields();
    }

    private void updateAccount() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select an account to update");
            return;
        }

        if (!validateInput()) return;
        double balance = parseBalance();
        if (balance < 0) return;

        manager.updateAccount(row, new BankAccount(
            txtHolder.getText(),
            txtAccountNo.getText(),
            txtType.getText(),
            balance
        ));
        loadTable();
        clearFields();
    }

    private void deleteAccount() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this account?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                manager.deleteAccount(row);
                loadTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select an account to delete");
        }
    }

    private boolean validateInput() {
        if (txtHolder.getText().isEmpty() ||
            txtAccountNo.getText().isEmpty() ||
            txtType.getText().isEmpty() ||
            txtBalance.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "All fields must be filled!");
            return false;
        }
        return true;
    }

    private double parseBalance() {
        try {
            return Double.parseDouble(txtBalance.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Balance must be a number!");
            return -1;
        }
    }

    private void loadTable() {
        model.setRowCount(0);
        for (BankAccount a : manager.getAllAccounts()) {
            model.addRow(new Object[]{
                a.getHolder(),
                a.getAccountNo(),
                a.getType(),
                a.getBalance()
            });
        }
    }

    private void clearFields() {
        txtHolder.setText("");
        txtAccountNo.setText("");
        txtType.setText("");
        txtBalance.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyBankApp());
    }
}

  
