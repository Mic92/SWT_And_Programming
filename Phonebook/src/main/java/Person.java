public class Person {
    private String title, givenName, name;

    public Person(String title, String givenName, String name) {
        this.title = title;
        this.givenName = givenName;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "title='" + title + '\'' +
                ", givenName='" + givenName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
