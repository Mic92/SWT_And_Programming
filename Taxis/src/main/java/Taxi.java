public class Taxi {
    private Human driver;
    private Human passengers[] = new Human[4];
    private int seatsTaken = 0;
    public Taxi(Human driver) {
        this.driver = driver;
    }

    public String getDriverName() {
        return driver.toString();
    }

    public void add(Human passenger) {
        if (seatsTaken == 4) {
            System.out.println("We are sorry, "+passenger+". The taxi is full.");
            return;
        }
        System.out.println(passenger+" gets in.");
        passengers[seatsTaken] = passenger;
        if (seatsTaken < 4) {
            seatsTaken++;
        }
    }

    @Override
    public String toString() {
        String p;

        switch (seatsTaken) {
            case 0: p = "nobody"; break;
            case 1: p = passengers[0].toString(); break;
            case 2: p = passengers[0] + " and " + passengers[1]; break;
            case 3: p = String.format("%s, %s and %s",passengers[0],passengers[1],passengers[2]); break;
            default: p = String.format("%s, %s, %s and %s",passengers[0],passengers[1],passengers[2],passengers[3]);
        }
        return String.format("This is the taxi of %s. He takes %s along.", driver, p);
    }
    public Human[] allGetOut() {
        Human[] tmp = passengers;
        seatsTaken = 0;
        passengers = new Human[4];
        return tmp;
    }
}
