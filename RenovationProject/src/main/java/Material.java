public abstract class Material {
    private String name;
    private double price;
    public Material(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return price;
    }
    public abstract double getMaterialReq(Surface s);

    public double getPriceOfASurface(Surface s) {
        s.setMaterial(this);
        return s.getPrice();
    }
}
