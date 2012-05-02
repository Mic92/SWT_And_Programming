public class Entry {
    private Person person;
    private TelephoneNumber number;
    private Address address;

    public Entry(Person person, TelephoneNumber number, Address a) {
        this.person = person;
        this.number = number;
        this.address = a;
    }

    @Override
    public String toString() {
        return number.getTelephoneNumber();
    }

    public Person getPerson() {
        return person;
    }

    public TelephoneNumber getTelephoneNumber() {
        return number;
    }

    public Address getAddress() {
        return address;
    }
}
