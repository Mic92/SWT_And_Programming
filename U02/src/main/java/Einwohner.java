
public class Einwohner {
        protected int mEinkommen;

        void setEinkommen(int einkommen) {
                mEinkommen = einkommen;
        }

        int zuVersteuerndesEinkommen() {
                return mEinkommen;
        }

        int steuer() {
                int betrag = (int) (zuVersteuerndesEinkommen() * 0.1);
                if (betrag < 1) {
                        return 1;
                } else {
                        return betrag;
                }
        }

}
