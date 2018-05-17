package administrator;

import java.awt.event.*;
import javax.swing.JFrame;

import logowanie.Login;

import javax.swing.JButton;

public class OknoWybor extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	JButton btnNewButton = new JButton("Zarządzanie produktami");
	JButton btnNewButton_1 = new JButton("Zarządzanie klientami");
	JButton btnNewButton_2 = new JButton("Wyloguj");
	JButton btnPokaZamwienia = new JButton("Pokaż zamówienia");
	


	
	public OknoWybor() {
		setTitle("Panel administratora");
		setSize(300, 190);
		getContentPane().setLayout(null);
		btnNewButton.setBounds(31, 5, 215, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1.setBounds(31, 46, 215, 23);
		btnNewButton_1.addActionListener(this);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2.setBounds(31, 125, 215, 23);
		btnNewButton_2.addActionListener(this);
		getContentPane().add(btnNewButton_2);
		
		btnPokaZamwienia.setBounds(31, 91, 215, 23);
		getContentPane().add(btnPokaZamwienia);
		btnPokaZamwienia.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnNewButton)
		{
			Produkt p=new Produkt();
			p.setVisible(true);
		}
		
		if(e.getSource()==btnNewButton_1)
		{
			PodgladKlientow pk=new PodgladKlientow();
			pk.setVisible(true);
		}
		
		if(e.getSource()==btnPokaZamwienia)
		{
			ZarzZamowienia zz=new ZarzZamowienia();
			zz.setVisible(true);
			this.dispose();
		}
		
		if(e.getSource()==btnNewButton_2)
		{
			this.setVisible(false);
			Login l=new Login();
			l.setVisible(true);
		}
	}
}
