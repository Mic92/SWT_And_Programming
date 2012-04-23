import junit.framework.TestCase;

/**
 * Test of the Task Classes and Objects (Taxi)
 * 
 * Lehrstuhl Softwaretechnik
 *
 */
public class TaxiJUnitTest extends TestCase
{

	/** 
	 * Tests the Human Class with the Methods, Tests of Task 1 and Task 2
	 * o getName
	 * o getForename
	 * o toString 
	 */
    public void testHumans()
    {

        Human f1 = new Human("Peter", "Mayer");

        assertEquals("Mayer", f1.getName());
        assertEquals("Peter", f1.getForename());
        
        assertTrue("Die Methode toString muss 'Peter Mayer' zurueckliefern!", f1.toString().equals("Peter Mayer"));
    }
    
    /**
     * Tests the following methods
     * o add : Assigment of the Driver
     * o getDriverName : Name of the Driver
     */
    public void testTaxiDriverAssigned()
    {
    	Human m = new Human("Juergen","Staub");
    	
    	Taxi taxi = new Taxi(m);

        // Added this test to avoid the error returning Human instead of String here
        assertEquals("Die Methode getDriverName() der Klasse Taxi sollte den Namen des Fahrers als String liefern!", String.class, taxi.getDriverName().getClass());
    	
    	assertEquals("Juergen Staub", taxi.getDriverName());
    	
    }
    
    /**
     * Tests the toString method of the Taxi
     * o toString 
     */
    public void testTaxiAddPassengers()
    {
    	Human driver = new Human("Juergen","Staub");
        Human m1 = new Human("Andrea", "Bora");
        Human m2 = new Human("Franzi","Ada");
        Human m3 = new Human("Leah","Posh");
        Human m4 = new Human("Susi","Fresh");
        Human m5 = new Human("Lucky","Fuke");

        Taxi duck = new Taxi(driver);

        System.out.println(duck.toString());
        assertTrue("Die Methode toString muss bei 0 Passagieren folgendes zurueckgeben: 'This is the taxi of Juergen Staub. He takes nobody along.' es gibt '"+duck.toString()+"' zurueck ", duck.toString().equals("This is the taxi of Juergen Staub. He takes nobody along."));
        duck.add(m1);
        System.out.println(duck.toString());
        assertTrue("Die Methode toString muss bei 1 Passagier folgendes zurueckgeben: 'This is the taxi of Juergen Staub. He takes Andrea Bora along.' es gibt '"+duck.toString()+"' zurueck ", duck.toString().equals("This is the taxi of Juergen Staub. He takes Andrea Bora along."));
        duck.add(m2);
        System.out.println(duck.toString());
        assertTrue("Die Methode toString muss bei 2 Passagieren folgendes zurueckgeben: 'This is the taxi of Juergen Staub. He takes Andrea Bora and Franzi Ada along.' es gibt '"+duck.toString()+"' zurueck ", duck.toString().equals("This is the taxi of Juergen Staub. He takes Andrea Bora and Franzi Ada along."));
        duck.add(m3);
        System.out.println(duck.toString());
        assertTrue("Die Methode toString muss bei 3 Passagieren folgendes zurueckgeben: 'This is the taxi of Juergen Staub. He takes Andrea Bora, Franzi Ada and Leah Posh along.' es gibt '"+duck.toString()+"' zurueck ", duck.toString().equals("This is the taxi of Juergen Staub. He takes Andrea Bora, Franzi Ada and Leah Posh along."));
        duck.add(m4);
        System.out.println(duck.toString());
        assertTrue("Die Methode toString muss bei 4 Passagieren folgendes zurueckgeben: 'This is the taxi of Juergen Staub. He takes Andrea Bora, Franzi Ada, Leah Posh and Susi Fresh along.' es gibt '"+duck.toString()+"' zurueck ", duck.toString().equals("This is the taxi of Juergen Staub. He takes Andrea Bora, Franzi Ada, Leah Posh and Susi Fresh along."));
        duck.add(m5);
        assertTrue("Es sollte nicht moeglich sein mehr als 4 Passagiere aufzunehmen!", duck.allGetOut().length <= 4);

    }
    
    /**
     * Tests the allGetOut method of the Taxi
     * o allGetOut 
     */
    public void testTaxiGetAllOut()
    {
    	Human driver = new Human("Juergen","Staub");
        Human m1 = new Human("Andrea", "Bora");
        Human m2 = new Human("Franzi","Ada");
        Human m3 = new Human("Leah","Posh");
        Human m4 = new Human("Susi","Fresh");
        
        Human[] mitfahrer = new Human[] { m1, m2, m3, m4 };
        Taxi duck2 = new Taxi(driver);
        Human[] dabei = null;
        
        // auf null testen
        if(duck2.allGetOut() == null)
        	fail("Ihre allGetOut Methode gibt null zurueck wenn Passagiere im Taxi sitzen, bitte geben sie die Passagiere zurueck!");
        
        
        duck2.add(m1);
        duck2.add(m2);
        duck2.add(m3);
        duck2.add(m4);
        
        // cast testen
        try  {
        	dabei = (Human[])duck2.allGetOut();
        } catch(Exception e)
        {
        	fail("Es ist nicht moeglich den Rueckgabetyp ihrer allGetOut Methode in den Typ Human[] umzuwandeln!");
        }
        
        // Test ob ueberhaupt 4 Personen zurueckgegeben werden
        if(dabei.length != 4)
        {
            System.out.println("\nAllGetOut:\n------------------------\nAusgabe: " + java.util.Arrays.toString(dabei) + "\nErwartete Ausgabe: " + java.util.Arrays.toString(mitfahrer));
        	fail("Die Ausgabe von allGetOut() ist falsch, es werden nicht die Personen zurueckgegeben!");
        }

        // mitfahrer testen
        try  {
            
            for (int i = 0; i < dabei.length; i++)
            	assertEquals(mitfahrer[i].toString(), dabei[i].toString());      	
        } catch(Exception e)
        {
        	// Exception bei [null, null, null, null]
        	fail("Die Ausgabe von allGetOut() ist falsch, bitte pruefen Sie diese, Ausgabe: " + java.util.Arrays.toString(dabei) + " Erwartete Ausgabe: " + java.util.Arrays.toString(mitfahrer));
        }
        
        // Ausgabe von allGetOut ausgeben
        System.out.println("\nAllGetOut:\n------------------------\nAusgabe: " + java.util.Arrays.toString(dabei) + "\nErwartete Ausgabe: " + java.util.Arrays.toString(mitfahrer));
        
        
        // Sind alle Personen aus dem Taxi heraus?
        assertTrue("Die Methode toString muss nach allGetOut, bei 0 Passagieren folgendes zurueckgeben: 'This is the taxi of Juergen Staub. He takes nobody along.'", duck2.toString().equals("This is the taxi of Juergen Staub. He takes nobody along."));

        // Gibt es Probleme beim hinzufuegen neuer Personen?
        duck2.add(m4);
        assertTrue("Die Methode toString muss bei 1 Passagier folgendes zurueckgeben: 'This is the taxi of Juergen Staub. He takes Susi Fresh along.'", duck2.toString().equals("This is the taxi of Juergen Staub. He takes Susi Fresh along."));
    }

}

