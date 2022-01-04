package basic;

import java.util.Scanner;

/**
 * @author bnj
 * 백준 2577번
 * 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램
 * 
 */

public class N2577 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int A = 0, B = 0, C = 0;
		String multi;
		int count[] = new int[10];
		
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();
		
		multi = Integer.toString(A * B * C);
		
		for (int i = 0; i < multi.length(); i++) {
			for (int j=0; j < count.length; j++) {
				if (Character.getNumericValue(multi.charAt(i)) == j) {
					count[j]++;
					break;
 				}	
			}
		}

		for (int i=0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}

}
