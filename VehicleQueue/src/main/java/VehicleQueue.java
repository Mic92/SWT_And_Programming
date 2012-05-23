import java.util.*;

public class VehicleQueue implements Observer {
    double vehiclePerSecondEnter, vehiclePerSecondLeave;
    int trafficLightRate;
    int leftLightTime;
    boolean greenLight = true;
    private VehicleGenerator vehicleGenerator;
    private ArrayList<Vehicle> list = new ArrayList<Vehicle>();

    public VehicleQueue(double vehiclePerSecondEnter, int trafficLightRate, double vehiclePerSecondLeave, VehicleGenerator vg) {
        this.vehiclePerSecondEnter = vehiclePerSecondEnter;
        this.vehiclePerSecondLeave = vehiclePerSecondLeave;
        this.trafficLightRate = trafficLightRate;
        this.vehicleGenerator = vg;
    }
    public void update(Observable o, Object arg) {
        if (leftLightTime <= 1) {
            leftLightTime = trafficLightRate;
            greenLight = !greenLight;
        } else {
            leftLightTime--;
        }
        enter();
        leave();
    }
    public void enter() {
        for(int i=0;i<vehiclePerSecondEnter;i++) {
            list.add(vehicleGenerator.createVehicle());
        }
    }
    public void leave() {
        if (greenLight) {
            for (int i=0;i<vehiclePerSecondLeave;i++) {
                list.remove(0);
            }
        }
    }
    public double getLength() {
       int l = 0;
       for (Vehicle v: list) {
           l += v.getLength();
       }
        return l;
    }
    public int getSize() {
        return list.size();
    }
}
