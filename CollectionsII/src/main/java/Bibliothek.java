import java.util.*;
import java.util.List;
import java.util.Collection;

public class Bibliothek {
    private Set<Buch> bestand = new TreeSet<Buch>();
    public Bibliothek() {
    }

    public Buch sucheNachISBN(String isbn) {
        Buch b = new Buch(isbn,"","");
        if (bestand.contains(b)) {
            return b;
        }
        return null;
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
        return bestand.add(b);
    }
    public Map bestandNachAutorAuflisten() {
        Map<String, Set<Buch>> res = new HashMap<String, java.util.Set<Buch>>();
        for (Buch b: bestand) {
            Set<Buch> s = res.get(b.autor);
            if (s == null) {
                s = new HashSet<Buch>();
                res.put(b.autor,s);
            }
            s.add(b);
        }
        return res;
    }
}
