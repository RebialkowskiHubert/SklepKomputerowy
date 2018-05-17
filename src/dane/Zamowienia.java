package dane;
import java.util.*;

public class Zamowienia
{
	int IDZam, IDUz, IDProd, ilosc;
	double cenadost, cenaproddost, rabat, cenaporab;
	Date datazam, datadost;
	
	public static List<Zamowienia> listazam=new ArrayList<Zamowienia>();
	
	public Zamowienia(int IDZam, int IDUz, int IDProd, int ilosc, Date datazam, Date datadost, double cenadost, double cenaproddost, double rabat, double cenaporab)
	{
		this.IDZam=IDZam;
		this.IDUz=IDUz;
		this.IDProd=IDProd;
		this.ilosc=ilosc;
		this.datazam=datazam;
		this.datadost=datadost;
		this.cenadost=cenadost;
		this.cenaproddost=cenaproddost;
		this.rabat=rabat;
		this.cenaporab=cenaporab;
	}
	
	public int getIDZam(){return IDZam;}
	public int getIDUz(){return IDUz;}
	public int getIDProd(){return IDProd;}
	public int getIlosc(){return ilosc;}
	public double getCenadost(){return cenadost;}
	public double getCenaproddost(){return cenaproddost;}
	public double getRabat(){return rabat;}
	public double getCenaporab(){return cenaporab;}
	public Date getDatazam(){return datazam;}
	public Date getDatadost(){return datadost;}
}
