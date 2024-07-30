package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.* ;
import java.util.Date ;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
 
	JButton first, second,third, fourth,fifth,sixth,back;
	String pinno ;

	public FastCash(String pinno) {
		this.pinno = pinno ;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label) ;
		
		JLabel text = new JLabel("Select Withdrawal Amount");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(215, 300, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		first = new JButton("RS. 100");
		first.setBounds(170, 415, 150, 30);
		first.addActionListener(this);
		label.add(first);
		
		second = new JButton("RS. 500");
		second.setBounds(355, 415, 150, 30);
		second.addActionListener(this);
		label.add(second);
		
		third = new JButton("RS. 1000");
		third.setBounds(170, 450, 150, 30);
		third.addActionListener(this);
		label.add(third);
		
		fourth = new JButton("RS. 2000");
		fourth.setBounds(355, 450, 150, 30);
		fourth.addActionListener(this);
		label.add(fourth);
		
		
		fifth = new JButton("RS. 5000");
		fifth.setBounds(170, 485, 150, 30);
		fifth.addActionListener(this);
		label.add(fifth);
		
		sixth = new JButton("RS. 10000");
		sixth.setBounds(355, 485, 150, 30);
		sixth.addActionListener(this);
		label.add(sixth);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		label.add(back);
		
		setSize(900,880);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinno).setVisible(true);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(4);
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinno+"'");
				int balance = 0 ;
				while(rs.next())
				{
					if (rs.getString("Type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("Amount"));
					}
					else
					{
						balance -= Integer.parseInt(rs.getString("Amount"));
					}
				}
				
				if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficitent Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinno+"', '"+date+"','Withdrawal' ,'"+amount+"')" ;
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdraw Succesfully");
				
				setVisible(false);
				new Transactions(pinno).setVisible(true);
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new FastCash("");
	}
}
