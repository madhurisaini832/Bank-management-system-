package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    JButton Withdrawl, back;
    JTextField amount;
    JLabel text, image;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 850, 750);
        add(image);

        text = new JLabel("Enter the amount you want to  Withdrawl");
        text.setBounds(160, 250, 340, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD, 16));
        amount.setBounds(170, 290, 290, 25);
        image.add(amount);
        Withdrawl = new JButton(" Withdrawl");
        Withdrawl.setBounds(330, 405, 150, 25);
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);
        back = new JButton("Back");
        back.setBounds(330, 430, 150, 25);
        back.addActionListener(this);
        image.add(back);
        setSize(850, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String number = amount.getText();
            Date date = new Date();
            if (ae.getSource() == Withdrawl) {
                if (number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    conn c = new conn();
                    c.s.executeUpdate("insert into bank values('" + pinnumber + "','" + date + "','" + Withdrawl + "','"
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
        new Withdrawl("").setVisible(true);
        ;

    }
}