package P2;

public class C implements A,B{

	@Override
	public double compute(double d1, double d2) {
		//System.out.println(DATA); gives error as ambiguous 
		//methods can be duplicate but not data members.
		
		System.out.println(A.DATA);
		
		return d1+d2;
	}
	
}
