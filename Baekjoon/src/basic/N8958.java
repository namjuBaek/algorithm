package basic;

import java.util.Scanner;

/**
 * 2021.01.04 ȭ
 * @author bnj
 * ���� 8958��
 * OX����
 * "OOXXOXXOOO"�� ���� OX������ ����� �ִ�. O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. ������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. ���� ���, 10�� ������ ������ 3�� �ȴ�.
 * "OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.
 * OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���̰� 0���� ũ�� 80���� ���� ���ڿ��� �־�����. ���ڿ��� O�� X������ �̷���� �ִ�. 
 */

public class N8958 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		String[] strArr;
		int[] sum;
		
		int score = 0;
		
		//�׽�Ʈ ��� �Է¹ޱ�
		count = scan.nextInt();
		strArr = new String[count];
		sum = new int[count];
		
		for (int i = 0; i < count; i++) {
			strArr[i] = scan.next();	
			
			char[] chrArr = new char[strArr[i].length()];
			chrArr = strArr[i].toCharArray();
			/*
			for (int j = 0; j < strArr[i].length(); j++) {
				chrArr[j] = strArr[i].charAt(j);
			}
			*/
						
			//���� ���
			score = 0;
			for (int j = 0; j < chrArr.length; j++) {
				if ('O' == chrArr[j]) {
					score++;
					sum[i] += score;
				} else if (score != 0) {
					score = 0;
				}
			}
		}
		
		//��� ���
		for (int i = 0; i < count; i++) {
			System.out.println(sum[i]);
		}
	}

}
