package basic;

/**
 * 2021.01.06 ��
 * @author bnj
 * ���� 11720�� ������ ��
 * N���� ���ڰ� ���� ���� �����ִ�. �� ���ڸ� ��� ���ؼ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����. ��° �ٿ� ���� N���� ������� �־�����.
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
