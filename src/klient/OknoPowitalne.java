package klient;

import java.awt.event.*;
import javax.swing.JFrame;
import logowanie.Login;
import javax.swing.JButton;

public class OknoPowitalne extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	JButton btnNewButton = new JButton("Podgląd produktów");
	JButton btnNewButton_1 = new JButton("Modyfikacja danych");
	JButton btnNewButton_2 = new JButton("Wyloguj");
	
	public OknoPowitalne() {
		setTitle("Witamy w naszym sklepie!");
		setSize(300, 150);
		this.setLayout(null);
		
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(42, 5, 200, 23);
		
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(42, 44, 200, 23);
		
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(42, 80, 200, 23);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnNewButton)
		{
			Przeglad p=new Przeglad();
			p.setVisible(true);
			this.dispose();
		}
		
		if(e.getSource()==btnNewButton_1)
		{
			Modyfikacja m=new Modyfikacja();
			m.setVisible(true);
			this.dispose();
		}
		
		if(e.getSource()==btnNewButton_2)
		{
			Login l=new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}
