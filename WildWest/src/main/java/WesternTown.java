import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WesternTown {
    private final String location;
    private final int time;
    private final Saloon saloon;
    private final Random rand = new Random();
    private List<Villain> villains = new ArrayList<Villain>();
    private List<Sheriff> sheriffs = new ArrayList<Sheriff>();

    public WesternTown(String location, int time, Saloon saloon) {
        this.location = location;
        this.time = time;
        this.saloon = saloon;
    }

    public Saloon getSaloon() {
        return saloon;
    }

    public String getLocation() {
        return location;
    }

    public int getTime() {
        return time;
    }

    public List<Sheriff> getSheriffs() {
        return sheriffs;
    }

    public Sheriff getRandomSheriff() {
        int max = sheriffs.size();
        return sheriffs.get(rand.nextInt(max));
    }

    public boolean addSheriff(Sheriff sheriff) {
        if (sheriff == null) throw new NullPointerException();
        if (!sheriffs.contains(sheriff)) {
            sheriffs.add(sheriff);
            return true;
        }
        return false;
    }

    public List<Villain> getVillains() {
        return villains;
    }

    public Villain getRandomVillain() {
        int max = villains.size();
        return villains.get(rand.nextInt(max));
    }

    public boolean addVillain(Villain villain) {
        if (villain == null) throw new NullPointerException();
        if (!villains.contains(villain)) {
            villains.add(villain);
            return true;
        }
        return false;
    }
}
