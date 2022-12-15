import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ObjectPlus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static HashMap<Class<? extends ObjectPlus>, ArrayList<ObjectPlus>> ekstensje = new HashMap<Class<? extends ObjectPlus>, ArrayList<ObjectPlus>>();
	
	public ObjectPlus(){
		ArrayList<ObjectPlus> ekstensja = null;
		Class<? extends ObjectPlus> klasa = this.getClass();
		if(ekstensje.containsKey(klasa))
		{
			ekstensja = ekstensje.get(klasa);
		}
		else
		{
			ekstensja = new ArrayList<ObjectPlus>();
			ekstensje.put(klasa, ekstensja);
		}
		ekstensja.add(this);
	}
	
	public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException
	{
		stream.writeObject(ekstensje);
	}
	
	public static void odczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException
	{
		ekstensje = (HashMap<Class<? extends ObjectPlus>, ArrayList<ObjectPlus>>) stream.readObject();
	}
	
	public static void wyswietlEkstensje(Class<? extends ObjectPlus> klasa) throws Exception
	{
		ArrayList<ObjectPlus> ekstensja = null;
		
		if(ekstensje.containsKey(klasa))
		{
			ekstensja = ekstensje.get(klasa);
		}	
		System.out.println("Ekstensja klasy: " + klasa.getSimpleName());
		
		for(Object x : ekstensja)
		{
			System.out.println(x + "\n");
		}
	}
}


