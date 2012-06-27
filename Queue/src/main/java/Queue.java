public interface Queue<E> {
    public boolean add(E o);
    public E remove();
    public E front();
    public boolean isEmpty();
    public int size();
 }
