import java.util.*;
public class JIdea extends JContent {
    private List<JAttachment> attachments = new ArrayList<JAttachment>();
    private JState state;
    private JValuation valuation;

    public JIdea(String title, String description) {
       super(title,description);
       state = new Draft();
    }
    void evaluate(JValuation b) {
          valuation = b;
    }
    public void discuss(String text) {
        System.out.println(text);
        state.discuss(text);
    }
    public void hold() {
        state.hold();
    }
    public void release() {
        state.release();
    }
    public void decline() {
        state.decline();
    }
    public String getCurrentDiscussion() {
        return state.getCurrentDiscussion();
    }
    public JValuation getValuation() {
            return valuation;
    }
    public void addAttachment(JAttachment attachment) {
        attachments.add(attachment);
    }
    public List<JAttachment> getAttachments(){
        return attachments;
    }
    public void removeAttachment(JAttachment attachment) {
        attachments.remove(attachment);
    }

    public abstract class JState {
        private String currentDiscussion = "";
        private JValuation valuation;
        public void discuss(String text) {
            if (text.equals("")) return;
            currentDiscussion += text + "\n";
        }

        public void evaluate(JValuation b) {
            valuation = b;
        }
        public void hold() { }
        public void release() { }
        public void decline() {
            //state = new EndState();
        }
        public String getCurrentDiscussion(){
            return currentDiscussion;
        }
        public JValuation getValuation() {
            return valuation;
        }
    }
    public class EndState extends JState {

    }
    public class ApprovedIdea extends JState {
        public void release() {
            state = new Draft();
        }
    }
    public class OpenDraft extends JState {
        public void hold() {
            JState ai = new ApprovedIdea();
            ai.discuss(state.getCurrentDiscussion());
            ai.evaluate(state.getValuation());
            state = ai;
        }
    }
    public class Draft extends JState {
        public void hold() {
            JState od = new OpenDraft();
            od.discuss(state.getCurrentDiscussion());
            od.evaluate(state.getValuation());
            state = od;
        }
    }

}


