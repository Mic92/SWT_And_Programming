public class Einzelteil extends Bauteil {

    private double preis;

    public Einzelteil( String id, double preis) {
        this.preis = preis;
        this.id = id;
    }

    public double preis() {
        return preis;
    }
}
