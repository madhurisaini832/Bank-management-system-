package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {
    JButton next;
    JTextField aadhar, pan;
    JRadioButton syes, sno, eyes, eno, pannum;
    JComboBox religion, category, income, occupation, education, senoir;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW APPLICATION FORM - PAGE 2");
        JLabel additionalDetails = new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religions = new JLabel("Religion:");
        religions.setFont(new Font("Railway", Font.BOLD, 20));
        religions.setBounds(100, 120, 100, 30);
        add(religions);
        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 130, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categories = new JLabel("Category:");
        categories.setFont(new Font("Railway", Font.BOLD, 22));
        categories.setBounds(100, 170, 200, 30);
        add(categories);
        String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
        category = new JComboBox(valCategory);
        category.setBounds(300, 170, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomes = new JLabel("Income:");
        incomes.setFont(new Font("Railway", Font.BOLD, 22));
        incomes.setBounds(100, 220, 200, 30);
        add(incomes);
        String incomecategory[] = { "Null", "< 1,50,000", "< 2,50,000", "< 5,50,000", "Upto 10,00,000" };
        income = new JComboBox(incomecategory);
        income.setBounds(300, 210, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Railway", Font.BOLD, 22));
        educational.setBounds(100, 270, 200, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Railway", Font.BOLD, 22));
        qualification.setBounds(100, 300, 200, 30);
        add(qualification);
        String educationValue[] = { "Non-Graduation", "Graduate", "Post Graduation", "Doctrade", "Others" };
        education = new JComboBox(educationValue);
        education.setBounds(300, 300, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occcpations = new JLabel("Occupation:");
        occcpations.setFont(new Font("Railway", Font.BOLD, 22));
        occcpations.setBounds(100, 370, 200, 30);
        add(occcpations);
        String occupationValue[] = { "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
        occupation = new JComboBox(occupationValue);
        occupation.setBounds(300, 370, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pannum = new JLabel("PAN Number:");
        pannum.setFont(new Font("Railway", Font.BOLD, 22));
        pannum.setBounds(100, 420, 200, 30);
        add(pannum);

        pan = new JTextField();
        pan.setFont(new Font("Railway", Font.BOLD, 14));
        pan.setBounds(300, 420, 400, 30);
        add(pan);
        JLabel adhar = new JLabel("Aadhar Number:");
        adhar.setFont(new Font("Railway", Font.BOLD, 22));
        adhar.setBounds(100, 470, 200, 30);
        add(adhar);
        aadhar = new JTextField();
        aadhar.setFont(new Font("Railway", Font.BOLD, 14));
        aadhar.setBounds(300, 470, 400, 30);
        add(aadhar);
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Railway", Font.BOLD, 22));
        senior.setBounds(100, 520, 200, 30);
        add(senior);
        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Railway", Font.BOLD, 14));
        syes.setBounds(300, 520, 100, 30);
        add(syes);
        sno = new JRadioButton("No");
        sno.setFont(new Font("Railway", Font.BOLD, 14));
        sno.setBounds(600, 520, 100, 30);
        add(sno);
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
        JLabel account = new JLabel("Existing Account:");
        account.setFont(new Font("Railway", Font.BOLD, 22));
        account.setBounds(100, 570, 200, 30);
        add(account);
        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Railway", Font.BOLD, 14));

        eyes.setBounds(300, 570, 100, 30);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setFont(new Font("Railway", Font.BOLD, 14));
        eno.setBounds(600, 570, 100, 30);
        add(eno);
        ButtonGroup educaionGroup = new ButtonGroup();
        educaionGroup.add(eyes);
        educaionGroup.add(eno);

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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String scitizen = "";
        if (syes.isSelected()) {
            scitizen = "Yes";

        } else if (sno.isSelected()) {
            scitizen = "No";
        }
        String eaccount = "";
        if (eyes.isSelected()) {
            eaccount = "Yes";
        } else if (eno.isSelected()) {
            eaccount = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
        try {
            if (aadhar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                conn c = new conn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','"
                        + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "''"
                        + scitizen
                        + "','" + eaccount
                        + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("").setVisible(true);

    }
}
