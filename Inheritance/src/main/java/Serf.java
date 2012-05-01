public class Serf extends Farmer {
       @Override
       int taxedIncome() {
               int steuer = super.taxedIncome() - 12;
               if (steuer < 0) return 0;
               return steuer;
       }
}
