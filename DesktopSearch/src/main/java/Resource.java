public class Resource {
    private String name;
    private String path;
    private ResourceType rt;
    public Resource(String name, String path, ResourceType rt) {
        this.name = name;
        this.path = path;
        this.rt = rt;
    }
    public String getName() {
        return name;
    }
    public ResourceType getType() {
        return rt;
    }
    public String getPath() {
        return path;
    }
}
