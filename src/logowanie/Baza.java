package logowanie;
import java.sql.*;
import java.util.Date;

import administrator.Produkt;
import dane.Klienci;
import dane.Produkty;
import dane.Zamowienia;

public class Baza
{
	public String pierwszy, drugi;
	public int trzeci;
	Connection conn = null;
	Statement stmt;
	ResultSet rs;
	
	public Baza()
	{		
		String polaczenieURL = "jdbc:mysql://127.0.0.1/sklepkomputerowy?user=root&password=";
		
		try
		{
			conn = DriverManager.getConnection(polaczenieURL);
			Class.forName("com.mysql.jdbc.Driver");
			stmt = conn.createStatement();
		} 
		
		catch(ClassNotFoundException wyjatek)
		{
			System.out.println("Problem ze sterownikiem");
		}

		catch(SQLException wyjatek)
		{
			System.out.println("SQLException: " + wyjatek.getMessage());
		    System.out.println("SQLState: " + wyjatek.getSQLState());
		    System.out.println("VendorError: " + wyjatek.getErrorCode());
		}
		
	}
	
	public void sprlogin(String query, int pierwszy, int drugi)
	{
		try
		{
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				this.pierwszy = rs.getString(pierwszy);
				this.drugi = rs.getString(drugi);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void sprid(String query, int trzeci)
	{
		try
		{
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				this.trzeci = rs.getInt(trzeci);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void rejestracja(int lp, String imie, String nazwisko, String haslo, String miejscowosc, String kod, String ulica, String nrdomu, String nrlokalu, String nrtelefonu, String email)
	{
		try
		{
			PreparedStatement ps=conn.prepareStatement("INSERT INTO uzytkownicy VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1,  lp);
			ps.setString(2, imie);
			ps.setString(3, nazwisko);
			ps.setString(4, haslo);
			ps.setString(5, miejscowosc);
			ps.setString(6, kod);
			ps.setString(7, ulica);
			ps.setString(8, nrdomu);
			ps.setString(9, nrlokalu);
			ps.setString(10, nrtelefonu);
			ps.setString(11, email);
			ps.execute();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	public void dodprod(int IDProd,String nazwa, int IDKat, double cena, int ilosc)
	{
		try
		{
			PreparedStatement ps=conn.prepareStatement("INSERT INTO produkty VALUES(?, ?, ?, ?, ?)");
			ps.setInt(1, IDProd);
			ps.setString(2, nazwa);
			ps.setInt(3, IDKat);
			ps.setDouble(4, cena);
			ps.setInt(5, ilosc);
			ps.execute();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	public void wczytprod(String query)
	{
		try
		{
			Produkty.listaprod.clear();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				int IDProd = rs.getInt(1);
				String nazwa = rs.getString(2);
				int IDKat = rs.getInt(3);
				double cena = rs.getDouble(4);
				int ilosc = rs.getInt(5);
				Produkty.listaprod.add(new Produkty(IDProd, nazwa, IDKat, cena, ilosc));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void usunprod() throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("DELETE FROM produkty WHERE ID_Produktu='"+Produkt.index+"'");
		ps.execute();
	}
	
	public void aktualizujprod(int IDProd, String nazwa, int IDKat, double cena, int ilosc)
	{
		try
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE produkty SET Nazwa_produktu=?, ID_Kategorii=?, Cena_produktu=?, Ilosc_na_magazynie=? WHERE ID_Produktu=?");
			ps.setString(1, nazwa);
			ps.setInt(2, IDKat);
			ps.setDouble(3, cena);
			ps.setInt(4, ilosc);
			ps.setInt(5, IDProd);
			ps.execute();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	public void wczytklienci(String query)
	{
		try
		{
			rs = stmt.executeQuery(query);
			Klienci.listaklient.clear();
			while(rs.next())
			{
				int ID=rs.getInt(1);
				String imie=rs.getString(2);
				String nazwisko=rs.getString(3);
				String haslo=rs.getString(4);
				String miejscowosc=rs.getString(5);
				String kod=rs.getString(6);
				String ulica=rs.getString(7);
				String nrdomu=rs.getString(8);
				String nrlokalu=rs.getString(9);
				String nrtelefonu=rs.getString(10);
				String email=rs.getString(11);
				Klienci.listaklient.add(new Klienci(ID, imie, nazwisko, haslo, miejscowosc, kod, ulica, nrdomu, nrlokalu, nrtelefonu, email));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void usunklient(int index) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("DELETE FROM uzytkownicy WHERE ID_Uzytkownika='"+index+"'");
		ps.execute();
	}
	
	public void zakup(int IDZam, int IDUz, int IDKosz, int ilosc, Date datazam, Date datadost, double cenadost, double cenaproddost, double rabat, double cenaporab)
	{
		try
		{
			PreparedStatement ps=conn.prepareStatement("INSERT INTO zamowienia VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, IDZam);
			ps.setInt(2, IDUz);
			ps.setInt(3, IDKosz);
			ps.setInt(4, ilosc);
			java.sql.Date sqldatazam=new java.sql.Date(datazam.getTime());
			ps.setDate(5, sqldatazam);
			java.sql.Date sqldatadost=new java.sql.Date(datadost.getTime());
			ps.setDate(6, sqldatadost);
			ps.setDouble(7, cenadost);
			ps.setDouble(8, cenaproddost);
			ps.setDouble(9, rabat);
			ps.setDouble(10, cenaporab);
			ps.execute();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	public void modyfikacjaklient(String imie, String nazwisko, String haslo, String miejscowosc, String kod, String ulica, String nrdomu, String nrlokalu, String nrtelefonu, String email, int IDUz)
	{
		try
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE uzytkownicy SET Imie=?, Nazwisko=?, Haslo_dostepu=?, Miejscowosc=?, Kod_pocztowy=?, Ulica=?, Nr_domu=?, Nr_lokalu=?, Nr_telefonu=?, Adres_email=? WHERE ID_Uzytkownika=?");
			ps.setString(1, imie);
			ps.setString(2, nazwisko);
			ps.setString(3, haslo);
			ps.setString(4, miejscowosc);
			ps.setString(5, kod);
			ps.setString(6, ulica);
			ps.setString(7, nrdomu);
			ps.setString(8, nrlokalu);
			ps.setString(9, nrtelefonu);
			ps.setString(10, email);
			ps.setInt(11, IDUz);
			ps.execute();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	public void wczytzamowienie(String query)
	{
		try
		{
			rs = stmt.executeQuery(query);
			Klienci.listaklient.clear();
			while(rs.next())
			{
				int IDZam=rs.getInt(1);
				int IDUz=rs.getInt(2);
				int IDProd=rs.getInt(3);
				int ilosc=rs.getInt(4);
				Date datazam=rs.getDate(5);
				Date datadost=rs.getDate(6);
				double cenadost=rs.getDouble(7);
				double cenaproddost=rs.getDouble(8);
				double rabat=rs.getDouble(9);
				double cenaporab=rs.getDouble(10);
				Zamowienia.listazam.add(new Zamowienia(IDZam, IDUz, IDProd, ilosc, datazam, datadost, cenadost, cenaproddost, rabat, cenaporab));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void usunzam(int index) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("DELETE FROM zamowienia WHERE ID_Zamowienia='"+index+"'");
		ps.execute();
	}
	
	public void zamknij() throws SQLException
	{
		conn.close();
	}
}
