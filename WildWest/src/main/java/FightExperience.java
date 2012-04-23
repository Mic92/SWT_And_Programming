
import java.util.HashMap;

public enum FightExperience {
    LOWBOB,
    EXPERIENCED,
    HIGH,
    GODLIKE;
    final static HashMap<FightExperience,Integer> reverse_map = new HashMap<FightExperience,Integer>();
    static {
        int i = 0;
        for (FightExperience d : FightExperience.values()) {
            reverse_map.put(d,i);
            i++;
        }
    }
}
