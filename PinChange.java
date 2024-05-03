package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 750);
        add(image);
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        JLabel pintext = new JLabel("New PIN");
        pintext.setBounds(150, 290, 290, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Railway", Font.BOLD, 16));
        image.add(pintext);
        pin = new JPasswordField("");
        pin.setFont(new Font("Railway", Font.BOLD, 25));
        pin.setBounds(300, 290, 180, 25);
        image.add(pin);
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setBounds(150, 320, 290, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Railway", Font.BOLD, 16));
        image.add(repintext);
        repin = new JPasswordField();
        repin.setFont(new Font("Railway", Font.BOLD, 25));
        repin.setBounds(300, 320, 180, 25);
        image.add(repin);
        change = new JButton("CHANGE");
        change.setBounds(330, 405, 150, 25);
        change.addActionListener(this);
        image.add(change);
        back = new JButton("BACK");
        back.setBounds(330, 430, 150, 25);
        back.addActionListener(this);
        image.add(back);
        setSize(850, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                conn conn = new conn();
                String query1 = "update bank set pin = '" + rpin + "'where pin= '" + pinnumber + "'";
                String query2 = "update login set pin = '" + rpin + "'where pin= '" + pinnumber + "'";
                String query3 = "update signupthree set pin = '" + rpin + "'where pin= '" + pinnumber + "'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
