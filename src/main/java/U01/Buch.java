/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei Buch.java
 *
 * Buch-Klasse implementiert ein Buch, welches das Attribute titel hat
 */
package U01;

public class Buch {

    private String titel;

    private boolean verliehen = false;

    public Buch(String titel) {
        this.titel = titel;
    }

    public String toString() {
        return titel;
    }

    public boolean istVerliehen() {
            return verliehen;
    }

    public void ausleihen() {
            verliehen = false;
    }

    public void zurueckbringen() {
            verliehen = true;
    }
}
