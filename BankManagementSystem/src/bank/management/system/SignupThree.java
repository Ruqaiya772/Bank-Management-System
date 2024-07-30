package bank.management.system;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.util. * ;

public class SignupThree extends JFrame implements ActionListener{

	JRadioButton saving, current, fixed, recurring;
	JCheckBox c1, c2, c3, c4, c5, c6, c7 ;
	JButton submit , cancel ;
	String formno;
	
	public SignupThree(String formno) {
		
		this.formno = formno ;
		setLayout(null) ;
		setTitle("New Account Application Form - Page 3");
		
		JLabel l1 = new JLabel("Page 3 : Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type = new JLabel("Account Type :");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100, 110, 200, 30);
		add(type);
		
		saving = new JRadioButton("Savings");
		saving.setBounds(100, 160, 250, 20);
		saving.setBackground(Color.WHITE);
		add(saving);
		
		current = new JRadioButton("Current");
		current.setBounds(350, 160, 250, 20);
		current.setBackground(Color.WHITE);
		add(current);
		
		fixed = new JRadioButton("Fixed Deposit");
		fixed.setBounds(100, 200, 250, 20);
		fixed.setBackground(Color.WHITE);
		add(fixed);
		
		recurring = new JRadioButton("Recurring");
		recurring.setBounds(350, 200, 250, 20);
		recurring.setBackground(Color.WHITE);
		add(recurring);
		
		ButtonGroup acctypegroup = new ButtonGroup();
		acctypegroup.add(saving);
		acctypegroup.add(current);
		acctypegroup.add(fixed);
		acctypegroup.add(recurring);
		
		JLabel cardno = new JLabel("Card Number :");
		cardno.setFont(new Font("Raleway",Font.BOLD,22));
		cardno.setBounds(100, 250, 200, 30);
		add(cardno);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-0007");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330, 250, 350, 30);
		add(number);
		
		JLabel carddetail = new JLabel("Your 16 Digit Card Number");
		carddetail.setFont(new Font("Raleway",Font.BOLD,12));
		carddetail.setBounds(100, 280, 350, 20);
		add(carddetail);
		
		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100, 330, 200, 30);
		add(pin);
		
		JLabel pnumber = new JLabel("****");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(330, 330, 350, 30);
		add(pnumber);
		
		JLabel pindetail = new JLabel("Your 4 Digit PIN");
		pindetail.setFont(new Font("Raleway",Font.BOLD,12));
		pindetail.setBounds(100, 360, 350, 20);
		add(pindetail);
		
		JLabel services = new JLabel("Services required :");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100, 410, 350, 30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("RALEWAY",Font.BOLD, 16));
		c1.setBounds(100, 460, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("RALEWAY",Font.BOLD, 16));
		c2.setBounds(350, 460, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("RALEWAY",Font.BOLD, 16));
		c3.setBounds(100, 510, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("RALEWAY",Font.BOLD, 16));
		c4.setBounds(350, 510, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("RALEWAY",Font.BOLD, 16));
		c5.setBounds(100, 560, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("RALEWAY",Font.BOLD, 16));
		c6.setBounds(350, 560, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that above entered details are correct to the best of my knowledge.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("RALEWAY",Font.BOLD, 12));
		c7.setBounds(100, 640, 600, 30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBounds(250, 700, 100, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("RALEWAY",Font.BOLD, 14));
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(420, 700, 100, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("RALEWAY",Font.BOLD, 14));
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 820);
		setLocation(350, 10);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == submit) {
			
			String accounttype = "null" ;
			if (saving.isSelected()) {
				accounttype = "Savings Account" ;
			}
			else if (current.isSelected()) {
				accounttype = "Current Account" ;
			}
			else if (fixed.isSelected()) {
				accounttype = "Fixed deposit Account" ;
			}
			else if (recurring.isSelected()) {
				accounttype = "Recurring Deposit Account" ;
			}
			
			Random random  = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000l) + 4786305200000000l) ;
			String pinnumber = "" + Math.abs((random.nextLong() % 9000l) +1000l) ;
			
			String facility = "" ;
			if (c1.isSelected()) {
				facility = facility + " ATM Card" ;
			}
			else if (c2.isSelected()) {
				facility = facility + " Internet Banking" ;
			}
			else if (c3.isSelected()) {
				facility = facility + " Mobile Banking" ;
			}
			else if (c4.isSelected()) {
				facility = facility + " Email & SMS Alerts" ;
			}
			else if (c5.isSelected()) {
				facility = facility + " Cheque Book" ;
			}
			else if (c6.isSelected()) {
				facility = facility + " E-Statement" ;
			}
			
			try {
				
				if (accounttype.equals("null")) {
					JOptionPane.showMessageDialog(null, "Select any one AccountType");
				}
				else if (!c1.isSelected() && !c2.isSelected() && !c3.isSelected() && !c4.isSelected() && !c5.isSelected() && !c6.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please select atleast any one of the services");
				}
				else if(!c7.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please select HEREBY DECLARATION checkbox");
				}
				else
				{
					Conn c = new Conn();
					String query1 = "insert into signupthree values('"+formno+"', '"+accounttype+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')" ;
					String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')" ;
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Your Card No. & Pin has generated \n Card Number : "+cardnumber+"\n Pin : "+pinnumber);
					
					setVisible(false);
					new Deposit(pinnumber).setVisible(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
					 
			
		}
		else if (ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args) {
		new SignupThree("") ;
	}
}
