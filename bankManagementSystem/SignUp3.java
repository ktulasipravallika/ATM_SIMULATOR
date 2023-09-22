package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUp3 extends JFrame implements ActionListener {

    JRadioButton savingAcc, currAcc, fixDepAcc, recDepAcc;
    JCheckBox atm, ib, mb, eands, cb, es, declare;
    JButton submit, cancel;
    String formNo;

    SignUp3(String formNo) {

        this.formNo = formNo;

        setVisible(true);
        setLayout(null);
        setTitle("New Account Creation - Page 3");

        JLabel pg3 = new JLabel("Page 3 : Additional Details");
        pg3.setBounds(370, 100, 300, 25);
        pg3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(pg3);

        JLabel accType = new JLabel("Accout Type");
        accType.setFont(new Font("Times New Roman", Font.BOLD, 18));
        accType.setBounds(200, 200, 200, 20);
        add(accType);

        savingAcc = new JRadioButton("Savings Account");
        savingAcc.setFont(new Font("Times New Roman", Font.BOLD, 15));
        savingAcc.setBounds(250, 240, 150, 20);
        add(savingAcc);

        currAcc = new JRadioButton("Current Account");
        currAcc.setFont(new Font("Times New Roman", Font.BOLD, 15));
        currAcc.setBounds(250, 270, 150, 20);
        add(currAcc);

        fixDepAcc = new JRadioButton("Fixed Deposit Account");
        fixDepAcc.setFont(new Font("Times New Roman", Font.BOLD, 15));
        fixDepAcc.setBounds(450, 240, 200, 20);
        add(fixDepAcc);

        recDepAcc = new JRadioButton("Recurring Deposit Account");
        recDepAcc.setFont(new Font("Times New Roman", Font.BOLD, 15));
        recDepAcc.setBounds(450, 270, 250, 20);
        add(recDepAcc);

        ButtonGroup accTypeGroup = new ButtonGroup();
        accTypeGroup.add(currAcc);
        accTypeGroup.add(savingAcc);
        accTypeGroup.add(fixDepAcc);
        accTypeGroup.add(recDepAcc);

        JLabel cardNumber = new JLabel("Card Number");
        cardNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cardNumber.setBounds(200, 330, 200, 20);
        add(cardNumber);

        JLabel cardNoDesc = new JLabel("(Your 14 Digit Card Number)");
        cardNoDesc.setFont(new Font("Times New Roman", Font.BOLD, 10));
        cardNoDesc.setBounds(200, 350, 200, 15);
        add(cardNoDesc);

        JLabel cardNum = new JLabel("XXXX-XXXX-XXXX-1111");
        cardNum.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cardNum.setBounds(450, 330, 250, 20);
        add(cardNum);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 18));
        pin.setBounds(200, 390, 200, 20);
        add(pin);

        JLabel pinDesc = new JLabel("(Your 4 Digit Password)");
        pinDesc.setFont(new Font("Times New Roman", Font.BOLD, 10));
        pinDesc.setBounds(200, 410, 200, 15);
        add(pinDesc);

        JLabel pinNum = new JLabel("XXXX");
        pinNum.setFont(new Font("Times New Roman", Font.BOLD, 18));
        pinNum.setBounds(450, 390, 100, 20);
        add(pinNum);

        JLabel servRequired = new JLabel("Services Required");
        servRequired.setFont(new Font("Times New Roman", Font.BOLD, 18));
        servRequired.setBounds(200, 450, 200, 20);
        add(servRequired);

        atm = new JCheckBox("ATM CARD");
        atm.setFont(new Font("Times New Roman", Font.BOLD, 15));
        atm.setBounds(250, 490, 150, 20);
        add(atm);

        mb = new JCheckBox("Mobile Banking");
        mb.setFont(new Font("Times New Roman", Font.BOLD, 15));
        mb.setBounds(250, 520, 150, 20);
        add(mb);

        cb = new JCheckBox("Cheque Book");
        cb.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cb.setBounds(250, 550, 150, 20);
        add(cb);

        ib = new JCheckBox("Internet Banking");
        ib.setFont(new Font("Times New Roman", Font.BOLD, 15));
        ib.setBounds(450, 490, 150, 20);
        add(ib);

        eands = new JCheckBox("Email & SMS Alerts");
        eands.setFont(new Font("Times New Roman", Font.BOLD, 15));
        eands.setBounds(450, 520, 150, 20);
        add(eands);

        es = new JCheckBox("E-Statement");
        es.setFont(new Font("Times New Roman", Font.BOLD, 15));
        es.setBounds(450, 550, 150, 20);
        add(es);

        declare = new JCheckBox(
                "I hereby declare that the above entered details are correct to the best of my knwoledge");
        declare.setFont(new Font("Times New Roman", Font.BOLD, 13));
        declare.setBounds(200, 620, 600, 20);
        add(declare);

        submit = new JButton("Submit");
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        submit.setBounds(350, 680, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cancel.setBounds(450, 680, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(1000, 1000);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String accountType = null;

            if (savingAcc.isSelected())
                accountType = "Savings Account";
            else if (currAcc.isSelected())
                accountType = "Current Account";
            else if (fixDepAcc.isSelected())
                accountType = "Fixed Deposit Account";
            else if (recDepAcc.isSelected())
                accountType = "Recurring Deposit Account";

            Random rand = new Random();
            String cardNumber = "" + Math.abs((rand.nextLong() % 90000000L) + 504093600000000L);
            String pinNum = "" + Math.abs((rand.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (atm.isSelected())
                facility = facility + "ATM Card";
            else if (cb.isSelected())
                facility = facility + "Cheque Book";
            else if (mb.isSelected())
                facility = facility + "Mobile Banking";
            else if (eands.isSelected())
                facility = facility + "Email & SMS Alerts";
            else if (es.isSelected())
                facility = facility + "E-Statement";
            else if (ib.isSelected())
                facility = facility + "Internet Banking";

            try {
                if (accountType==null) {
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                    return;
                }
                if(facility == ""){
                    JOptionPane.showMessageDialog(null,"The Services Required needs to be selected");                }

                Conn c = new Conn();
                String query = "INSERT INTO SIGNUP3 VALUES('" + formNo + "', '" + accountType + "' , '" + cardNumber
                        + "', '" + pinNum + "', '" + facility + "')";
                String query2= "INSERT INTO LOGIN VALUES('"+formNo+"', '"+cardNumber+"', '"+pinNum+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Please check Card Number and PIN : \n \n" + "Card Number is " + cardNumber + "\nPin Number is "+ pinNum);
                
                setVisible(false);
                new Deposit(pinNum).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            
            setVisible(false);
            new Login().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new SignUp3("");
    }

}
