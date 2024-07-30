package bank.management.system;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{

	JButton back ;
	String pinno ;
	
	public BalanceEnquiry(String pinno) {
		this.pinno = pinno ;
       setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label) ;
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		label.add(back);
		
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
			
			JLabel text = new JLabel("Your remaining balance is : "+balance);
			text.setFont(new Font("System",Font.BOLD,16));
			text.setBounds(200, 350, 500, 35);
			text.setForeground(Color.WHITE);
			label.add(text);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		setSize(900,900);
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
	}
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}
