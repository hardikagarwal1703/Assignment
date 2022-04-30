package tester;
import java.util.Scanner;
import javaStackApp.Customer;
import javaStackApp.FixedStack;
import javaStackApp.GrowableStack;
import javaStackApp.Stack;
public class TestStack {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			Stack ref = null;
			for (boolean exit = true; exit == true;) {
				System.out.println("Options " + "\n 1. choose Fixed Stack " + "\n 2. Choose Growable Stack"
						+ "\n 3. Push Data" + "\n 4. Pop Data" + "\n 5. Show Current Stack" + "\n 6. Exit");
				System.out.println("Choose Option");
				switch (Integer.parseInt(scan.next())) {
				case 1:
					if (ref == null) {
						ref = new FixedStack();
					} else {
						System.out.println("STACK ALREADY GROWABLE!!");
					}
					break;
				case 2:
					if (ref == null) {
						ref = new GrowableStack();
					} else {
						System.out.println("STACK ALREADY FIXED!!");
					}
					break;
				case 3:
					if (ref != null) {
						System.out.println("Enter Customer Data ID NAME ADDRESS");
						Customer cust = new Customer(Integer.parseInt(scan.next()), scan.next().toString(),
								scan.next().toString());
						ref.push(cust);
					} else {
						System.out.println("CHOOSE STACK TYPE FIRST (1/2)");
					}
					break;
				case 4:
					if (ref != null) {
						Customer cust = ref.pop();
						// toString Overridden
						System.out.println("Popped Element: \n" + cust);
					} else {
						System.out.println("CHOOSE STACK TYPE FIRST (1/2)");
					}
					break;
				case 5:
					try {
						ref.showStack();
					} catch (Exception e) {
						System.out.println("CHOOSE STACK TYPE FIRST (1/2)");
					}
					break;
				case 6:
					System.out.println("TATA BYE BYE KHATAM!");
					exit = false;
					break;
				}
			}
		}
	}
}