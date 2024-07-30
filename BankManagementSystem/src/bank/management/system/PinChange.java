package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin,repin ;
	JButton change, back ;
	String pinno ;
	
	public PinChange(String pinno) {
		this.pinno = pinno ;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label) ;
		
		JLabel text = new JLabel("Change Your PIN");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250, 280, 500, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		JLabel pintext = new JLabel("New PIN :");
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165, 320, 180, 25);
		pintext.setForeground(Color.WHITE);
		label.add(pintext);
		
		pin = new JPasswordField() ;
		pin.setBounds(330, 320, 180, 25);
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		label.add(pin);
		
		JLabel repintext = new JLabel("Re-Enter New PIN :");
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(165, 360, 180, 25);
		repintext.setForeground(Color.WHITE);
		label.add(repintext);
		
		repin = new JPasswordField() ;
		repin.setBounds(330, 360, 180, 25);
		repin.setFont(new Font("Raleway", Font.BOLD, 22));
		label.add(repin);
		
		change = new JButton("Change");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		label.add(change);
		
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
		else if (ae.getSource() == change) {
			try {
				
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIn does not match");
					return;
				}
				
				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				else if (rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				
				Conn c = new Conn();
				String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinno+"'";
				String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinno+"'";
				String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinno+"'";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				
				setVisible(false);
				new Transactions(pinno).setVisible(true);
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
	}

	public static void main(String[] args) {
		new PinChange("");
	}
}
