package P1;

public class Test3 {

	public static void main(String[] args) {
		Printer[] printers = {new FilePrinter(),
				new ConsolePrinter(), new NetworkPrinter()};
		
		//Printer, [Lp.Printer, FP, CP, NP
		
		for(Printer p: printers) {
			p.print("XYZ");
			
			if(p instanceof FilePrinter) {
				((FilePrinter)p).close();
			}
		}
		
		System.out.println("\n"+Printer.DATA);
	}

}
