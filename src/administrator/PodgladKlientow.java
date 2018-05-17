package administrator;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dane.Klienci;
import logowanie.Baza;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class PodgladKlientow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	JTable tab;
	JScrollPane jsp;
	JButton btnUsu = new JButton("Usuń");
	static DefaultTableModel dm = new DefaultTableModel();	

	public PodgladKlientow() {
		setTitle("Podgląd klientów");
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbllistaklientProduktwDostpnych = new JLabel("Lista klientów zarejestrowanych w systemie:");
		lbllistaklientProduktwDostpnych.setBounds(10, 11, 444, 14);
		contentPane.add(lbllistaklientProduktwDostpnych);
		
		tab=new JTable();
	    String tytul[] = new String[] { "ID", "Imię", "Nazwisko", "Hasło", "Miejscowość", "Kod pocztowy", "Ulica", "Numer domu", "Numer lokalu", "Numer telefonu", "Adres e-mail"};
	    dm.setColumnIdentifiers(tytul);
	    tab.setModel(dm);
	    
	    jsp=new JScrollPane(tab);
		jsp.setBounds(10, 36, 988, 637);
		contentPane.add(jsp);
		
		
		btnUsu.addActionListener(this);
		btnUsu.setBounds(10, 684, 89, 23);
		contentPane.add(btnUsu);
		
		wczytaj();
	}
	
	public static void wczytaj()
	{
		Baza b=new Baza();
		b.wczytklienci("SELECT * FROM uzytkownicy");
		for(int i=0; i<Klienci.listaklient.size(); i++)
		{
			if(dm.getRowCount()!=0)
				dm.removeRow(0);
		}
		for(int i=0; i<Klienci.listaklient.size(); i++)
		{
			Vector<Object> v = new Vector<Object>();
			        
			Klienci k=Klienci.listaklient.get(i);
			int ID=k.getID();
			String imie=k.getImie();
			String nazwisko=k.getNazwisko();
			String haslo=k.getHaslo();
			String miejscowosc=k.getMiejscowosc();
			String kod=k.getKod();
			String ulica=k.getUlica();
			String nrdomu=k.getNrdomu();
			String nrlokalu=k.getNrlokalu();
			String nrtelefonu=k.getNrtelefonu();
			String email=k.getEmail();
			
			v.add(ID);
			v.add(imie);
			v.add(nazwisko);
			v.add(haslo);
			v.add(miejscowosc);
			v.add(kod);
			v.add(ulica);
			v.add(nrdomu);
			v.add(nrlokalu);
			v.add(nrtelefonu);
			v.add(email);
			dm.addRow(v);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnUsu)
		{
			String sindex=JOptionPane.showInputDialog("Podaj numer ID lienta, którego chcesz usunąć.");
			if(sindex.matches("^[0-9]+$"))
			{
				int index=Integer.parseInt(sindex);
				if(index>0 && index<=Klienci.listaklient.size())
				{
					Baza b=new Baza();
					try {
						b.usunklient(index);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Numer indeksu jest błędny");
			}
			else
				JOptionPane.showMessageDialog(null, "Indeks jest liczbą");
		}
	}
}
