import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Collection;

public class Bibliothek {
    private List<Buch> bestand = new ArrayList<Buch>();
    public Bibliothek() {
    }

    public Buch sucheNachISBN(String isbn) {
        int idx = Collections.binarySearch(bestand,new Buch(isbn,"",""));
        if (idx >= 0) {
            return bestand.get(idx);
        } else {
            return null;
        }
    }

    public Collection sucheNachAutor(String autor) {
        Collection<Buch> c = new ArrayList<Buch>();
        for (Buch b: bestand) {
            if (b != null && b.getAutor() == autor) {
                c.add(b);
            }
        }

        return c;
    }

    public boolean sortiertesEinfuegen(Buch b)  {
        int index = Collections.binarySearch(bestand, b);

        if (index < 0) {
            bestand.add(-index-1,b);
            return true;
        }

        return false;
    }
}
