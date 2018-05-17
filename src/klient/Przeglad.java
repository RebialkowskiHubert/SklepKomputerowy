package klient;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dane.Produkty;
import logowanie.Baza;
import logowanie.Login;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Przeglad extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	JFrame fr=new JFrame();
	
	JTable tab;
	JScrollPane jsp;
	static DefaultTableModel dm = new DefaultTableModel();
	
	JButton btnDodaj = new JButton("Kup");
	JButton btnUsu = new JButton("Anuluj");	
	JButton btnKup = new JButton("Kup");
	JButton btnAnuluj = new JButton("Anuluj");
	
	JRadioButton rdbtnPaczkaPocztowa = new JRadioButton("Paczka pocztowa");
	JRadioButton rdbtnWysykaKurierska = new JRadioButton("Wysyłka kurierska");
	
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	
	public Przeglad() {
		setTitle("Nasz asortyment");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(655, 0, 36, 573);
		contentPane.add(separator);
		
		JLabel lblListaProduktwDostpnych = new JLabel("Lista produkt\u00F3w dost\u0119pnych na magazynie:");
		lblListaProduktwDostpnych.setBounds(10, 11, 444, 14);
		contentPane.add(lblListaProduktwDostpnych);
		
		tab=new JTable();
	    String tytul[] = new String[] { "ID Produktu", "Nazwa produktu", "ID Kategorii", "Cena jednostkowa", "Ilość na magazynie"};
	    dm.setColumnIdentifiers(tytul);
	    tab.setModel(dm);
	    
	    jsp=new JScrollPane(tab);
		jsp.setBounds(10, 36, 635, 515);
		contentPane.add(jsp);
		
		
		btnDodaj.addActionListener(this);
		btnDodaj.setBounds(670, 50, 89, 23);
		contentPane.add(btnDodaj);
		
		
		btnUsu.addActionListener(this);
		btnUsu.setBounds(670, 84, 89, 23);
		contentPane.add(btnUsu);
		
		wczytaj();
	}
	
	public static void wczytaj()
	{
		Baza b=new Baza();
		b.wczytprod("SELECT * FROM produkty");
		for(int i=0; i<Produkty.listaprod.size(); i++)
		{
			if(dm.getRowCount()!=0)
				dm.removeRow(0);
		}
		for(int i=0; i<Produkty.listaprod.size(); i++)
		{
			Vector<Object> v = new Vector<Object>();
			        
			Produkty p=Produkty.listaprod.get(i);
			int IDProd=p.getIDProd();
			String nazwa=p.getNazwa();
			int IDKat=p.getIDKat();
			double cena=p.getCena();
			int ilosc=p.getIlosc();      
			
			v.add(IDProd);
			v.add(nazwa);
			v.add(IDKat);
			v.add(cena);
			v.add(ilosc);
			dm.addRow(v);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnDodaj)
		{
			fr.setVisible(true);
			fr.setBounds(100, 100, 325, 240);
			fr.setLayout(null);
			fr.setTitle("Kup produkt");
			
			JLabel lblIdProduktu = new JLabel("ID Produktu:");
			lblIdProduktu.setBounds(10, 14, 118, 14);
			fr.add(lblIdProduktu);
			
			
			textField1.setBounds(138, 11, 145, 20);
			fr.add(textField1);
			textField1.setColumns(10);
			
			JLabel lblIlo = new JLabel("Ilość:");
			lblIlo.setBounds(10, 57, 100, 14);
			fr.add(lblIlo);
			
			
			textField2.setColumns(10);
			textField2.setBounds(138, 54, 145, 20);
			fr.add(textField2);
			
			
			btnKup.setBounds(10, 157, 91, 23);
			fr.add(btnKup);
			btnKup.addActionListener(this);
			
			
			btnAnuluj.setBounds(205, 157, 91, 23);
			fr.add(btnAnuluj);
			btnAnuluj.addActionListener(this);
			
			JLabel lblSposbWysyki = new JLabel("Sposób wysyłki:");
			lblSposbWysyki.setBounds(10, 106, 120, 14);
			fr.add(lblSposbWysyki);
			
			
			rdbtnPaczkaPocztowa.setBounds(138, 91, 165, 23);
			fr.add(rdbtnPaczkaPocztowa);
			
			
			rdbtnWysykaKurierska.setBounds(138, 116, 183, 23);
			fr.add(rdbtnWysykaKurierska);
		}
		
		if(e.getSource()==btnUsu)
		{
			OknoPowitalne op=new OknoPowitalne();
			op.setVisible(true);
			this.dispose();
		}
		
		if(e.getSource()==btnKup)
		{
			Baza b=new Baza();
			b.sprid("SELECT ID_Zamowienia FROM zamowienia WHERE ID_Zamowienia IN(SELECT MAX(ID_Zamowienia) FROM zamowienia)", 1);
			int IDZam=b.trzeci;
			IDZam++;
			
			b.sprid("SELECT ID_Uzytkownika FROM uzytkownicy WHERE Adres_email='"+Login.email+"'", 1);
			int IDUz=b.trzeci;
			
			int IDProd=Integer.parseInt(textField1.getText());
			
			int ilosc=Integer.parseInt(textField2.getText());
			
			Date datazam=new Date();
			
			double cenadost=0;
			if(rdbtnPaczkaPocztowa.isSelected())
				cenadost=8.50;
			if(rdbtnWysykaKurierska.isSelected())
				cenadost=12.50;
			
			b.sprid("SELECT Cena_Produktu FROM produkty WHERE ID_Produktu='"+IDProd+"'", 1);
			double cenaprod=b.trzeci*ilosc;
			double cenaproddost=cenaprod+cenadost;
			double rabat=0;
			
			b.zakup(IDZam, IDUz, IDProd, ilosc, datazam, datazam, cenadost, cenaproddost, 0, cenaproddost-rabat);
			
			b.wczytprod("SELECT * FROM produkty WHERE ID_Produktu='"+IDProd+"'");
			Produkty p=Produkty.listaprod.get(0);
			String nazwa=p.getNazwa();
			int IDKat=p.getIDKat();
			double cena=p.getCena();
			int iloscnamag=p.getIlosc()-ilosc;
			b.aktualizujprod(IDProd, nazwa, IDKat, cena, iloscnamag);
			
			JOptionPane.showMessageDialog(null, "Twoje zamówienie zostało złożone. Dziękujemy za zakupy w naszym sklepie.");
			fr.dispose();
			this.setVisible(true);
		}
		
		if(e.getSource()==btnAnuluj)
		{
			fr.dispose();
			this.setVisible(true);
		}
	}
}
