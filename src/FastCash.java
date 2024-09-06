import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit, withdrawal,ministatement,pinchange, fastcash, balanceEnquiry,exit;
    String pinnumber;
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.addActionListener(this);
        deposit.setBounds(170,415,150,30);
        image.add(deposit);

        withdrawal = new JButton("Rs 200");
        withdrawal.addActionListener(this);
        withdrawal.setBounds(355,415,150,30);
        image.add(withdrawal);

        fastcash = new JButton("Rs 500");
        fastcash.addActionListener(this);
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.addActionListener(this);
        ministatement.setBounds(355,450,150,30);
        image.add(ministatement);

        pinchange= new JButton("Rs 5000");
        pinchange.addActionListener(this);
        pinchange.setBounds(355,485,150,30);
        image.add(pinchange);

        balanceEnquiry= new JButton("Rs 10000");
        balanceEnquiry.addActionListener(this);
        balanceEnquiry.setBounds(170,485,150,30);
        image.add(balanceEnquiry);

        exit= new JButton("Back");
        exit.addActionListener(this);
        exit.setBounds(355,520,150,30);
        image.add(exit);






        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
             String amount = ((JButton)ae.getSource()).getText().substring(3);// remove rs from 500
             Conn c = new Conn();
             try{
                 ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                 int balance = 0;
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposit")){
                         balance += Integer.parseInt(rs.getString("amount"));
                     }else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }
                 }
                 if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null, "Insufficient Balance");
                     return;
                 }
                 Date date = new Date();
                 String query = "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawal','"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);

             }catch (Exception e){
                 System.out.println(e);
             }
        }
    }


        public static void main (String[]args){
            new FastCash("");
        }
    }
