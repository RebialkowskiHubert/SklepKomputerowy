package logowanie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import administrator.OknoWybor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginAdministrator extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	JButton button = new JButton("Zaloguj");
	JButton btnAnuluj = new JButton("Anuluj");
	
	public LoginAdministrator() {
		setTitle("Logowanie do panelu administratora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Logowanie do panelu administratora:");
		label.setBounds(25, 11, 285, 44);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Login:");
		label_1.setBounds(10, 81, 46, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 78, 162, 20);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("Hasło:");
		label_2.setBounds(10, 133, 46, 14);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 130, 162, 20);
		contentPane.add(passwordField);
		
		button.setBounds(178, 187, 89, 20);
		contentPane.add(button);
		button.addActionListener(this);
		
		btnAnuluj.setBounds(10, 185, 91, 23);
		contentPane.add(btnAnuluj);
		btnAnuluj.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button)
		{
			String login=textField.getText();
			char[] hasloz=passwordField.getPassword();
			String haslo=String.valueOf(hasloz);
			String query="Select * FROM administratorzy WHERE Login='"+login+"' AND Haslo='"+haslo+"'";
			Baza b=new Baza();
			b.sprlogin(query, 1, 2);
			if(login.equals(b.pierwszy) && haslo.equals(b.drugi))
			{
				JOptionPane.showMessageDialog(null, "Zalogowano poprawnie");
				OknoWybor ok=new OknoWybor();
				ok.setVisible(true);
				this.dispose();
			}
			
			else
				JOptionPane.showMessageDialog(null, "Błąd logowania. Proszę sprawdzić adres e-mail oraz hasło");
		}
		
		if(e.getSource()==btnAnuluj)
		{
			Login l=new Login();
			l.wybor();
			this.dispose();
		}
	}
}
