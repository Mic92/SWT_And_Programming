public class JTopic extends JContent {
    private int id;

    public JTopic(int id, String title, String description) {
        super(title,description);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
