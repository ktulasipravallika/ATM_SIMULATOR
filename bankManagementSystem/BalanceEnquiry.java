package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinNumber;
    JButton back;

    BalanceEnquiry(String pinNumber){

        this.pinNumber = pinNumber;
        int balance = 0 ;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1000, 1000);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
            

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance =balance +  Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
             
        JLabel text = new JLabel("Your Current Balance is : ");
        text.setBounds(280, 350, 700,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Time New Roman", Font.PLAIN , 18));
        image.add(text);

        JLabel balanceAmt = new JLabel("Rs. "+ balance);
        balanceAmt.setBounds(300, 400, 700,25);
        balanceAmt.setForeground(Color.WHITE);
        balanceAmt.setFont(new Font("Time New Roman", Font.PLAIN , 18));
        image.add(balanceAmt);


        back = new JButton("Back");
        back.setBounds(410, 560, 150,36);
        back.addActionListener(this);
        back.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(back);

        setSize(1000, 1000);
        setLocation(50, 50);
        setVisible(true);
        //setUndecorated(true);
        setLayout(null);
        setTitle("Balance Enquiry Screen");


    }

    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
        
    }
    
}
