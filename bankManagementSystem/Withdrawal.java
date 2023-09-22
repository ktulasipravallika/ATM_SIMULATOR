package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawal extends JFrame implements ActionListener{

    JButton  deposit, back;
    JTextField amount;
    String pinNumber;

    Withdrawal(String pinNumber){
        
        this.pinNumber = pinNumber;
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1000, 1000);
        add(image);
            
        JLabel text = new JLabel("Please enter the amount you want to withdraw : ");
        text.setBounds(190, 350, 700,18);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Time New Roman", Font.BOLD , 15));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(270, 400, 200,40);
        amount.setFont(new Font("Time New Roman", Font.BOLD , 20));
        image.add(amount);

        deposit = new JButton("Withdraw");
        deposit.setBounds(410, 525, 150,36);
        deposit.addActionListener(this);
        deposit.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(410, 565, 150,36);
        back.addActionListener(this);
        back.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(back);

        setSize(1000, 1000);
        setTitle("");
        setLocation(50, 50);
        setVisible(true);
       // setUndecorated(true);
        setLayout(null);
        setTitle("Withdrawal Screen");
         
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == deposit){
            
            String withdrawAmount = amount.getText();
            Date date = new Date();

            if(withdrawAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw ");
            }
            else{
                
                try{
                        Conn c = new Conn();
                        ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                        int balance = 0 ;
        
                        while(rs.next()){
                            if(rs.getString("type").equals("Deposit")){
                                balance =balance +  Integer.parseInt(rs.getString("amount"));
                            }
                            else{
                                balance = balance - Integer.parseInt(rs.getString("amount"));
                            }
                        }
                        if(ae.getSource() != back && balance < Integer.parseInt(withdrawAmount)){
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                            return;
                        };

                    
                    String query = "Insert into bank values('"+pinNumber+"', '"+date+"','Withdraw', '"+withdrawAmount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + withdrawAmount + " is withdrawn successfully" );
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);

                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if (ae.getSource()== back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        try{

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Withdrawal("");
    }
    
}
