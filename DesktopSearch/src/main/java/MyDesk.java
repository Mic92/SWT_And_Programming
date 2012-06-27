import java.util.*;
public class MyDesk {
    private Index myIndex;
    private Map<String,ResourceType> types = new HashMap<String, ResourceType>();
    private List<Resource> resources;
    public MyDesk() {
    }

    public void registerType(String extension, ResourceType type) {
        types.put(extension,type);
    }

    public ResourceType getType(String extension) {
        return types.get(extension);
    }


    public void unregisterType(String extension) {
        types.remove(extension);
    }

    public void registerResource(Resource res) {
        if (resources == null) {
            resources = new ArrayList<Resource>();
        }
        resources.add(res);
    }

    public List<Resource> processRequest(String request) {
        return resources;
    }
}
