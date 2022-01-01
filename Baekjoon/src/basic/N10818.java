package basic;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author bnj
 *
 */
public class N10818 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int count = 0;
		int[] num;
		int max = -1000001, min = 1000001;
		
	    try (Scanner scan = new Scanner(System.in)) {
			count = scan.nextInt();
			num = new int[count];
			
			for (int i=0; i<count; i++) {
				num[i] = scan.nextInt();
			}
		}
	  
	    for (int i=0; i<count; i++) {
	    	if (num[i] > max) {
	    		max = num[i];
	    	}
	    	if (num[i] < min) {
	    		min = num[i];
	    	}
	    }
	    
	    System.out.println(min + " " + max);
	} 
}
