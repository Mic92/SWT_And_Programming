import java.util.*;

public interface Matrix<E> {
    int getRowCount();
    int getColumnCount();
    int getObjectCount();
    int getDistinctObjectCount();
    Iterator<E> iterator();
    E get(int row, int column);
    boolean contains(E o);
    E put (int keyRow, int keyColumn, E value);
}