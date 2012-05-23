import java.util.*;
public class StructuredObject extends RenovationObject {
    Set<RenovationObject> parts = new HashSet<RenovationObject>();
    public StructuredObject() { }
    void add(RenovationObject o) {
        parts.add(o);
    }
    public double getPrice() {
        int price = 0;
        for(RenovationObject o: parts) {
            price += o.getPrice();
        }
        return price;
    }
    @Override
    public Map<String,Double> addMaterialReq(Map<String,Double> materials) {
        for (RenovationObject p: parts) {
            materials.putAll(p.addMaterialReq(materials));
        }
        return materials;
    }
}
