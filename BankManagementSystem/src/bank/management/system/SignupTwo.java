package bank.management.system;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

	JTextField panTextField ,aadhaarTextField ;
	JComboBox rel, cate, inc, education, occupation1 ;
	JButton next ;
	JRadioButton syes, sno, eyes, eno;
	String formno ;

	public SignupTwo(String formno) {
		
		this.formno = formno ;
		setLayout(null) ;
		setTitle("New Account Application Form - Page 2");
		
		JLabel additionaldetails = new JLabel("Page 2 : Additional Details");
		additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionaldetails.setBounds(280, 80, 400, 30);
		add(additionaldetails);
		
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String [] valuereligion = {"Hindu","Muslim","Christian", "Sikh","Other"};
		rel = new JComboBox(valuereligion);
		rel.setFont(new Font("RALEWAY", Font.BOLD, 14));
		rel.setBounds(300, 140, 400, 30);
		rel.setBackground(Color.WHITE);
		add(rel);
		
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String [] valuecategory = {"General","OBC","SC", "ST","Other"};
		cate = new JComboBox(valuecategory);
		cate.setFont(new Font("RALEWAY", Font.BOLD, 14));
		cate.setBounds(300, 190, 400, 30);
		cate.setBackground(Color.WHITE);
		add(cate);
		
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100, 240, 250, 30);
		add(income);
		
		String [] valueincome = {"Null","< 1,50,000","< 2,50,000", "< 5,00,000","upto 10,00,000"};
		inc = new JComboBox(valueincome);
		inc.setFont(new Font("RALEWAY", Font.BOLD, 14));
		inc.setBounds(300, 240, 400, 30);
		inc.setBackground(Color.WHITE);
		add(inc);
		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway",Font.BOLD,20));
		qualification.setBounds(100, 290, 250, 30);
		add(qualification);
		
		String [] valueeducation = {"Non-Graduation","Graduate","Post Graduation", "Doctorate","Other"};
		education = new JComboBox(valueeducation);
		education.setFont(new Font("RALEWAY", Font.BOLD, 14));
		education.setBounds(300, 290, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
		
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100, 340, 250, 30);
		add(occupation);
		
		String [] valueoccupation = {"Salaried","Self-Employed","Business", "Student","Retired","Other"};
		occupation1 = new JComboBox(valueoccupation);
		occupation1.setFont(new Font("RALEWAY", Font.BOLD, 14));
		occupation1.setBounds(300, 340, 400, 30);
		occupation1.setBackground(Color.WHITE);
		add(occupation1);
		
		JLabel pan = new JLabel("PAN Number :");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100, 390, 250, 30);
		add(pan);
		
		panTextField = new JTextField() ;
		panTextField.setBounds(300, 390, 400, 30);
		panTextField.setFont(new Font("RALEWAY", Font.BOLD, 14));
		add(panTextField);
		
		JLabel aadhaar = new JLabel("Aadhaar Number :");
		aadhaar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhaar.setBounds(100, 440, 250, 30);
		add(aadhaar);
		
		aadhaarTextField = new JTextField() ;
		aadhaarTextField.setBounds(300, 440, 400, 30);
		aadhaarTextField.setFont(new Font("RALEWAY", Font.BOLD, 14));
		add(aadhaarTextField);
		
		JLabel seniorcitizen = new JLabel("Senior Citizen :");
		seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorcitizen.setBounds(100, 490, 250, 30);
		add(seniorcitizen);
		
		syes = new JRadioButton("YES");
		syes.setBounds(300, 490, 70, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("NO");
		sno.setBounds(450, 490, 70, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup sczgroup = new ButtonGroup();
		sczgroup.add(syes);
		sczgroup.add(sno);
		
		
		JLabel existing = new JLabel("Existing Account :");
		existing.setFont(new Font("Raleway",Font.BOLD,20));
		existing.setBounds(100, 540, 250, 30);
		add(existing);
		
		eyes = new JRadioButton("YES");
		eyes.setBounds(300, 540, 70, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("NO");
		eno.setBounds(450, 540, 70, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existgroup = new ButtonGroup();
		existgroup.add(syes);
		existgroup.add(sno);
		
		
		next = new JButton("NEXT");
		next.setBounds(620, 660, 80, 30);
		next.setFont(new Font("RALEWAY", Font.BOLD, 14));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		
        getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800); 
		setVisible(true);
		setLocation(350, 10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String formno = "";
		String sreligion = (String) rel.getSelectedItem();
		String scategory = (String) cate.getSelectedItem();
		String sincome = (String) inc.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation1.getSelectedItem();
		String span = panTextField.getText();
		String saadhaar = aadhaarTextField.getText();
	
		String scz = null ;
		if (syes.isSelected()) {
			scz = "YES";
		}
		else if (sno.isSelected()) {
			scz = "NO" ;
		}
		
		String existing = "null" ;
		if (eyes.isSelected()) {
			existing = "YES";
		}
		else if (eno.isSelected()) {
			existing = "NO" ;
		}
		
		
		try {
			if (span.equals("")) {
				JOptionPane.showMessageDialog(null, "PAN No. is Required");
			}
			else if (saadhaar.equals("")) {
				JOptionPane.showMessageDialog(null, "AAdhaar No. is Required");
			}
			else if (saadhaar.length() != 12) {
				JOptionPane.showMessageDialog(null, "Aadhaar No. must be of 12 digits");
			}
			else if (existing.equals("null")) {
				JOptionPane.showMessageDialog(null, "Existing Account Field is Mandatory");
			}
			else {
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhaar+"', '"+scz+"', '"+existing+"' )";
				c.s.executeUpdate(query); 
			    
				setVisible(false);
				new SignupThree(formno).setVisible(true);
			}
		} 
		catch (Exception e2) {
			System.out.println(e2 );
		}
	}
	

	public static void main(String[] args) {
		
		new SignupTwo("");
	}
}
