
public class Adel extends Einwohner {
        @Override
        int steuer() {
                int betrag = super.steuer();
                if (betrag < 20) {
                        return 20;
                } else {
                        return betrag;
                }
        }

}
