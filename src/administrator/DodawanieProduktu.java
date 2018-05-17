package administrator;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logowanie.Baza;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DodawanieProduktu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JButton btnDodajProdukt = new JButton("Dodaj produkt");
	private JTextField textField_3;
	private JButton btnAnuluj;
	
	public DodawanieProduktu() {
		setBounds(100, 100, 360, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Dodawanie Produktu");
		this.setVisible(true);
		
		JLabel lblImi = new JLabel("Nazwa produktu:");
		lblImi.setBounds(10, 11, 161, 14);
		contentPane.add(lblImi);
		
		textField = new JTextField();
		textField.setBounds(181, 5, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("ID Kategorii:");
		lblNazwisko.setBounds(10, 39, 161, 14);
		contentPane.add(lblNazwisko);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 33, 149, 20);
		contentPane.add(textField_1);
		
		JLabel lblHaso = new JLabel("Ilość na magazynie:");
		lblHaso.setBounds(10, 98, 161, 14);
		contentPane.add(lblHaso);
		
		JLabel lblAdresEmail = new JLabel("Cena produktu:");
		lblAdresEmail.setBounds(10, 67, 161, 14);
		contentPane.add(lblAdresEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 61, 149, 20);
		contentPane.add(textField_2);
		
		btnDodajProdukt.setBounds(10, 150, 145, 23);
		contentPane.add(btnDodajProdukt);
		btnDodajProdukt.addActionListener(this);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 95, 149, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);		
		
		btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setBounds(225, 150, 89, 23);
		contentPane.add(btnAnuluj);
		btnAnuluj.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnDodajProdukt)
		{
			Baza b=new Baza();
			
			String nazwa=textField.getText();
			int IDKat=Integer.valueOf(textField_1.getText());
			double cena=Double.valueOf(textField_2.getText());
			int ilosc=Integer.valueOf(textField_3.getText());
			
			if(nazwa.length()!=0 && IDKat>0 && cena>0 && ilosc>0)
			{
				String query="SELECT * FROM produkty WHERE Nazwa_produktu='"+nazwa+"'";
				b.sprlogin(query, 2, 1);
				if(nazwa.equals(b.pierwszy))
					JOptionPane.showMessageDialog(null, "Produkt już istnieje");
				
				else
				{
					String query2="SELECT ID_Produktu FROM produkty WHERE ID_produktu IN(SELECT MAX(ID_Produktu) FROM produkty)";
					b.sprid(query2, 1);
					b.trzeci++;
					b.dodprod(b.trzeci, nazwa, IDKat, cena, ilosc);
					JOptionPane.showMessageDialog(null, "Dodano pomyślnie");
					Produkt.wczytaj();
					this.setVisible(false);
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Proszę wprowadzić wszystkie pola");
		}
		
		if(e.getSource()==btnAnuluj)
		{
			this.setVisible(false);
		}
	}
}