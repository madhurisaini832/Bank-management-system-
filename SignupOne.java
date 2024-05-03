package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    JLabel formno, name, fname, personalDetails, dob, city, state, pincode, gender, email, marital, address;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JTextField nameTextField, fnamTextField, emailTextField, addressTextField, stateTextField, pinTextField,
            cityTextField;
    JDateChooser dateChooser;
    Random ran = new Random();
    long random = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(random);

    SignupOne() {
        setLayout(null);
        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Railway", Font.BOLD, 38));
        formno.setBounds(120, 15, 600, 40);
        add(formno);
        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        nameTextField.setBounds(300, 130, 400, 30);
        add(nameTextField);
        name = new JLabel("Name:");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 120, 100, 30);
        add(name);
        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Railway", Font.BOLD, 22));
        fname.setBounds(100, 170, 200, 30);
        add(fname);
        fnamTextField = new JTextField();
        fnamTextField.setFont(new Font("Railway", Font.BOLD, 14));
        fnamTextField.setBounds(300, 170, 400, 30);
        add(fnamTextField);
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Railway", Font.BOLD, 22));
        dob.setBounds(100, 220, 200, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Railway", Font.BOLD, 22));
        gender.setBounds(100, 270, 200, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 270, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 270, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        email = new JLabel("Email Address:");
        email.setFont(new Font("Railway", Font.BOLD, 22));
        email.setBounds(100, 320, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway", Font.BOLD, 14));
        emailTextField.setBounds(300, 320, 400, 30);
        add(emailTextField);
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Railway", Font.BOLD, 22));
        marital.setBounds(100, 370, 200, 30);
        add(marital);
        address = new JLabel("Address:");
        address.setFont(new Font("Railway", Font.BOLD, 22));
        address.setBounds(100, 420, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway", Font.BOLD, 14));
        addressTextField.setBounds(300, 420, 400, 30);
        add(addressTextField);
        married = new JRadioButton("married");
        married.setBounds(300, 370, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(450, 370, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("other");
        other.setBounds(630, 370, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        city = new JLabel("City:");
        city.setFont(new Font("Railway", Font.BOLD, 22));
        city.setBounds(100, 470, 200, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway", Font.BOLD, 14));
        cityTextField.setBounds(300, 460, 400, 30);
        add(cityTextField);
        state = new JLabel("State:");
        state.setFont(new Font("Railway", Font.BOLD, 22));
        state.setBounds(100, 520, 200, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway", Font.BOLD, 14));
        stateTextField.setBounds(300, 510, 400, 30);
        add(stateTextField);
        pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Railway", Font.BOLD, 22));
        pincode.setBounds(100, 570, 200, 30);
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Railway", Font.BOLD, 14));
        pinTextField.setBounds(300, 560, 400, 30);
        add(pinTextField);
        next = new JButton("Next");

        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 610, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(300, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = first;
        String n1 = nameTextField.getText();
        String f1 = fnamTextField.getText();
        String birth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";

        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String addr = addressTextField.getText();
        String c1 = cityTextField.getText();
        String s1 = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if (name.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                conn c = new conn();
                String query = "insert into signupone values('" + formno + "','" + n1 + "','" + f1 + "','" + birth
                        + "','" + gender + "','" + marital + "'," + email + "','" + addr + "','" + c1 + "''"
                        + s1 + "','" + pin
                        + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SignupOne().setVisible(true);
    }
}
