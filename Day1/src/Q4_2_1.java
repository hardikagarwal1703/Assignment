//Author: Hardik Agarwal @ 83
import java.util.Scanner;

class Q4_2_1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long total = 0;
		boolean i = true;
		
		while(i){
			System.out.println("	   !!....MENU....!!");
			System.out.println("   ITEMS			PRICE");
			System.out.println("1.  Dosa			20.00");
			System.out.println("2.  Samosa			20.00");
			System.out.println("3.  Idli			20.00");
			System.out.println("4.  Vada			20.00");
			System.out.println("5.  Pav-Bhaji			20.00");
			System.out.println("6.  Dabeli			20.00");
			System.out.println("7.  Jalebi-Fafda		20.00");
			System.out.println("8.  Ice-cream			20.00");
			System.out.println("9.  Cold drink			20.00");
			System.out.println("10. Generate Bill			 ");
			
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch (choice){
				case 1: 
					System.out.println("Please enter qty : ");
					int q1 = 0;
					q1 = sc.nextInt();
					total = total + (20*q1);
					break;
				case 2:
					System.out.println("Please enter qty : ");
					int q2 = sc.nextInt();
					total = total + (20*q2);
					break;
				case 3:
					System.out.println("Please enter qty : ");
					int q3 = sc.nextInt();
					total = total + (20*q3);
					break;
				case 4:
					System.out.println("Please enter qty : ");
					int q4 = sc.nextInt();
					total = total + (20*q4);
					break;
				case 5:
					System.out.println("Please enter qty : ");
					int q5 = sc.nextInt();
					total = total + (20*q5);
					break;
				case 6:
					System.out.println("Please enter qty : ");
					int q6 = sc.nextInt();
					total = total + (20*q6);
					break;
				case 7: 
					System.out.println("Please enter qty : ");
					int q7 = sc.nextInt();
					total = total + (20*q7);
					break;
				case 8: 
					System.out.println("Please enter qty : ");
					int q8 = sc.nextInt();
					total = total + (20*q8);
					break;
				case 9: 
					System.out.println("Please enter qty : ");
					int q9 = sc.nextInt();
					total = total + (20*q9);
					break;
				case 10: 
					System.out.println("TOTAL Kharcha =  "+total);
					i = false;
					break;
				default :
					System.out.println("Please enter valid choice..!!");
			}	
		}
	}
}
