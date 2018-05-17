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

public class AktualizacjaProduktu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JButton btnDodajProdukt = new JButton("Aktualizuj produkt");
	private JTextField textField_3;
	private JButton btnAnuluj;
	private JTextField textField_4;
	
	public AktualizacjaProduktu() {
		setBounds(100, 100, 360, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Aktualizacja produktu");
		this.setVisible(true);
		
		JLabel lblImi = new JLabel("Nazwa produktu:");
		lblImi.setBounds(10, 48, 161, 14);
		contentPane.add(lblImi);
		
		textField = new JTextField();
		textField.setBounds(181, 42, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("ID Kategorii:");
		lblNazwisko.setBounds(10, 76, 161, 14);
		contentPane.add(lblNazwisko);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 70, 149, 20);
		contentPane.add(textField_1);
		
		JLabel lblHaso = new JLabel("Ilość na magazynie:");
		lblHaso.setBounds(10, 135, 161, 14);
		contentPane.add(lblHaso);
		
		JLabel lblAdresEmail = new JLabel("Cena produktu:");
		lblAdresEmail.setBounds(10, 104, 161, 14);
		contentPane.add(lblAdresEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 98, 149, 20);
		contentPane.add(textField_2);
		
		btnDodajProdukt.setBounds(10, 178, 181, 23);
		contentPane.add(btnDodajProdukt);
		btnDodajProdukt.addActionListener(this);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 132, 149, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);		
		
		btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setBounds(225, 178, 89, 23);
		contentPane.add(btnAnuluj);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(181, 11, 149, 20);
		contentPane.add(textField_4);
		
		JLabel lblIdProduktu = new JLabel("ID Produktu:");
		lblIdProduktu.setBounds(10, 20, 161, 14);
		contentPane.add(lblIdProduktu);
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
			int IDProd=Integer.valueOf(textField_4.getText());
			
			if(nazwa.length()!=0 && IDKat>0 && cena>0 && ilosc>0)
			{
				b.aktualizujprod(IDProd, nazwa, IDKat, cena, ilosc);
				JOptionPane.showMessageDialog(null, "Zaktualizowano pomyślnie");
				Produkt.wczytaj();
				this.setVisible(false);
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