package implementation;

/**
 * 2022.05.17 ȭ
 * @author bnj
 * ���� 10872�� ���丮��
 * 0���� ũ�ų� ���� ���� N�� �־��� ��, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
 * 
 */

import java.util.Scanner;

public class N10872 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		System.out.println(factorial(num));
	}
	
	static int factorial(int num) {
		if (num == 0) {
			return 1;
		}
		
		return num * factorial(num-1);
	}
}
