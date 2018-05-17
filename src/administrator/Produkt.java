package administrator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dane.Produkty;
import logowanie.Baza;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Produkt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	JTable tab;
	JScrollPane jsp;
	static DefaultTableModel dm = new DefaultTableModel();
	
	public static int index;
	

	/**
	 * Create the frame.
	 */
	public Produkt() {
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
		
		JLabel lblListaProduktwDostpnych = new JLabel("Lista produktów dostêpnych na magazynie:");
		lblListaProduktwDostpnych.setBounds(10, 11, 444, 14);
		contentPane.add(lblListaProduktwDostpnych);
		
		tab=new JTable();
	    String tytul[] = new String[] { "ID Produktu", "Nazwa produktu", "ID Kategorii", "Cena jednostkowa", "Iloœæ na magazynie"};
	    dm.setColumnIdentifiers(tytul);
	    tab.setModel(dm);
	    
	    jsp=new JScrollPane(tab);
		jsp.setBounds(10, 36, 635, 515);
		contentPane.add(jsp);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DodawanieProduktu dp=new DodawanieProduktu();
				dp.setVisible(true);
			}
		});
		btnDodaj.setBounds(670, 50, 109, 23);
		contentPane.add(btnDodaj);
		
		JButton btnUsu = new JButton("Usuñ");
		btnUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Baza b=new Baza();
				String sindex=JOptionPane.showInputDialog("WprowadŸ numer indeksu produktu, który chcesz usun¹æ:");
				if(sindex.matches("^[0-9]+$"))
					index=Integer.parseInt(sindex);
				try {
					b.usunprod();
					wczytaj();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnUsu.setBounds(670, 84, 109, 23);
		contentPane.add(btnUsu);
		
		JButton btnAktualizuj = new JButton("Aktualizuj");
		btnAktualizuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AktualizacjaProduktu ap=new AktualizacjaProduktu();
				ap.setVisible(true);
			}
		});
		btnAktualizuj.setBounds(670, 118, 109, 23);
		contentPane.add(btnAktualizuj);
		
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
}
