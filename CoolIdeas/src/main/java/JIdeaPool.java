import java.util.*;

public class JIdeaPool {
    private Map<JTopic,Set<JIdea>> pool = new HashMap<JTopic, Set<JIdea>>();
    public void add(JTopic topic) {
        if (pool.get(topic) != null) {
            return;
        }

        HashSet<JIdea> ideas = new HashSet<JIdea>();
        pool.put(topic, ideas);
    }
    public void add(JIdea idea, JTopic topic) {
        Set<JIdea> ideas = pool.get(topic);
        if (ideas == null) {
            add(topic);
            ideas = pool.get(topic);
        }
        ideas.add(idea);
    }
    public boolean remove(JIdea idea) {
        boolean found = false;
        for(Set<JIdea> ideas: pool.values()) {
            found |= ideas.remove(idea);
        }
        return found;
    }
    public boolean remove(JTopic topic) {
        return pool.remove(topic) != null;
    }
    public int numberOfTopics() {
        return pool.size();
    }
    public int numberOfIdeas() {
        Set<JIdea> set = new HashSet<JIdea>();
        for(Set<JIdea> ideas: pool.values()) {
            set.addAll(ideas);
        }
        return set.size();
    }
}
