import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

class Customer {
   private String _name;
  // private Vector _rentals = new Vector();
   private ArrayList<Rental> _rentals = new ArrayList<Rental>();
   public Customer (String name){
       _name = name;
   };

   public void addRental(Rental arg) {
    // _rentals.addElement(arg);
	   _rentals.add(arg);
   }
   public String getName (){
       return _name;
   };

public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
       // Enumeration rentals = _rentals.elements();
        Enumeration<Rental> rentals = Collections.enumeration(_rentals);
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amounts for each line
            thisAmount = each.getCharge();

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
each.getDaysRented() > 1) frequentRenterPoints ++;

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
" frequent renter points";
        return result;

    }
}
