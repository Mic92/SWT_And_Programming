public class Address {
    private String street, streenbr, zipcode,
            city, additionalInformation;

    public Address(String street, String streenbr, String zipcode, String city, String additionalInformation) {
        this.street = street;
        this.streenbr = streenbr;
        this.zipcode = zipcode;
        this.city = city;
        this.additionalInformation = additionalInformation;
    }

    public String getStreet() {
        return street;
    }

    public String getStreenbr() {
        return streenbr;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streenbr='" + streenbr + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
