import java.util.*; import java.awt.Point;
public class MyMatrix<E> implements Matrix<E> {
    private Map<Point,E> m;
    private int numberRows;
    private int numberColumns;
    public MyMatrix() {
       m = new HashMap<Point, E>();
       numberRows = 0;
       numberColumns = 0;
    }
    public int getRowCount(){
         return numberRows;
    }
    public int getColumnCount(){
         return numberColumns;
    }
    public int getObjectCount(){
        return m.size();
    }
    public int getDistinctObjectCount(){
        HashSet<E> s = new HashSet<E>();
        s.addAll(m.values());
        return s.size();
    }
    public E get(int row, int column)
            throws IllegalArgumentException {
        if ((row < 0 || row >= numberRows) || ( column < 0 || column >= numberColumns)) {
            throw new IllegalArgumentException();
        }
        Point p = new Point(row,column);
        E obj = m.get(p);
        return obj;
    }
    public boolean contains(E o){
         return m.containsValue(o);
    }
    public E put (int row, int column, E value){
      if ((row + 1) > numberRows) {
          numberRows = row + 1;
      }
      if ((column + 1) > numberColumns) {
        numberColumns = column + 1;
      }
      Point p = new Point(row,column);
      return m.put(p,value);
    }
    public Iterator<E> iterator(){
        return new DepthFirstIterator<E>();
    }
    class DepthFirstIterator<E> implements Iterator<E> {
        int x,y;
        E next;
        public DepthFirstIterator() {
            x=0;
            y=0;
            next = null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public E next() {
            return next;
        }
        @SuppressWarnings("unchecked")
        public boolean hasNext() {
            for (; y < numberColumns; y++) {
                for (; x < numberRows; x++) {
                    System.out.println(x+":"+y);
                    Point p = new Point(x,y);
                    if (m.containsKey(p)) {
                        next = (E) m.get(p);
                         if (y < numberRows) {
                            y++;
                        } else {
                            x++;
                        }
                        return true;
                    }
                }
                x = 0;
            }
            return false;
        }
    }
}