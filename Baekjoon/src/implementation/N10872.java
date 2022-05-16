package implementation;

/**
 * 2022.05.17 화
 * @author bnj
 * 백준 10872번 팩토리얼
 * 0보다 크거나 같은 정수 N이 주어질 때, N!을 출력하는 프로그램을 작성하시오
 * 
 */

import java.util.Scanner;

public class N10872 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		Factorial fact = new Factorial(num);
		System.out.println(fact.factorial(num));
	}
	
	
}

class Factorial {
	private int num;
	
	Factorial (int num) {
		this.num = num;
	}
	
	int factorial(int num) {
		if (num == 0) {
			return 1;
		}
		
		return num * factorial(num-1);
	}
}
