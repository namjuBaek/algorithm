package basic;

import java.util.Scanner;

/**
 * @author bnj
 * ���� 2562��
 * 9���� ���� �ٸ� �ڿ����� �־��� ��, �̵� �� �ִ��� ã�� �� �ִ��� �� ��° �������� ���ϴ� ���α׷�
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
