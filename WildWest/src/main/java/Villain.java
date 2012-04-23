package praktomat.WildWest;
public class Villain extends Human {
    public Villain(String name, int age, String horseName, FightExperience experience) {
        super(name, age, horseName, experience);
    }
    boolean fightAgainstSheriff(Sheriff enemy)  {
        boolean drunkness = this.getDrunkenness().compareTo(enemy.getDrunkenness()) == 0;
        boolean experience = this.getFightExperience().compareTo(enemy.getFightExperience()) == 0;
        if (drunkness && experience) {
            return false;
        }  else if (drunkness) {
            return this.getFightExperience().compareTo(enemy.getFightExperience()) == 1;
        }  else if (experience) {
            return this.getDrunkenness().compareTo(enemy.getDrunkenness()) == -1;
        }
        return false;
    }
}