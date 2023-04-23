package serije;

import java.io.*;

/**
 * 
 * @author emma
 * 
 * Serijalizacija i deserijalizacija
 * 
 *
 */

public class MainDS {

	public static void main(String[] args) {
		// (de)serijalizacija objekta
		
		Pratilac putnik = new Pratilac(1,"jedan");
		System.out.println("Original...");
		System.out.println("a = " + putnik.a);
        System.out.println("b = " + putnik.b);
        System.out.println("c = " + putnik.c);
		
		String filename = "file.ser"; // fajl za čuvanje stanja objekta
        
        // Serialization
        try
        {  
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename); // pristup/kreiranje objekta
            ObjectOutputStream out = new ObjectOutputStream(file); // kreiranje izlaznog toka
             
            // Method for serialization of object
            out.writeObject(putnik); // upis objekta u izlazni tok (indirektno u fajl file.ser
             
            out.close();
            file.close();
             
            System.out.println("Object has been serialized");
 
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
 
 
        Pratilac senka = null; // kreiranje "vakum" objekta
 
        // Deserialization
        try
        {  
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename); // otvaranje fajla file.ser
            ObjectInputStream in = new ObjectInputStream(file); // kreiranje ulaznog toka
             
            // Method for deserialization of object
            senka = (Pratilac) in.readObject(); // "upis" stanja iz fajla
             
            in.close();
            file.close();
             
            System.out.println("Object has been deserialized ");
            // čitanje vrednost, rekonstrukcija objekta
            System.out.println("-----------------------------------");
            System.out.println("Kopija Originala...");
            System.out.println("a = " + senka.a);
            System.out.println("b = " + senka.b);
            System.out.println("c = " + senka.c);
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
 

	}

}

/*
 * Serijalizacija je proces upisivanja stanja objekta u tok bajtova. 
 * Uglavnom se koristi za prenošenje stanja objekta u mreži.
 * 
 * Deserijalizacija je proces rekonstrukcije objekta iz serijalizovanog stanja. 
 * To je obrnuta operacija serijalizacije.
 * 
 * Interfejs Serializable je interfejs markera. 
 * Kada se koristi interfejs koji može da se serializuje, klasa se podrazumevano 
 * automatski serijalizuje. 
 * Mogu da se prepišu dva metoda writeObject() i readObject()
 *  a u cilju kontrolisanja složenijeg procesa serijalizacije objekata. 
 *  
 *  Sve klase omotači i klasa String implementiraju interfejs Serializable.
 *  
 *  - Због чега се ради серијализација и десеријализација објекта? 
 *  čuvanje stanja objekta, korisno kod prenosa podataka kroz mrežu.
 *  
 *  - Које класе омогућују серијализацију и десеријализацију објеката? 
 *  sve klase koje implementiraju interfejs Serializable
 *  od JAVA ugrađenih klasa to su sve klase omotači i klasa String
 *  
 *  - Интерфејс Serializable – објаснити и имплементирати.  
 *  koristi se za omogućavanje serijalizacije objekata
 *  ovo je prazan interfejs označen kao interfejs markera
 *  
 *  - Податак serialVersionID објаснити и имплементирати. 
 *  64b celobrojna (long) konstanta vrednost kojom se identifikuje 
 *  klasa objekta koji se serijalizuje
 *  
 *  - Креирање фајла коришћењем серијализације објекта.
 *  rezultat je binarni fajl .ser tipa, 
 *  ali može biti i .txt tipa (sve dok se čita/upisuje/ažurira kao binarni fajl)
 * 
*/
