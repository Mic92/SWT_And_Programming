import java.util.HashSet;
import java.util.Set;

public class Baugruppe extends Bauteil {
    private Set<Bauteil> bauteile = new HashSet<Bauteil>();
    public Baugruppe(Bauteil b) { // Aufgabe 1a)
        bauteile.add(b);
    }
    public double preis() {
        int preis = 0;
        for (Bauteil t : bauteile) {
            preis += t.preis();
        }
        return preis;
    }
    public void removeBauteil(Bauteil b) {
        if (bauteile.size() < 2 || b == null) return; // Aufgabe 1a)
        bauteile.remove(b);
    }
    public void addBauteil(Bauteil b) {
        if (b == null) return;    // Aufgabe 1b)
        bauteile.add(b);
    }
    public Set<Bauteil> getBauteile() { // Aufgabe 1b)
        return bauteile;
    }
}
