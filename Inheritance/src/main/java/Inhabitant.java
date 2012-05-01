public class Inhabitant {
        protected int income;

        void setIncome(int einkommen) {
                income = einkommen;
        }

        int taxedIncome() {
                return income;
        }

        int tax() {
                int betrag = (int) (taxedIncome() * 0.1);
                if (betrag < 1) {
                        return 1;
                } else {
                        return betrag;
                }
        }

}
