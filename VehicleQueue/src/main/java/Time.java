import java.util.Observable;

public class Time extends Observable{
    private int currentTime = 0;
    private int endOfTime = 100;
    private static Time instance = new Time();

    private Time() {
    }
    public void initEndOfTime(int endOfTime) {
        this.endOfTime = endOfTime;
    }

    public int getCurrentTime() {
        return currentTime;
    }
    public static Time getInstance() {
        return instance;
    }
    void run() {
        for(int i=0; i<endOfTime;i++) {
            currentTime++;
            notifyObservers();
        }
    }
}
