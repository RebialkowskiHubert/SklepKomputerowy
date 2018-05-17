package dane;

import java.util.*;

public class Produkty
{
	int IDProd, IDKat, ilosc;
	public String nazwa;
	double cena;
	
	public static List<Produkty> listaprod=new ArrayList<Produkty>();
	
	public Produkty(int IDProd, String nazwa, int IDKat, double cena, int ilosc)
	{
		this.IDProd=IDProd;
		this.nazwa=nazwa;
		this.IDKat=IDKat;
		this.cena=cena;
		this.ilosc=ilosc;
	}
	
	public int getIDProd(){return IDProd;}
	public int getIDKat(){return IDKat;}
	public int getIlosc(){return ilosc;}
	public String getNazwa(){return nazwa;}
	public double getCena(){return cena;}
	
	public String toString(){return (IDProd+" "+nazwa+" "+IDKat+" "+cena+" "+ilosc);}
}
