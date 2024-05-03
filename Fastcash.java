package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    Fastcash(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 750);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        deposit = new JButton("Rs 100");
        deposit.setBounds(150, 345, 150, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(330, 345, 150, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(150, 375, 150, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(330, 375, 150, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(150, 405, 150, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(330, 405, 150, 25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        exit = new JButton("BACK");
        exit.setBounds(330, 435, 150, 25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(850, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            conn c = new conn();
            int balance = 0;
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pinnumber + "'");
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insefficient Balance");
                    Date date = new Date();
                    String querry = "insert into bank values('" + pinnumber + "','" + date + "','" + withdrawl + "','"
                            + amount + "')";
                    c.s.executeUpdate(querry);
                    JOptionPane.showMessageDialog(null, "Rs" + amount + "Debited Successifully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Fastcash("").setVisible(true);

    }
}