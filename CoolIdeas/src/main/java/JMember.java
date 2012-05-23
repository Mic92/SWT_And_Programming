import java.util.*;
public class JMember implements Observer {
    private JTopic topic;
    public void update(Observable o, Object arg) {

    }
    public void subscribeToTopic(JTopic topic) {
        topic.addObserver(this);
        this.topic = topic;
    }
    public JTopic getSubscribedTopic() {
        return topic;
    }
}
