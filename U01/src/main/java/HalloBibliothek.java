/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei HalloBibliothek.java
 *
 * HalloBibliothek-Klasse implementiert eine Anwendung, die die Aufnahme von
 * Ausleihe von Büchern simuliert
 */

package U01;

public class HalloBibliothek {

   // Simulation durch main()
   public static void main(String[] args) {

   // Erzeugung eines Bibliothek-Objektes

   Bibliothek bibo = new Bibliothek();

   // Erzeugung von zwei Buch-Objekten
   //
   Buch bibel = new Buch("Bibel");
   Buch comic = new Buch("Asterix und Obelix");

   // Nachricht an die Bibliothek, dass die Buecher aufgenommen werden sollen
   bibo.aufnehmen(bibel);
   bibo.aufnehmen(comic);

   /* Ausgabe:
    * Hallo, ich bin eine Bibliothek,die 10 Buecher aufnehmen kann!
    * Ich habe das Buch Bibel aufgenommen!
    * Ich habe das Buch Asterix und Obelix aufgenommen!
    */

   }
}
