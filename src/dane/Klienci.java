package dane;

import java.util.*;

public class Klienci
{
	int ID;
	public String imie;
	String nazwisko;
	String haslo;
	String miejscowosc;
	String kod;
	String ulica;
	String nrdomu;
	String nrlokalu;
	String nrtelefonu;
	String email;
	
	public static int lp=1;
	
	public static List<Klienci> listaklient=new ArrayList<Klienci>();
	
	public Klienci(){}
	
	public Klienci(int ID, String imie, String nazwisko, String haslo, String miejscowosc, String kod, String ulica, String nrdomu, String nrlokalu, String nrtelefonu, String email)
	{
		this.ID=ID;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.haslo=haslo;
		this.miejscowosc=miejscowosc;
		this.kod=kod;
		this.ulica=ulica;
		this.nrdomu=nrdomu;
		this.nrlokalu=nrlokalu;
		this.nrtelefonu=nrtelefonu;
		this.email=email;
	}
	
	public String toString(){return imie;}
	
	public int getID(){return ID;}
	public String getImie(){return imie;}
	public String getNazwisko(){return nazwisko;}
	public String getHaslo(){return haslo;}
	public String getMiejscowosc(){return miejscowosc;}
	public String getKod(){return kod;}
	public String getUlica(){return ulica;}
	public String getNrdomu(){return nrdomu;}
	public String getNrlokalu(){return nrlokalu;}
	public String getNrtelefonu(){return nrtelefonu;}
	public String getEmail(){return email;}
}
