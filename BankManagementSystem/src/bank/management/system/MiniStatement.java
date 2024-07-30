package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

	String pinno ;
	
	public MiniStatement(String pinno) {
		this.pinno = pinno ;
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel text = new JLabel();
		add(text);
		
		JLabel bank = new JLabel("Axis Bank");
		bank.setBounds(150, 20, 100, 20);
		add(bank);
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 100, 400, 200);
		add(mini);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinno+"'");
			while (rs.next()) {
				card.setText("Card Number : " +rs.getString("CardNumber").substring(0,4) + "XXXXXXXX" +rs.getString("CardNumber").substring(12));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn c = new Conn();
			int bal = 0 ;
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
			while (rs.next()) {
				
				mini.setText(mini.getText() + "<html>" +rs.getString("Day_Date_Time") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("Amount")+"<br>");
				if (rs.getString("Type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("Amount"));
				}
				else
				{
					bal -= Integer.parseInt(rs.getString("Amount"));
				}
			}
			balance.setText("Your available balance is : " +bal);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		setSize(350,450);
		setLocation(300,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
public static void main(String[] args) {
		new MiniStatement("");
	}
}
