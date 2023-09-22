package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton signIn, clear, signUp;
    JTextField cardText;
    JPasswordField pinText;

    Login(){
        
        setTitle("Bank Management System");
        setVisible(true);
        setLocation(50, 50);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
       
        setLayout(null);
        label.setBounds(70, 30, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to Tulasi Bank!");
        text.setFont(new Font("Times New Roman", Font.BOLD, 40));
        text.setBounds(190, 70, 500, 40);
        add(text);

        JLabel CardNumber = new JLabel("Card Number");
        CardNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
        CardNumber.setBounds(450, 350, 100, 20);
        add(CardNumber);

        cardText = new JTextField();
        cardText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cardText.setBounds(550, 350, 100, 20);
        add(cardText);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pin.setBounds(450, 400, 50, 20);
        add(pin);

        pinText = new JPasswordField();
        pinText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pinText.setBounds(550, 400, 100, 20);
        add(pinText);

        signIn = new JButton("SIGN IN");
        signIn.setForeground(Color.BLACK);
        signIn.setBackground(Color.WHITE);
        signIn.setBounds(430, 460, 100, 20);
        signIn.addActionListener(this);
        add(signIn);

        clear = new JButton("CLEAR");
        clear.setForeground(Color.BLACK);
        clear.setBackground(Color.WHITE);
        clear.setBounds(570, 460, 100, 20);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setForeground(Color.BLACK);
        signUp.setBackground(Color.WHITE);
        signUp.setBounds(430, 500, 240, 20);
        signUp.addActionListener(this);
        add(signUp);
     
        getContentPane().setBackground(Color.LIGHT_GRAY);
       
        
        setSize(1000, 1000);
        
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== signIn){

            Conn c = new Conn();
            String cardNum = cardText.getText();
            String pinNum = pinText.getText();
            
            String query = "Select * from login where cardNumber = '"+cardNum+"' and pin_number = '"+pinNum+"'";

            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
           

        }
        else if(ae.getSource() == clear ){
            cardText.setText("");
            pinText.setText("");
        }
        else if(ae.getSource() == signUp){
            setVisible(false);
            new SignUp1().setVisible(true);
        }

    }

    
    public static void main(String[] args) {
        new Login(); 
    }
    
}
