package basic;

import java.util.Scanner;

/**
 * @author bnj
 * ���� 2577��
 * �� ���� �ڿ��� A, B, C�� �־��� �� A �� B �� C�� ����� ����� 0���� 9���� ������ ���ڰ� �� ���� ���������� ���ϴ� ���α׷�
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
