import java.util.*;

public class Surface extends RenovationObject {
    private double length, width;
    private Material selectedMaterial;
    public Surface(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public double getPrice() {
        double price = selectedMaterial.getPricePerUnit();
        return this.selectedMaterial.getMaterialReq(this) * price;
    }

    @Override
    public Map<String,Double> addMaterialReq(Map<String,Double> materials) {
        String material_name = selectedMaterial.getName();
        double material_req = selectedMaterial.getMaterialReq(this);

        Double req = materials.get(selectedMaterial.getName());
        if (req == null) {
            materials.put(material_name, material_req);
        } else {
            materials.put(material_name, material_req + req);
        }
        return materials;
    }

    public double getArea() {
        return length * width;
    }
    public void setMaterial(Material material) {
        this.selectedMaterial = material;
    }
}
