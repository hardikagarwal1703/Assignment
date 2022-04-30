package P1;

//error can be removed either by continuing abstraction by adding abstract
//Implementing the abstract methods
public class NetworkPrinter implements Printer{
	
	@Override
	public void print(String mesg) {
		//Implementation of abstract method of interface
		System.out.println("Printing message over the network printer: " + mesg);
	}
}
