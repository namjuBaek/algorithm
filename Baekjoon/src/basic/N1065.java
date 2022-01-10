package basic;

/**
 * 2022.01.05 ��
 * @author bnj
 * ���� 1065�� �Ѽ�
 * �Ѽ� : � ���� ���� X�� �� �ڸ��� ���������� �̷�� ��
 * �������� : ���ӵ� �� ���� ���� ���̰� ������ ����
 * N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
