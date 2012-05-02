public class Bottle<T extends Drink> {
    private T content;
    public void fill(T content) {
        this.content = content;
    }
    public boolean isEmpty() {
        return content == null;
    }
    public T empty() {
        T temp = content;
        content = null;
        return temp;
    }
}
