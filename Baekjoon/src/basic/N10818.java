package basic;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author bnj
 * 백준 10818번
 * N개의 정수가 주어질 때, 최솟값과 최댓값을 구하는 프로그램
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
