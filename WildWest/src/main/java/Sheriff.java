public class Sheriff extends Human {
    private int victories = 0, losses = 0;

    public Sheriff(String name, int age, String horseName, FightExperience experience) {
        super(name, age, horseName, experience);
    }

    public int getVictories() {
        return victories;
    }

    public int getLosses() {
        return losses;
    }

    boolean fightAgainstVillain(Villain enemy)  {
        boolean drunkness = this.getDrunkenness().compareTo(enemy.getDrunkenness()) == 0;
        boolean experience = this.getFightExperience().compareTo(enemy.getFightExperience()) == 0;
        boolean wins = true;
        if (drunkness && experience) {
            return false;
        }  else if (drunkness) {
            wins = this.getFightExperience().compareTo(enemy.getFightExperience()) == 1;
        }  else if (experience) {
            wins = this.getDrunkenness().compareTo(enemy.getDrunkenness()) == -1;
        }
        if (wins) {
            victories++;
        } else {
            losses++;
        }
        return wins;
    }
}
