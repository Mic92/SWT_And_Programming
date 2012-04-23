public abstract class Human {
    private final String name, horseName;
    private final int age;
    private final FightExperience experience;
    private Drunkenness drunkenness = Drunkenness.SMILEY;

    public Human(String name, int age, String horseName, FightExperience experience) {
        this.name = name;
        this.horseName = horseName;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getHorseName() {
        return horseName;
    }

    public int getAge() {
        return age;
    }

    public FightExperience getFightExperience() {
        return experience;
    }

    public Drunkenness getDrunkenness() {
        return drunkenness;
    }
    public void drinkSomeWhisky() {
        drunkenness = drunkenness.increment();
    }

}
