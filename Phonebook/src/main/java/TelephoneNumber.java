public class TelephoneNumber {
    private String prefix, telephoneNumber;
    private AccessType accessType;

    public TelephoneNumber(String prefix, String telephoneNumber) {
        this.prefix = prefix;
        this.telephoneNumber = telephoneNumber;
    }
    public TelephoneNumber(String prefix, String telephoneNumber, AccessType type) {
        this.prefix = prefix;
        this.telephoneNumber = telephoneNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    @Override
    public String toString() {
        return "TelephoneNumber{" +
                "prefix='" + prefix + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", accessType=" + accessType +
                '}';
    }
}
