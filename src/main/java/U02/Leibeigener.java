
public class Leibeigener extends Bauer {
       @Override
       int zuVersteuerndesEinkommen() {
               int steuer = super.zuVersteuerndesEinkommen() - 12;
               if (steuer < 0) return 0;
               return steuer;
       }
}
