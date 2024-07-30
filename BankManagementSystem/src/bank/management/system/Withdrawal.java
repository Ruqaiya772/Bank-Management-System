package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{
	
	JTextField amount ;
	JButton withdrawal,back ;
	String pinno ;
	
	public Withdrawal(String pinno ) {
        this.pinno = pinno ;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label) ;
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(190, 300, 400, 20);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		amount = new JTextField() ;
		amount.setBounds(190, 350, 290, 25);
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		add(amount);
		
		withdrawal = new JButton("Withdraw");
		withdrawal.setBounds(355, 485, 150, 30);
		withdrawal.addActionListener(this);
		label.add(withdrawal);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		label.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	
		if (ae.getSource() == withdrawal) {
			String number = amount.getText();
			Date date = new Date();
			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}
			else {
				try {
					Conn c = new Conn();
					String query = "insert into bank values('"+pinno+"', '"+date+"','Withdrawal' ,'"+number+"')" ;
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdraw Succesfully");
					setVisible(false);
					new Transactions(pinno).setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		else if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinno).setVisible(true);
		}

}
	
	public static void main(String[] args) {
		
		new Withdrawal("");
	}

}