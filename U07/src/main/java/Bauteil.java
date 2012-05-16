abstract public class Bauteil {

    protected String id;

    public abstract double preis();

    public Bauteil getBauteil() {
        return this;
    }

    public String getId() {
        return id;
    }
}
