import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdrawal,ministatement,pinchange, fastcash, balanceEnquiry,exit;
    String pinnumber;
    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(170,415,150,30);
        image.add(deposit);

        withdrawal = new JButton("Cash Wishdrawal");
        withdrawal.addActionListener(this);
        withdrawal.setBounds(355,415,150,30);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.addActionListener(this);
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);

        ministatement = new JButton("Mini statement");
        ministatement.addActionListener(this);
        ministatement.setBounds(355,450,150,30);
        image.add(ministatement);

        pinchange= new JButton("Change Pin");
        pinchange.addActionListener(this);
        pinchange.setBounds(355,485,150,30);
        image.add(pinchange);

        balanceEnquiry= new JButton("Balance Enquiry");
        balanceEnquiry.addActionListener(this);
        balanceEnquiry.setBounds(170,485,150,30);
        image.add(balanceEnquiry);

        exit= new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(355,520,150,30);
        image.add(exit);

        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
              System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource()==balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
         new Transactions("");
    }
}
