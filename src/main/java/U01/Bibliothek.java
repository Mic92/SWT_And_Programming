/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei Bibliothek.java
 *
 * Bibliothek-Klasse implementiert eine Bibliothek, die Bücher aufnehmen kann
 */

package U01;

public class Bibliothek {

   private Buch [] meineBuecher;

   private int anzahl;

   public Bibliothek() {
       meineBuecher = new Buch[10];
       anzahl = 0;
       System.out.println("Hallo, ich bin eine Bibliothek,"
               + "die 10 Buecher aufnehmen kann!");
       }

   public void aufnehmen(Buch buch) {
           meineBuecher[anzahl] = buch;
           anzahl += 1;
           System.out.println("Ich habe das Buch " + buch + " aufgenommen!");
   }

   public boolean suchen(String titel) {
           for (Buch b: meineBuecher) {
                   if (b.toString().equals(titel)) {
                           return true;
                   }
           }
           return false;
   }
}
