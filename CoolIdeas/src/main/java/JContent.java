import java.util.*;

public abstract class JContent extends Observable {
    protected String title, description;

    protected JContent(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitel() {
        return title;
    }

    public void setTitel(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Idea: " + title + "\n" + description;
    }
}
