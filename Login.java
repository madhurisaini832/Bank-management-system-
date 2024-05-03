package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel text, cardno, pin;
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    String pinnumber;

    Login(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 30, 350, 30);
        add(text);
        cardno = new JLabel("Card No. :");
        cardno.setFont(new Font("Raleway", Font.BOLD, 30));
        cardno.setBounds(150, 130, 150, 30);
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 130, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(200, 200, 350, 30);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 200, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        clear = new JButton("clear");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);
        setSize(800, 480);
        setVisible(true);
        setLocation(250, 150);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == login) {
                conn conn = new conn();
                String cardnumber = cardTextField.getText();
                String pinnumber = pinTextField.getText();
                String querry = "select * from login where cardno = '" + cardnumber + "' and pin = '" + pinnumber + "'";
                ResultSet rs = conn.s.executeQuery(querry);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } else if (ae.getSource() == clear) {
                cardTextField.setText("");
                pinTextField.setText("");
            } else if (ae.getSource() == signup) {
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login("").setVisible(true);
    }
}
