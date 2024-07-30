package bank.management.system;
import java.awt.*;
import java.awt.event.* ;
import javax.swing.* ;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdrawal,fastcash, statement,balanceenquiry,pin,exit;
	String pinno ;

	public Transactions(String pinno) {
		this.pinno = pinno ;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label) ;
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(215, 300, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		deposit = new JButton("Cash Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		label.add(deposit);
		
		withdrawal = new JButton("Cash Withdrawal");
		withdrawal.setBounds(355, 415, 150, 30);
  		withdrawal.addActionListener(this);
		label.add(withdrawal);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		label.add(fastcash);
		
		statement = new JButton("Mini Statement");
		statement.setBounds(355, 450, 150, 30);
		statement.addActionListener(this);
		label.add(statement);
		
		
		pin = new JButton("PIN Change");
		pin.setBounds(170, 485, 150, 30);
		pin.addActionListener(this);
		label.add(pin);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		label.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		label.add(exit);
		
		setSize(900,880);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == exit) {
			System.exit(0);
		}
		else if (ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinno).setVisible(true);
		}
		else if (ae.getSource() == withdrawal) {
			setVisible(false);
			new Withdrawal(pinno).setVisible(true);
		}
		else if (ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinno).setVisible(true);
		}
		else if (ae.getSource() == pin) {
			setVisible(false);
			new PinChange(pinno).setVisible(true);
		}
		else if (ae.getSource() == balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinno).setVisible(true);
		}
		else if (ae.getSource() == statement) {
			
			new MiniStatement(pinno).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Transactions("");
	}
}
