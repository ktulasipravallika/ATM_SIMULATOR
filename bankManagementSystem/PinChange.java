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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {

    String pinNumber;
    JPasswordField pinField, re_pinField;
    JButton back, change;

    PinChange(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1000, 1000);
        add(image);

        JLabel text = new JLabel("Change Your PIN ");
        text.setBounds(290, 230, 700,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Time New Roman", Font.PLAIN , 18));
        image.add(text);

        JLabel pinText = new JLabel("New Pin");
        pinText.setBounds(250, 290, 200,25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Time New Roman", Font.PLAIN , 15));
        image.add(pinText);

        pinField = new JPasswordField();
        pinField.setBounds(400, 290, 100,25);
        pinField.setFont(new Font("Time New Roman", Font.BOLD , 15));
        image.add(pinField);

        JLabel newpin = new JLabel("Re-enter PIN");
        newpin.setBounds(250, 320, 500,25);
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("Time New Roman", Font.PLAIN , 15));
        image.add(newpin);

        re_pinField = new JPasswordField();
        re_pinField.setBounds(400, 320, 100,25);
        re_pinField.setFont(new Font("Time New Roman", Font.BOLD , 15));
        image.add(re_pinField);

        change = new JButton("Change");
        change.setBounds(380, 425, 180,30);
        change.addActionListener(this);
        change.setFont(new Font("Times New Roman" , Font.PLAIN , 18));
        image.add(change);

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
        setTitle("Pin Change Screen");

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String pin = pinField.getText();
                String repin = re_pinField.getText();

                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Pin Number should not be empty");
                    return;

                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Pin Number should not be empty");
                    return;
                }
                if(!pin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                Conn c = new Conn();
                String query = "Update bank set pin = '"+repin+"' where pin = '"+pinNumber+"'";
                String query1 = "Update login set pin_number = '"+repin+"' where pin_number = '"+pinNumber+"'";
                String query2 = "Update signup3 set pin_number = '"+repin+"' where pin_number = '"+pinNumber+"'";
    
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "PIN changed Successfully ");
                setVisible(false);
                new Transactions(repin).setVisible(true);
              
            }
            catch(Exception e){
                System.out.println(e);
            } 
        }

        else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);;
        }
        

    }

    public static void main(String[] args) {
        new PinChange("");
    }
    
}
