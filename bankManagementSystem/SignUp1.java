package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import java.awt.event.*;


public class SignUp1 extends JFrame implements ActionListener{

    long random;
    JTextField nameField,fatherNamField,emailField, addressField, cityField, stateField ,pinCodeField;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, other;
    JButton nextButton;

    SignUp1() {

        Random rand = new Random();
        random = Math.abs((rand.nextLong() % 9000L) + 1000L);

        setLocation(50 , 50);
        setTitle("New Account Application - Page 1");
        setVisible(true);

        setLayout(null);
        JLabel header = new JLabel("Application Form No : " + random);
        header.setFont(new Font("Times New Roman" ,Font.BOLD, 35));
        header.setBounds(300,50 , 500, 40);
        add(header);

        JLabel pg1 = new JLabel("Page 1 : Personal Details ");
        pg1.setFont(new Font("Times New Roman" ,Font.BOLD, 25));
        pg1.setBounds(370,100 , 300, 25);
        add(pg1);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        name.setBounds(280,200 , 200, 20);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        nameField.setBounds(480,200 , 200, 20);
        add(nameField);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        fatherName.setBounds(280,240 , 200, 20);
        add(fatherName);

        fatherNamField = new JTextField();
        fatherNamField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        fatherNamField.setBounds(480,240 , 200, 20);
        add(fatherNamField);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        dob.setBounds(280,280 , 200, 20);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(480,280 , 200, 20);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        gender.setBounds(280,320 , 200, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(480, 320, 80, 20);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(550, 320, 80, 20);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(female);
        genderGroup.add(male);

        
        JLabel email = new JLabel("Email Address");
        email.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        email.setBounds(280,360 , 200, 20);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        emailField.setBounds(480,360 , 200, 20);
        add(emailField);

        JLabel maritalStat = new JLabel("Marital Status");
        maritalStat.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        maritalStat.setBounds(280,400 , 200, 20);
        add(maritalStat);

        married = new JRadioButton("Married");
        married.setBounds(480, 400, 80, 20);
        add(married);

        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(570, 400, 120, 20);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(680, 400, 80, 20);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Times New Roman" ,Font.BOLD, 18)); 
        address.setBounds(280,440 , 200, 20);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        addressField.setBounds(480,440 , 200, 20);
        add(addressField);

        JLabel city = new JLabel("City");
        city.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        city.setBounds(280,480 , 200, 20);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        cityField.setBounds(480,480 , 200, 20);
        add(cityField);

        JLabel state = new JLabel("State");
        state.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        state.setBounds(280,520 , 200, 20);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        stateField.setBounds(480,520 , 200, 20);
        add(stateField);

        JLabel pinCode = new JLabel("Pin Code");
        pinCode.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        pinCode.setBounds(280,560 , 200, 20);
        add(pinCode);

        pinCodeField = new JTextField();
        pinCodeField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        pinCodeField.setBounds(480,560 , 200, 20);
        add(pinCodeField);

        nextButton = new JButton("Next");
        nextButton.setBounds(750, 650, 80,20);
       // nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        nextButton.addActionListener(this);
        add(nextButton);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(1000, 1000);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameField.getText();
        String fatherName = fatherNamField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(male.isSelected()) gender = "Male";
        else if(female.isSelected()) gender = "Female";

        String email = emailField.getText();
        
        String marital = null;

        if(married.isSelected()) marital = "Married";
        else if(unmarried.isSelected()) marital = "Unmarried";
        else if(other.isSelected()) marital = "Other";

        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pinCode = pinCodeField.getText();

        try{
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null,"Name is Required");
                return;
             }
            if(fatherName.equals("")) {
                JOptionPane.showMessageDialog(null,"Father Name is Required");
                return;
             }
            if(dob.equals("")) {
                JOptionPane.showMessageDialog(null,"Date Of Birth is Required");
                return;
             }
            if(gender==null) {
                JOptionPane.showMessageDialog(null,"Gender is Required");
                return;
             } 
            if(email.equals("")) {
                JOptionPane.showMessageDialog(null,"Email Id is Required");
                return;
             }
            if(marital==null) {
                JOptionPane.showMessageDialog(null,"Marital Status is Required");
                return;
             }
            if(address.equals("")) {
                JOptionPane.showMessageDialog(null,"Address is Required");
                return;
             }
            if(state.equals("")) {
                JOptionPane.showMessageDialog(null,"State is Required");
                return;
            }
            if(city.equals("")) {
                JOptionPane.showMessageDialog(null,"City is Required");
                return;
             }
            if(pinCode.equals("")) {
                JOptionPane.showMessageDialog(null,"Pin Code is Required");
                return;
            }

            Conn c = new Conn();
            String query = "INSERT INTO SIGNUP VALUES ('"+formno+"','"+nameField.getText()+"', '"+fatherName+"' , '"+dob+"', '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"','"+city+"', '"+state+"', '"+ pinCode+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignUp2(formno).setVisible(true);

        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignUp1();
        
    }
    
}
