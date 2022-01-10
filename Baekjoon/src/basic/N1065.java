package basic;

/**
 * 2022.01.05 수
 * @author bnj
 * 백준 1065번 한수
 * 한수 : 어떤 양의 정수 X의 각 자리가 등차수열을 이루는 수
 * 등차수열 : 연속된 두 개의 수의 차이가 일정한 수열
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 * 
 */

import java.util.Scanner;

public class N1065 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		int count = checkProgression(num);
		System.out.println(count);
	}
	
	static int checkProgression(int num) {
		int count = 0;
		
		for (int i=1; i<=num; i++) {
			if (i < 100) {
				count++;
				continue;
			}
			
			int hundred = i / 100;
			int ten = (i % 100) / 10;
			int one = i % 10;
			
			if ((one - ten) == (ten - hundred)) {
				count++;
			}
		}
		
		return count;
	}

}
