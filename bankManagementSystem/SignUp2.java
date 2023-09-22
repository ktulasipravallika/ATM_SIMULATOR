package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener {

    JTextField panField,aadharField;
    JButton nextButton;
    JRadioButton senCit, notSenCit, newAcc, oldAcc, exiAccountGroup;
    JComboBox religionField, categoryField, incomeField, eduQualField, occupField;
    String formNo;

    SignUp2(String formNo){

        this.formNo = formNo;

        setVisible(true);
        setTitle("New Account Creation - Page 2");
        setLayout(null);

        JLabel pg2 = new JLabel("Page 2 : Additional Details ");
        pg2.setBounds(370, 100, 300, 25);
        pg2.setFont(new Font("Times New Roman", Font.BOLD , 25));
        add(pg2);

        JLabel religion = new JLabel("Religion");
        religion.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        religion.setBounds(280,200 , 200, 20);
        add(religion);

        String religionTypes[] = {"Hindu", "Muslim", "Christian", "Sikh", "Others"};
        religionField = new JComboBox<>(religionTypes);
        religionField.setBounds(530, 200, 200, 20);
        add(religionField);
    
        JLabel category = new JLabel("Category");
        category.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        category.setBounds(280,240 , 200, 20);
        add(category);

        String categoryTypes[] = {"OC", "BC", "SC", "ST", "Others"};
        categoryField = new JComboBox<>(categoryTypes);
        categoryField.setBounds(530, 240, 200, 20);
        add(categoryField);

        JLabel income = new JLabel("Income");
        income.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        income.setBounds(280,280 , 200, 20);
        add(income);

        String incomeTypes[] = {"Null", "< 1,50, 000", "< 2, 50, 000>", "< 5, 00, 000>", "Up to 10, 00, 000", "More"};
        incomeField = new JComboBox<>(incomeTypes);
        incomeField.setBounds(530, 280, 200, 20);
        add(incomeField);

        JLabel edQual = new JLabel("Educational Qualification");
        edQual.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        edQual.setBounds(280,320 , 200, 20);
        add(edQual);

        String edQualTypes[] = {"Non - Graduation", "Graduate", "Post Graduation" , "Doctrate", "Others"}; 
        eduQualField = new JComboBox<>(edQualTypes);
        eduQualField.setBounds(530, 320, 200, 20);
        add(eduQualField);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        occupation.setBounds(280,360 , 200, 20);
        add(occupation);

        String occupationTypes[] = {"Salaried", "Self - Employed", " Bussiness" , "Student", "Retired", "Others"}; 
        occupField = new JComboBox<>(occupationTypes);
        occupField.setBounds(530, 360, 200, 20);
        add(occupField);

        JLabel pan = new JLabel("PAN Number");
        pan.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        pan.setBounds(280,400 , 200, 20);
        add(pan);

        panField = new JTextField();
        panField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        panField.setBounds(530,400 , 200, 20);
        add(panField);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Times New Roman" ,Font.BOLD, 18)); 
        aadhar.setBounds(280,440 , 200, 20);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        aadharField.setBounds(530,440 , 200, 20);
        add(aadharField);

        JLabel senCitizen = new JLabel("Senior Citizen");
        senCitizen.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        senCitizen.setBounds(280,480 , 200, 20);
        add(senCitizen);

        senCit = new JRadioButton("Yes");
        senCit.setBounds(530, 480, 80, 20);
        add(senCit);

        notSenCit = new JRadioButton("No");
        notSenCit.setBounds(620, 480, 120, 20);
        add(notSenCit);

        ButtonGroup senCitGroup = new ButtonGroup();
        senCitGroup.add(senCit);
        senCitGroup.add(notSenCit);

        JLabel exiAccount = new JLabel("Existing Account");
        exiAccount.setFont(new Font("Times New Roman" ,Font.BOLD, 18));
        exiAccount.setBounds(280,520 , 200, 20);
        add(exiAccount);

        newAcc = new JRadioButton("Yes");
        newAcc.setBounds(530, 520, 80, 20);
        add(newAcc);

        oldAcc = new JRadioButton("No");
        oldAcc.setBounds(620, 520, 80, 20);
        add(oldAcc);

        ButtonGroup exisAccGroup = new ButtonGroup();
        exisAccGroup.add(newAcc);
        exisAccGroup.add(oldAcc);
  
        nextButton = new JButton("Next");
        nextButton.setBounds(750, 650, 80,20);
       // nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Times New Roman" ,Font.PLAIN, 18));
        nextButton.addActionListener(this);
        add(nextButton);

        setLocation(50, 50);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(1000,1000);
      
    }

    public void actionPerformed(ActionEvent ae){

        String sReligion = (String) religionField.getSelectedItem();
        String sCategory = (String) categoryField.getSelectedItem();
        String sIncome = (String) incomeField.getSelectedItem();
        String sEdQual = (String) eduQualField.getSelectedItem();
        String sOccupation = (String) occupField.getSelectedItem();
        String sPan = panField.getText();
        String sAadhar = aadharField.getText();

        String sSenCit = null;
        
        if(senCit.isSelected()) sSenCit = "Yes";
        if(notSenCit.isSelected()) sSenCit = "No";

        String existAcc = null;
        
        if(newAcc.isSelected()) existAcc = "Yes";
        if(oldAcc.isSelected()) existAcc = "No";

        try{
            if(sReligion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Religion is required"); 
                return;
            }
            if(sCategory.isEmpty()){
                JOptionPane.showMessageDialog(null, "Category is required");
                return;
            }
            if(sIncome.isEmpty()){
                JOptionPane.showMessageDialog(null, "Income is required");
                return;
            }
            if(sEdQual.isEmpty()){
                JOptionPane.showMessageDialog(null, "Education Qualificaton is required");
                return;
            }
            if(sOccupation.isEmpty()){
                JOptionPane.showMessageDialog(null, "Occupation is required");
                return;
            }
            if(sPan.isEmpty()){
                JOptionPane.showMessageDialog(null, "Pan Number is required");
                return;
            }
            if(sAadhar.isEmpty()){
                JOptionPane.showMessageDialog(null, "Aadhar Number is required");
                return;
            }
            if(sSenCit == null){
                JOptionPane.showMessageDialog(null, "Senior Citizen Field is required");
                return;
            }
            if(existAcc == null){
                JOptionPane.showMessageDialog(null, "Existing Account Field is required");
                return;
            }

            else{
                Conn c = new Conn();
                String query = "INSERT INTO SIGNUP2 VALUES ('"+formNo+"', '"+sReligion+"', '"+sCategory+"', '"+sIncome+"', '"+sEdQual+"','"+sOccupation+"','"+sPan+"', '"+sAadhar+"','"+sSenCit+"','"+existAcc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUp3(formNo).setVisible(true);
            }

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    
    public static void main(String[] args) {
        new SignUp2("");
    }
}