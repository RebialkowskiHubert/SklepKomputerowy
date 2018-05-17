package administrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dane.Zamowienia;
import logowanie.Baza;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ZarzZamowienia extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	JTable tab;
	JScrollPane jsp;
	static DefaultTableModel dm = new DefaultTableModel();
	
	JButton btnZrealizujZamwienie = new JButton("Zrealizuj zamówienie");
	JButton btnAnuluj = new JButton("Anuluj");
	
	public ZarzZamowienia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaProduktwDostpnych = new JLabel("Lista produktów dostępnych na magazynie:");
		lblListaProduktwDostpnych.setBounds(10, 11, 444, 14);
		contentPane.add(lblListaProduktwDostpnych);
		
		tab=new JTable();
	    String tytul[] = new String[] { "ID Zamówienia", "ID Uzytkownika", "ID Produktu", "Ilość produktów", "Data zamówienia", "Data dostawy", "Cena dostawy", "Cena dostawy i zamówienia", "Rabat", "Cena po rabacie"};
	    dm.setColumnIdentifiers(tytul);
	    tab.setModel(dm);
	    
	    jsp=new JScrollPane(tab);
		jsp.setBounds(10, 36, 772, 526);
		contentPane.add(jsp);
		
		
		btnZrealizujZamwienie.setBounds(581, 7, 201, 23);
		contentPane.add(btnZrealizujZamwienie);
		btnZrealizujZamwienie.addActionListener(this);
		
		btnAnuluj.setBounds(414, 7, 121, 23);
		btnAnuluj.addActionListener(this);
		contentPane.add(btnAnuluj);
		
		wczytaj();
	}
	
	public static void wczytaj()
	{
		Baza b=new Baza();
		b.wczytzamowienie("SELECT * FROM zamowienia");
		for(int i=0; i<Zamowienia.listazam.size(); i++)
		{
			if(dm.getRowCount()!=0)
				dm.removeRow(0);
		}
		for(int i=0; i<Zamowienia.listazam.size(); i++)
		{
			Vector<Object> v = new Vector<Object>();
			        
			Zamowienia z=Zamowienia.listazam.get(i);
			int IDZam=z.getIDZam();
			int IDUz=z.getIDUz();
			int IDProd=z.getIDProd();
			int ilosc=z.getIlosc();
			double cenadost=z.getCenadost();
			double cenaproddost=z.getCenaproddost();
			double rabat=z.getRabat();
			double cenaporab=z.getCenaporab();
			Date datazam=z.getDatazam();
			Date datadost=z.getDatadost();
			
			v.add(IDZam);
			v.add(IDUz);
			v.add(IDProd);
			v.add(ilosc);
			v.add(datazam);
			v.add(datadost);
			v.add(cenadost);
			v.add(cenaproddost);
			v.add(rabat);
			v.add(cenaporab);			
			dm.addRow(v);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnZrealizujZamwienie)
		{
			String sindex=JOptionPane.showInputDialog("Wprowadź numer indeksu zamówienia, które już zrealizowałeś:");
			if(sindex.matches("^[0-9]+$"))
			{
				int index=Integer.parseInt(sindex);
				Baza b=new Baza();
				try {
					b.usunzam(index);
					JOptionPane.showMessageDialog(null, "Zamówienie zostało zaznaczone jako zrealizowane.");
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Numer indeksu jest liczbą");
		}
		
		if(e.getSource()==btnAnuluj)
		{
			OknoWybor ok=new OknoWybor();
			ok.setVisible(true);
			this.dispose();
		}
	}
}
