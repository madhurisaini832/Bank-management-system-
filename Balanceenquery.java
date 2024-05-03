package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Balanceenquery extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;

    Balanceenquery(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 750);
        add(image);
        back = new JButton("BACK");
        back.setBounds(330, 435, 150, 25);
        back.addActionListener(this);
        image.add(back);
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
        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel text = new JLabel("Your Current Account Balance is Rs" + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(210, 250, 600, 20);
        image.add(text);
        setSize(850, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new Balanceenquery("");

    }

}
