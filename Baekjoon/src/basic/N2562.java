package basic;

import java.util.Scanner;

/**
 * @author bnj
 * 백준 2562번
 * 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램
 * 
 */

public class N2562 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int max = 0;
		int pointer = 0;
		int[] num = new int[9];
		
		for (int i=0; i < 9; i++) {
			num[i] = scan.nextInt();
			
			if (num[i] > max) {
				max = num[i];
				pointer = i+1;
			}
		}
				
		System.out.println(max);
		System.out.println(pointer);
	}
}
