package basic;

import java.util.Scanner;

/**
 * 2021.01.04 ȭ
 * @author bnj
 * ���� 4344��
 * ù° �ٿ��� �׽�Ʈ ���̽��� ���� C�� �־�����.
 * ��° �ٺ��� �� �׽�Ʈ ���̽����� �л��� �� N(1 �� N �� 1000, N�� ����)�� ù ���� �־�����, �̾ N���� ������ �־�����. ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.
 * �� ���̽����� �� �پ� ����� �Ѵ� �л����� ������ �ݿø��Ͽ� �Ҽ��� ��° �ڸ����� ����Ѵ�.
 */

public class N4344 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		int studentCount = 0;
		
		int[] score;
		int sum = 0, avg = 0, topStudent = 0;
		double[] percent = null;
		
		count = scan.nextInt();
		percent = new double[count];
		
		for (int i = 0; i < count; i++) {
			//���̽� �� �л� �� �Է�
			studentCount = scan.nextInt();
			score = new int[studentCount];
			
			//���̽� �� �л� ���� �Է�
			sum = 0;
			for (int j = 0; j < studentCount; j++) {
				score[j] = scan.nextInt();
				
				sum += score[j];
			}
			
			//����� �Ѵ� �л����� ���� ���
			avg = sum / studentCount;
			
			topStudent = 0;
			for (int j = 0; j < studentCount; j++) {
				if (score[j] > avg) {
					topStudent++;
				}
			}
			
			percent[i] = ((double) topStudent / studentCount) * 100;
		}

		for (int i = 0; i < count; i++) {
			System.out.println(String.format("%.3f", percent[i]) + "%");
		}
	}

}
