public class Factory {
    private Purchasing p;
    private ReceivingStock s;

    public Factory(Purchasing p, ReceivingStock s) {
        this.p = p;
        this.s = s;
    }
    public Part create(int partType, String id, String name) {
        Part p;
        switch (partType) {
            case IPartType.COMPONENT:
                p = new Components(id,name);
                break;
            case IPartType.RESOURCE:
                p = new Resource(id,name);
                break;
            case IPartType.SINGLE_COMPONENT:
                p = new SingleComponent(id,name);
                break;
            default:
                return null;
        }
        return p;
    }
}
