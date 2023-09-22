package bankManagementSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {
    String pinNumber;

    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        int bal = 0;

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(330, 160, 400, 200);
        add(mini);

        JLabel bank = new JLabel("KTP Bank");
        bank.setBounds(450, 60, 200, 20);
        bank.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(370, 150, 600, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(370, 360, 400, 100);
        balance.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(balance);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_number = '"+pinNumber+"'");
            while (rs.next()) {
                card.setText("Card Number : " + rs.getString("cardNumber").substring(0, 4) + "-XXXX-XXXX"
                        + rs.getString("cardNumber").substring(12));

            }
            ResultSet rs2 = c.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");

            while(rs2.next()){
                if (rs2.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs2.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs2.getString("amount"));
                }

            }
            balance.setText("Your current balance is Rs. "+bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")
                        + "<br><br><html>");

            }

        } catch (Exception e) {
            System.out.println(equals(e));
        }

        setSize(700, 700);
        setTitle("Mini Statement Screen");
        setLocation(150, 150);
        setVisible(true);
        // setUndecorated(true);

    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new MiniStatement("");

    }

}
