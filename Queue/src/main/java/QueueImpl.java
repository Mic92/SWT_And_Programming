import java.util.List;
import java.util.ArrayList;

public class QueueImpl<E> implements Queue<E> {
    private List<E> myObjects;
    private boolean withDuplicates;

    public boolean add(E o) {
        if (!withDuplicates && myObjects.contains(o)) {
            return false;
        }
        myObjects.add(myObjects.size(), (E) o);
        return true;
    }

    public QueueImpl(boolean withDuplicates) {
        if (withDuplicates) {
            myObjects = new ArrayList<E>();
        } else {
            myObjects = new OrderedSetImpl<E>();
        }
        this.withDuplicates = withDuplicates;
    }

    public E remove() {
//Rückgabe analog der Methode remove(int index) von java.util.List
        if (myObjects.size() == 0) {
            return null;
        }
        return myObjects.remove(0);
    }

    public E front() {
        if (myObjects.size() == 0) return null;
        return myObjects.get(0);
    }

    public boolean isEmpty() {
        return myObjects.size() == 0;
    }

    public int size() {
        return myObjects.size();
    }

    public String toString() {
        return myObjects.toString();
    }

}