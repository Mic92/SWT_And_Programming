public class Koenigreich {

	public static void main(String[] args) {

		steuerbescheid(new Koenig(), 20);
        steuerbescheid(new Adel(), 20);
        steuerbescheid(new Bauer(), 20);
        steuerbescheid(new Leibeigener(), 20);
	}

	static void steuerbescheid(Einwohner einwohner,
	                           int einkommen) {
        einwohner.setEinkommen(einkommen);
        System.out.println(einwohner.getClass().getName() +
           ": Einkommen " + einkommen +
           ", zu versteuerndes Einkommen " +
           einwohner.zuVersteuerndesEinkommen() +
           ", Steuer " + einwohner.steuer());
    }
}
