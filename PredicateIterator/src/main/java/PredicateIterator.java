import java.util.*;
public class PredicateIterator<T> implements Iterator {
    private Predicate<T> pred;
    private Iterator<T> iter;
    private T arg;
    private T nextElem;
    private boolean hasNext;

    public PredicateIterator(Iterator<T> iter, Predicate<T> pred, T argument) {
        this.iter = iter;
        this.pred = pred;
        this.arg  = argument;
        findNext();
    }
    public boolean hasNext() {
        return hasNext;
    }
    public void remove() {
        iter.remove();
    }

    private void findNext() {
        hasNext = false;
        while(iter.hasNext()) {
            T e = iter.next();
            if (pred.predicate(e, arg)) {
                nextElem = e;
                hasNext = true;
                return;
            }
        }
    }

    public T next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        T ret = nextElem;
        findNext();
        return ret;
    }
}
