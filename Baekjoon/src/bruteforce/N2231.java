package bruteforce;

/**
 * 2022.01.11 화
 * @author bnj
 * 백준 N2231번 분해합
 * 
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 
 * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 
 * 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class N2231 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int count = 0;
		while (count < num) {
			int calculNum = count;
			int sum = calculNum;
						
			//각 자릿수의 합 구하기
			while (calculNum % 10 != 0) {
				sum += calculNum % 10;
				calculNum = calculNum / 10;
			}
			
			//분해합이 입력한 숫자와 같으면 이 시점 count가 가장 작은 생성자
			if (sum == num) {
				break;
			}
			count++;
		}
		
		if (count == num) {
			System.out.println(0);
		} else {
			System.out.println(count);	
		}
	}
}
