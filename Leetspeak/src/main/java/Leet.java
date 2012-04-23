
public class Leet {
    final static private String[][] dict = {
            {"elite", "1337" },
            {"cool", "k3wl"},
            {"!", "!!!11"},
            {"ck", "xx"},
            {"ers", "0rz"},
            {"er", "0rz"},
            {"en", "n"},
            {"e", "3"},
            {"t", "7"},
            {"o", "0"},
            {"a", "@"}
    };

    public static String toLeet(String normal) {
        for (String[] pair: dict) {
            normal = normal.replace(pair[0],pair[1]);
        }
        return normal;
    }

    public static String[] allToLeet(String[] normals) {
        int len = normals.length;
        for (int i = 0; i < len; i++) {
            normals[i] = toLeet(normals[i]);
        }
        return normals;
    }
}
