package P1;

public class Test1 {

	public static void main(String[] args) {
		ConsolePrinter p1 = new ConsolePrinter();
		p1.print("Hardik Agarwal Concole");
		
		FilePrinter p2 = new FilePrinter();
		p2.print("Hardik Agarwal File");
		
		NetworkPrinter p3 = new NetworkPrinter();
		p3.print("Hardik Agarwal Network");
	}

}
