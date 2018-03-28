
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Movie m=new Movie("krish",1);
		Movie m1=new Movie("Doom",2);
	
		Customer c=new Customer("ashitosh");
		c.addRental(new Rental(m,10));
		c.addRental(new Rental(m1, 5));
		System.out.println(c.statement());
	}
}
