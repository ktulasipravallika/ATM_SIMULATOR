package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, fastCash, pinChange, cashWithdrawl, miniStatement, balanceEnquiry, exit;
    String pinNumber;

    Transactions(String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1000, 1000);
        add(image);
            
        JLabel text = new JLabel("Please select your transaction ");
        text.setBounds(240, 250, 700,18);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Time New Roman", Font.BOLD , 18));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(180, 345, 180,40);
        //deposit.setForeground(Color.WHITE);
        //deposit.setBackground(Color.BLACK);
        deposit.addActionListener(this);
        deposit.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(deposit);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(180, 385,180,40);
        fastCash.addActionListener(this);
        fastCash.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(fastCash);

        pinChange = new JButton("PIN Change");
        pinChange.setBounds(180, 425,180,40);
        pinChange.addActionListener(this);
        pinChange.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(pinChange);

        cashWithdrawl = new JButton("Cash Withdrawal");
        cashWithdrawl.setBounds(380, 345, 180,40);
        cashWithdrawl.addActionListener(this);
        cashWithdrawl.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(cashWithdrawl);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(380, 385, 180,40);
        miniStatement.addActionListener(this);
        miniStatement.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(miniStatement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(380, 425, 180,40);
        balanceEnquiry.addActionListener(this);
        balanceEnquiry.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(380, 465, 180,30);
        exit.addActionListener(this);
        exit.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(exit);

       

        setSize(1000, 1000);
        setTitle("");
        setLocation(50, 50);
        setVisible(true);
        setUndecorated(true);
        setLayout(null);
        setTitle("Transactions Screen");
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == cashWithdrawl){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
        try{

        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String[] args) {

        new Transactions("");
        
    }
    
}
