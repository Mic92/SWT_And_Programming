public class ResourceType {
    private KeywordCollector collector;
    private String desc;
    public ResourceType(String desc,KeywordCollector collector) {
        this.desc = desc;
        this.collector = collector;
    }

    public KeywordCollector getCollector() {
        return collector;
    }
}
