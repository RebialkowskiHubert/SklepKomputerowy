package dane;
import java.util.*;

public class Kategorie
{
	int ID;
	String nazwa, opis;
	
	static List<Kategorie> listakat=new ArrayList<Kategorie>();
	
	public Kategorie(int ID, String nazwa, String opis)
	{
		this.ID=ID;
		this.nazwa=nazwa;
		this.opis=opis;
	}
	
	int getID(){return ID;}
	String getNazwa(){return nazwa;}
	String getOpis(){return opis;}
}
