public class Nobel extends Inhabitant {
        @Override
        int tax() {
                int betrag = super.tax();
                if (betrag < 20) {
                        return 20;
                } else {
                        return betrag;
                }
        }

}
