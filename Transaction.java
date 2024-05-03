package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pin;

    Transaction(String pin) {
        this.pin = pin;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 750);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 345, 150, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(330, 345, 150, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150, 375, 150, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(330, 375, 150, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(150, 405, 150, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(330, 405, 150, 25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        exit = new JButton("Exit");
        exit.setBounds(330, 435, 150, 25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(850, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            setVisible(false);
            new deposit(pin).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new Balanceenquery(pin).setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transaction("").setVisible(true);

    }
}