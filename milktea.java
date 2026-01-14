package newpackage;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class milktea {

    private JFrame frame;

    // Checkboxes
    private JCheckBox chckbxOkinawa;
    private JCheckBox chckbxMatcha;
    private JCheckBox chckbxWM;
    private JCheckBox chckbxHotdog;
    private JCheckBox chckbxBurger;
    private JCheckBox chckbxBugerWithCheese;

    // NEW COMPONENTS
    private JComboBox<String> comboPayment;
    private JRadioButton rdbtnDineIn, rdbtnTakeOut;
    private ButtonGroup sankain;

    private JTextArea textArea;
    private JButton btnCheckOut;

    // Prices
    private final int OKINAWA_PRICE = 29;
    private final int MATCHA_PRICE = 29;
    private final int WINTERMELON_PRICE = 29;
    private final int BURGER_PRICE = 50;
    private final int BURGER_WITH_CHEESE_PRICE = 70;
    private final int HOTDOG_PRICE = 60;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                milktea window = new milktea();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public milktea() {
        initialize();
        createEvent();
    }

    private void initialize() {

        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
        frame.setBounds(100, 100, 1050, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Milk Tea Shop");
        lblTitle.setBounds(155, -3, 200, 46);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        frame.getContentPane().add(lblTitle);

        // ========================
        // MILKTEA PANEL
        // ========================
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(33, 54, 366, 99);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblMilktea = new JLabel("Milktea");
        lblMilktea.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMilktea.setBounds(160, 11, 80, 14);
        panel.add(lblMilktea);

        chckbxOkinawa = new JCheckBox("Okinawa 29");
        chckbxOkinawa.setBounds(6, 46, 120, 23);
        panel.add(chckbxOkinawa);

        chckbxMatcha = new JCheckBox("Matcha 29");
        chckbxMatcha.setBounds(126, 46, 120, 23);
        panel.add(chckbxMatcha);

        chckbxWM = new JCheckBox("Wintermelon 29");
        chckbxWM.setBounds(246, 46, 120, 23);
        panel.add(chckbxWM);

        // ========================
        // SNACKS PANEL
        // ========================
        JPanel panelSnacks = new JPanel();
        panelSnacks.setLayout(null);
        panelSnacks.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelSnacks.setBounds(554, 54, 366, 99);
        frame.getContentPane().add(panelSnacks);

        JLabel lblSnacks = new JLabel("Snacks");
        lblSnacks.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSnacks.setBounds(156, 11, 80, 14);
        panelSnacks.add(lblSnacks);

        chckbxBurger = new JCheckBox("Burger 50");
        chckbxBurger.setBounds(6, 46, 120, 23);
        panelSnacks.add(chckbxBurger);

        chckbxBugerWithCheese = new JCheckBox("Burger w/ Cheese 70");
        chckbxBugerWithCheese.setBounds(126, 46, 149, 23);
        panelSnacks.add(chckbxBugerWithCheese);

        chckbxHotdog = new JCheckBox("Hotdog 60");
        chckbxHotdog.setBounds(277, 46, 120, 23);
        panelSnacks.add(chckbxHotdog);

        // ========================
        // PAYMENT METHOD (Combo Box)
        // ========================
        JLabel lblPayment = new JLabel("Payment Method:");
        lblPayment.setBounds(33, 165, 150, 23);
        frame.getContentPane().add(lblPayment);

        comboPayment = new JComboBox<>();
        comboPayment.addItem("Cash");
        comboPayment.addItem("GCash");
        comboPayment.addItem("Maya");
        comboPayment.addItem("Credit Card");
        comboPayment.setBounds(150, 165, 150, 23);
        frame.getContentPane().add(comboPayment);

        // ========================
        // DINE-IN / TAKE-OUT (Radio Buttons)
        // ========================
        JLabel lblDine = new JLabel("Order Type:");
        lblDine.setBounds(33, 195, 150, 23);
        frame.getContentPane().add(lblDine);

        rdbtnDineIn = new JRadioButton("Dine In");
        rdbtnDineIn.setBounds(150, 195, 80, 23);

        rdbtnTakeOut = new JRadioButton("Take Out");
        rdbtnTakeOut.setBounds(230, 195, 100, 23);

        // Group radio buttons
        sankain = new ButtonGroup();
        sankain.add(rdbtnDineIn);
        sankain.add(rdbtnTakeOut);

        frame.getContentPane().add(rdbtnDineIn);
        frame.getContentPane().add(rdbtnTakeOut);

        // ========================
        // RESULT TEXT AREA
        // ========================
        textArea = new JTextArea();
        textArea.setBounds(50, 240, 350, 100);
        frame.getContentPane().add(textArea);

        // ========================
        // CHECKOUT BUTTON
        // ========================
        btnCheckOut = new JButton("Check Out");
        btnCheckOut.setBounds(420, 240, 120, 30);
        frame.getContentPane().add(btnCheckOut);
    }

    private void createEvent() {
        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int total = 0;
                String order = "Your Order:\n";

                // MILKTEA
                if (chckbxOkinawa.isSelected()) {
                    total += OKINAWA_PRICE;
                    order += "- Okinawa: 29\n";
                }

                if (chckbxMatcha.isSelected()) {
                    total += MATCHA_PRICE;
                    order += "- Matcha: 29\n";
                }

                if (chckbxWM.isSelected()) {
                    total += WINTERMELON_PRICE;
                    order += "- Wintermelon: 29\n";
                }

                // SNACKS
                if (chckbxBurger.isSelected()) {
                    total += BURGER_PRICE;
                    order += "- Burger: 50\n";
                }

                if (chckbxBugerWithCheese.isSelected()) {
                    total += BURGER_WITH_CHEESE_PRICE;
                    order += "- Burger w/ Cheese: 70\n";
                }

                if (chckbxHotdog.isSelected()) {
                    total += HOTDOG_PRICE;
                    order += "- Hotdog: 60\n";
                }

                // PAYMENT METHOD
                String payment = comboPayment.getSelectedItem().toString();
                order += "\nPayment Method: " + payment;

                // DINE-IN / TAKE-OUT
                String orderType = "Not selected";
                if (rdbtnDineIn.isSelected()) orderType = "Dine In";
                if (rdbtnTakeOut.isSelected()) orderType = "Take Out";

                order += "\nOrder Type: " + orderType;

                // TOTAL
                order += "\n\nTotal: " + total + " PHP";

                textArea.setText(order);
            }
        });
    }
}