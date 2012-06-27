import java.util.*;

public interface OrderedSet<E> extends Set<E>,List<E> {
    public boolean add(E obj);
    public boolean addAll(Collection collection);
    public boolean addAll(int i, Collection collection);
    public E set(int i, E obj);
    public void add(int i, E obj);
}
