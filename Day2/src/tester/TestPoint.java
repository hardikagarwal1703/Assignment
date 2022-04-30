package tester;

import java.util.Scanner;
import com.cdac.geometry.Point2D;

class TestPoint {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter X and Y co-ordinates for P1 : ");
		Point2D p1 = new Point2D(sc.nextInt(), sc.nextInt());
		System.out.println("Enter X and Y co-ordinates for P2 : ");
		Point2D p2 = new Point2D(sc.nextInt(), sc.nextInt());
		
		System.out.println("P1 = "+p1.show());
		System.out.println("P2 = "+p2.show());
		
		System.out.println("Check for equality = ");
		
		if(p1.isEqual(p1,p2)){	// for method call we can use p1.isEqual OR p2.isEqual
			System.out.println("Same");
		}else{
			System.out.println("Different "+"\nDistance = "+p1.calculateDistance(p1, p2));
		}
		sc.close();
	}
}