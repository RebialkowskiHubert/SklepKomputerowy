package logowanie;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dane.Produkty;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrzegladGosc extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	JTable tab;
	JScrollPane jsp;
	static DefaultTableModel dm = new DefaultTableModel();
	private JButton btnWstecz;
	
	public PrzegladGosc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaProduktwDostpnych = new JLabel("Lista produktów dostępnych na magazynie:");
		lblListaProduktwDostpnych.setBounds(10, 11, 444, 14);
		contentPane.add(lblListaProduktwDostpnych);
		
		tab=new JTable();
	    String tytul[] = new String[] { "ID Produktu", "Nazwa produktu", "ID Kategorii", "Cena jednostkowa", "Ilość na magazynie"};
	    dm.setColumnIdentifiers(tytul);
	    tab.setModel(dm);
	    
	    jsp=new JScrollPane(tab);
		jsp.setBounds(10, 36, 635, 515);
		contentPane.add(jsp);
		
		btnWstecz = new JButton("Wstecz");
		btnWstecz.addActionListener(this);
		btnWstecz.setBounds(554, 7, 91, 23);
		contentPane.add(btnWstecz);
		
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
	
	public void actionPerformed(ActionEvent e)
	{
		Login l=new Login();
		l.setVisible(true);
		this.setVisible(false);
	}
}
