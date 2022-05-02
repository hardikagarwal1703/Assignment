//Author: Hardik Agarwal @ 83
import java.util.Scanner;

class Q4_1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 double numbers : ");
		
		double num1 = 0.0;
		double num2 = 0.0;
		
		boolean b1 = sc.hasNextDouble();
		if(!b1)
				System.out.println("Not Double..!!");
		else{
			num1 = 	sc.nextDouble();
		
			boolean b2 = sc.hasNextDouble();
		
			if(b2){
				num2 = 	sc.nextDouble();
				System.out.println("Average = "+(num1+num2)/2.0);
			}
			else
				System.out.println("Not Double..!!");
		}
		System.out.println("Joy");
		sc.close();
	}
}