public class Paint extends Material {
    private double limit = 0.02;
    private int noOfCoats;
    private double noOfSqMPerLiter;
    public Paint(String name, double price, int noOfCoats, double noOfSqMPerLiter) {
        super(name, price);
        this.noOfCoats = noOfCoats;
        this.noOfSqMPerLiter = noOfSqMPerLiter;
    }
    public int getNoOfCoats() {
        return noOfCoats;
    }
    public double getNoOfSqMPerLiter() {
        return noOfSqMPerLiter;
    }
    public double getMaterialReq(Surface s) {
        double liter = s.getArea() * noOfCoats / noOfSqMPerLiter;
        double bottles = Math.ceil(liter * 2);
        return bottles / 2;
    }
}
