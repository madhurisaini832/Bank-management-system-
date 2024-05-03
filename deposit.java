package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class deposit extends JFrame implements ActionListener {
    JButton deposit, back;
    JTextField amount;
    JLabel text, image;
    String pinnumber;

    deposit(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 850, 750);
        add(image);

        text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(170, 250, 290, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD, 16));
        amount.setBounds(170, 290, 290, 25);
        image.add(amount);
        deposit = new JButton("Deposit");
        deposit.setBounds(330, 405, 150, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        back = new JButton("Back");
        back.setBounds(330, 430, 150, 25);
        back.addActionListener(this);
        image.add(back);
        setSize(850, 850);
        setLocation(300, 0);
        setVisible(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String number = amount.getText();
            Date date = new Date();
            if (ae.getSource() == deposit) {
                if (number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    conn c = new conn();
                    c.s.executeUpdate("insert into bank values('" + pinnumber + "','" + date + "','" + deposit + "','"
                            + number
                            + "')");
                    JOptionPane.showMessageDialog(null, "Rs " + number + "Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new deposit("").setVisible(true);
        ;

    }
}