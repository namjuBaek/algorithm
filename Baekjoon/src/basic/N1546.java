package basic;

import java.util.Scanner;

/**
 * @author bnj
 * ���� 1546��
 * �����̴� �⸻��縦 ���ƴ�. �����̴� ������ �����ؼ� ���� ��������� �ߴ�. �ϴ� �����̴� �ڱ� ���� �߿� �ִ��� �����. �� ���� M�̶�� �Ѵ�. �׸��� ���� ��� ������ ����/M*100���� ���ƴ�.
 * ���� ���, �������� �ְ����� 70�̰�, ���������� 50�̾����� ���������� 50/70*100�� �Ǿ� 71.43���� �ȴ�.
 * �������� ������ ���� ������ ���� ������� ��, ���ο� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 */

public class N1546 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		double grade[];
		
		double M = 0;
		double sum = 0;
		
		count = scan.nextInt();
		grade = new double[count];
		
		for (int i = 0; i < count; i++) {
			grade[i] = scan.nextInt();
			
			if (grade[i] > M) {
				M = grade[i];
			}
		}
		
		for (int i = 0; i < count; i++) {
			sum += grade[i] / M * 100;
		}
		
		System.out.println((double) sum / count);
	}

}
