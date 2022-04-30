//Author: Hardik Agarwal @ 83
package tester;

import java.util.Scanner;
import com.cdac.geometry.Point2D;

public class TestPoints {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number of Points You Want To Enter!");
		
		//Array of references of type Point2D
		Point2D[] points = new Point2D[Integer.parseInt(scan.next())];
		
		//Loop for entering values of x and y
		for(int i=0; i<points.length; i++) {
			System.out.println("Enter X & Y of Point P"+(i+1));
			
			//Creating objects of Point2D Class whose ref are in array points.
			points[i] = new Point2D(Integer.parseInt(scan.next()),
					Integer.parseInt(scan.next()));
		}
		
		//Loop to display points
		for(Point2D coordinate:points) {
			System.out.println(coordinate.show());
		}
		
		//Two Index input and check for equal or calculating distance.
		System.out.println("Enter two indexes for points array:");
		Point2D p1 = points[Integer.parseInt(scan.next())];
		Point2D p2 = points[Integer.parseInt(scan.next())];
		if(p1.isEqual(p2)) {
			System.out.println("Points enetered are equal!");
		}else {
			System.out.println("Distance b/w points = " + p1.calculateDistance(p2));
		}
		
		scan.close();
	}

}
