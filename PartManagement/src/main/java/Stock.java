import java.util.*;
public abstract class Stock {
    private Map<Part,Integer> parts = new HashMap<Part, Integer>();
    private Observation observer;
    public void register(Observation observer) {
        this.observer = observer;
    }
    public void notify(Part t) {
          if (observer != null) observer.alarm(t);
    }
    // liefert zu dem Part t die im Stock vorhandene Anzahl
// falls t nicht existiert, wird -1 zurück geliefert
    public int get(Part t) {
        return parts.containsKey(t) ? parts.get(t) : -1;
    }
    // setzt die Anzahl für ein Partobjekt im Stock
    public boolean set(Part t, int anz) {
        if (parts.containsKey(t)) {
            parts.put(t,anz);
            return true;
        }
        return false;
    }
    // wenn das Part bereits existiert, wird die vorhandene Anzahl
// eines Partes erhöht, sonst wird das Part mit der Anzahl eingefügt
    public void insert(Part t, int anz ) {
        Integer c = parts.get(t);
        if (c == null) {
            parts.put(t,anz);
        } else {
            parts.put(t,anz+c);
        }
    }
    // erniedrigt die Anzahl eines Parts um anz, wenn genügend Parte im
// Stock sind (true-Fall), ansonsten wird die Anzahl im Stock nicht
// verändert und false zurück geliefert
    public boolean delete(Part t, int anz ) {
        Integer c = parts.get(t);
        if (c != null && c - anz > 0) {
            parts.put(t,c-anz);
            notify(t);
            return true;
        }
        return false;
    }
}