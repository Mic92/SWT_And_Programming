public class Flooring extends Material {
    private double limit = 0.02, widthOfFlooring;
    public Flooring(String name, double price, double width) {
        super(name,price);
        widthOfFlooring = width;
    }
    public double getWidth() {
        return widthOfFlooring;
    }
    public double getMaterialReq(Surface s) {
        return Math.ceil(s.getArea() / widthOfFlooring);
    }
}
