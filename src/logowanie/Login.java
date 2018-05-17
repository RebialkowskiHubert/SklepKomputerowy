package logowanie;

import javax.swing.JFrame;

import klient.OknoPowitalne;
import klient.Rejestracja;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JFrame frlog=new JFrame();
	JFrame frwyb=new JFrame();
	
	static String query;
	public static String email;
	JPasswordField passwordField=new JPasswordField();
	JTextField textField_1=new JTextField();
	JPasswordField passwordField_1=new JPasswordField();
	
	JButton button = new JButton("Zaloguj");
	JButton zal=new JButton("Zaloguj się");
	JButton rej=new JButton("Zarejestruj się");
	JButton pod=new JButton("Zobacz produkty");
	
	JButton btnAnuluj = new JButton("Anuluj");
	
	JButton btnNewButton = new JButton("Zaloguj jako klient");
	JButton btnNewButton_1 = new JButton("Zaloguj jako administrator");
	JButton btnAnuluj_1 = new JButton("Anuluj");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		Login fr = new Login();
		fr.setVisible(true);
	}
	
	public Login()
	{
		this.setTitle("Sklep komputerowy online");
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		zal.setBounds(56, 11, 189, 20);
		getContentPane().add(zal);
		zal.addActionListener(this);
		
		rej.setBounds(56, 42, 189, 20);
		getContentPane().add(rej);
		rej.addActionListener(this);
		
		pod.setBounds(56, 73, 189, 20);
		getContentPane().add(pod);
		pod.addActionListener(this);
	}
	
	public void wybor()
	{
		frwyb.setTitle("Logowanie do");
		frwyb.setVisible(true);
		frwyb.getContentPane().setLayout(null);
		frwyb.setSize(300, 180);
		
		btnNewButton.setBounds(23, 24, 240, 23);
		frwyb.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1.setBounds(23, 58, 240, 23);
		frwyb.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnAnuluj_1.setBounds(23, 92, 240, 23);
		frwyb.add(btnAnuluj_1);
		btnAnuluj_1.addActionListener(this);
	}
	
	public void logKlient()
	{
		frlog.setVisible(true);
		frlog.setTitle("Zaloguj się jako klient");
		frlog.setSize(350, 300);
		frlog.setLayout(null);
		
		JLabel lblLogowanieDoPanelu = new JLabel("Logowanie do panelu klienta:");
		lblLogowanieDoPanelu.setBounds(70, 21, 223, 29);
		frlog.add(lblLogowanieDoPanelu);
		
		JLabel lblAdresEmail = new JLabel("Adres e-mail:");
		lblAdresEmail.setBounds(15, 80, 100, 14);
		frlog.add(lblAdresEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 77, 162, 20);
		frlog.add(textField_1);
		
		JLabel label_1 = new JLabel("Hasło:");
		label_1.setBounds(15, 132, 100, 14);
		frlog.add(label_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(134, 129, 162, 20);
		frlog.add(passwordField_1);
		
		button.setBounds(220, 189, 89, 20);
		frlog.add(button);
		button.addActionListener(this);
		
		btnAnuluj.setBounds(25, 187, 91, 23);
		frlog.add(btnAnuluj);
		btnAnuluj.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==button)
		{
			email=textField_1.getText();
			char[] hasloz=passwordField_1.getPassword();
			String haslo=String.valueOf(hasloz);
			query="Select * FROM uzytkownicy WHERE Adres_email='"+email+"' AND Haslo_dostepu='"+haslo+"'";
			Baza b=new Baza();
			b.sprlogin(query, 11, 4);
			if(email.equals(b.pierwszy) && haslo.equals(b.drugi))
			{
				JOptionPane.showMessageDialog(null, "Zalogowano poprawnie");
				OknoPowitalne p=new OknoPowitalne();
				p.setVisible(true);
				frlog.dispose();
			}
			
			else
				JOptionPane.showMessageDialog(null, "Błąd logowania. Proszę sprawdzić adres e-mail oraz hasło");
		}
		
		if(e.getSource()==btnAnuluj)
		{
			wybor();
			frlog.dispose();
		}
		
		if(e.getSource()==zal)
		{
			wybor();
			this.setVisible(false);
		}
		
		if(e.getSource()==rej)
		{
			Rejestracja app=new Rejestracja();
			app.setVisible(true);
			this.setVisible(false);
		}
		
		if(e.getSource()==pod)
		{
			PrzegladGosc pg=new PrzegladGosc();
			pg.setVisible(true);
			this.dispose();
		}
		
		if(e.getSource()==btnNewButton)
		{
			logKlient();
			frwyb.dispose();
		}
		
		if(e.getSource()==btnNewButton_1)
		{
			LoginAdministrator la=new LoginAdministrator();
			la.setVisible(true);
			frwyb.dispose();
		}
		
		if(e.getSource()==btnAnuluj_1)
		{
			this.setVisible(true);
			frwyb.dispose();
		}
	}
}
