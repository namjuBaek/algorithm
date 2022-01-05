package basic;

/**
 * 2021.01.06 수
 * @author bnj
 * 백준 11720번 숫자의 합
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 */

import java.util.Scanner;

public class N11720 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		int count = scan.nextInt();
		String num = scan.next();
		
		 
		for (int i=0; i<count; i++) {
			int pointer = Integer.parseInt(num.substring(i, i+1));
			
			sum += pointer;
		}
		
		System.out.println(sum);
	}

}
