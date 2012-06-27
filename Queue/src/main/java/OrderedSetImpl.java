import java.util.*;

public class OrderedSetImpl<E> extends ArrayList<E> implements OrderedSet<E> {
    public OrderedSetImpl() {
        super();
    }

    public OrderedSetImpl(int initialCapacity) {
        super(initialCapacity);
    }

    public boolean add(E obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        int previousIndex = indexOf(obj);
        if (previousIndex != -1)
            return false;
        else {
            super.add(obj);
            return true;
        }
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int i, E obj) {
        /*
* Ersetzt das Element an Position i genau dann durch das Element
* obj, falls in dieser geordneten Menge nicht bereits das
* gleiche Element enthalten ist. Der Wert null ist für obj nicht
* zulässig und führt zu einer Exception.
* Gibt das Element zurück, das zuvor an Position i war oder
* null, falls obj zuvor bereits enthalten war
*/
        if (size() <= i) {
            return null;
        }
        if (contains(obj)) {
            return null;
        }
        return (E) super.set(i, obj);
    }

    public void add(int i, E obj) {
        /**
         * Fügt ein Element obj genau dann an Position i ein, falls in
         * dieser geordneten Menge nicht bereits das gleiche Element
         * enthalten ist. Der Wert null ist für obj nicht zulässig und
         * führt zu einer Exception.
         */
        if (obj == null) throw new NullPointerException();
        if (!contains(obj)) super.add(obj);
    }


}
