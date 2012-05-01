public class Koenigreich {

	public static void main(String[] args) {

		steuerbescheid(new King(), 20);
        steuerbescheid(new Nobel(), 20);
        steuerbescheid(new Farmer(), 20);
        steuerbescheid(new Serf(), 20);
	}

	static void steuerbescheid(Inhabitant inhabitant,
	                           int einkommen) {
        inhabitant.setIncome(einkommen);
        System.out.println(inhabitant.getClass().getName() +
           ": Einkommen " + einkommen +
           ", zu versteuerndes Einkommen " +
           inhabitant.taxedIncome() +
           ", Steuer " + inhabitant.tax());
    }
}
