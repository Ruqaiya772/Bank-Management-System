package bank.management.system;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, clear, create ;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	public Login() {
		setTitle("Automated Trailor Machine");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(120, 10, 100, 100);
		add(label) ;
		
		JLabel text = new JLabel("Welcome To ATM");
		text.setFont(new Font("OSWARD",Font.BOLD,38));
		text.setBounds(250, 40, 400, 40);
		add(text);
		
		JLabel cardno = new JLabel("CARD NO :");
		cardno.setFont(new Font("RAILWAY",Font.BOLD,28));
		cardno.setBounds(120, 150, 150, 40);
		add(cardno);
		
		cardTextField = new JTextField() ;
		cardTextField.setBounds(300, 150, 300, 40);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("RALEWAY",Font.BOLD,28));
		pin.setBounds(120, 220, 400, 40);
		add(pin);
		
		pinTextField = new JPasswordField() ;
		pinTextField.setBounds(300, 220, 300, 40);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(325, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR ");
		clear.setBounds(475, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
	    create = new JButton("SIGN UP ");
		create.setBounds(370, 350, 150, 30);
		create.setBackground(Color.BLACK);
		create.setForeground(Color.WHITE);
		create.addActionListener(this);
		add(create);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,500); 
		setVisible(true);
		setLocation(350, 180);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			
			Conn c = new Conn();
			String cardno = cardTextField.getText();
			String pinno = pinTextField.getText(); 
			String query = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pinno+"'";
			try {
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transactions(pinno).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin!!");
				}
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		else if (e.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
			
		}
		else if (e.getSource() == create) {
			
			setVisible(false);
			
			new SignupOne().setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		
		new Login() ;
	}
}
