package P1;

public class Test2 {

	public static void main(String[] args) {
		Printer p; 	//i/f(interface) type of reference variable 
					//no objects created so far, how many bytes: as per JVM spec
					//m/m allocated on stack.
		
		//p = new Printer(); //error as cannot instantiate i/f s
		p = new FilePrinter(); //up-casting as FilePrinter IS-A Printer 
		
		//Can i/f reference refer to implementing class instance directly yes.
		
		p.print("Some Message!"); //no java c error as printer has print method
								  // JVM will call print method of FilePrinter
		
		p = new NetworkPrinter();  //file printer object went for GC

		p.print("Other Message!");
		
		
		
	}

}
