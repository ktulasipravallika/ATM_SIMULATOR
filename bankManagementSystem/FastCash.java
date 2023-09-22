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

public class FastCash extends JFrame implements ActionListener{

    JButton hundredRs, thousandRs, fiveThRs, fiveHundRs, twoThRs, hunThRs, back;
    String pinNumber;

    FastCash(String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1000, 1000);
        add(image);
            
        JLabel text = new JLabel("Select Withdrawal Amount ");
        text.setBounds(240, 250, 700,18);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Time New Roman", Font.BOLD , 18));
        image.add(text);

        hundredRs = new JButton("Rs. 100");
        hundredRs.setBounds(180, 345, 180,40);
        //deposit.setForeground(Color.WHITE);
        //deposit.setBackground(Color.BLACK);
        hundredRs.addActionListener(this);
        hundredRs.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(hundredRs);

        thousandRs = new JButton("Rs. 1000");
        thousandRs.setBounds(180, 385,180,40);
        thousandRs.addActionListener(this);
        thousandRs.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(thousandRs);

        fiveThRs = new JButton("Rs. 5000");
        fiveThRs.setBounds(180, 425,180,40);
        fiveThRs.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(fiveThRs);

        fiveHundRs = new JButton("Rs. 500");
        fiveHundRs.setBounds(380, 345, 180,40);
        fiveHundRs.addActionListener(this);
        fiveHundRs.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(fiveHundRs);

        twoThRs = new JButton("Rs. 2000");
        twoThRs.setBounds(380, 385, 180,40);
        twoThRs.addActionListener(this);
        twoThRs.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(twoThRs);

        hunThRs = new JButton("Rs. 100000");
        hunThRs.setBounds(380, 425, 180,40);
        hunThRs.addActionListener(this);
        hunThRs.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(hunThRs);

        back = new JButton("Back");
        back.setBounds(380, 465, 180,30);
        back.addActionListener(this);
        back.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(back);

        setSize(1000, 1000);
        setTitle("");
        setLocation(50, 50);
        setVisible(true);
        setUndecorated(true);
        setLayout(null);
        setTitle("Fast Cash Screen");
    }

    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Conn c = new Conn();
            try{
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
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                };

                Date date = new Date();
                String query = "Insert into bank values('"+pinNumber+"', '"+date+"','Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " debited successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        
    }
    public static void main(String[] args) {

        new FastCash("");
        
    }
    
}

    

