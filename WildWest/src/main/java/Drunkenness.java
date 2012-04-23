import java.util.HashMap;
public enum Drunkenness {
    SMILEY,
    FRIENDLY,
    CHATTY,
    CONTROLLEDBUZZ,
    BUZZED,
    DRUNK,
    HAMMERED,
    BOMBED,
    SHITFACED,
    BLACKOUT;
    final static HashMap<Drunkenness,Integer> reverse_map = new HashMap<Drunkenness,Integer>();
    static {
        int i = 0;
        for (Drunkenness d : Drunkenness.values()) {
            reverse_map.put(d,i);
            i++;
        }
    }
    Drunkenness increment() {
        if (this == BLACKOUT) return BLACKOUT;
        int idx = reverse_map.get(this);
        return Drunkenness.values()[++idx];
    }
}
