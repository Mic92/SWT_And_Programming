import java.io.File;
public class JAttachment extends JContent {
    private File file;

    public JAttachment(String title, String description, File f) {
        super(title,description);
        file = f;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    @Override
    public String toString() {
        return "Attachment: "+ title +"\n"+ description;
    }
}
