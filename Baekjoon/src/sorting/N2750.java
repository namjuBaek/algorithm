package sorting;

/**
 * 2022.01.15 ��
 * @author bnj
 * ���� N2750�� �� �����ϱ�
 * 
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� �� �־�����. �� ���� ������ 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
 * ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 */

import java.util.Scanner;

public class N2750 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		int[] sort = new int[count];
		
		for (int i=0; i<count; i++) {
			sort[i] = scan.nextInt();
		}
		
		int temp;
		for (int i=0; i<count; i++) {
			for (int j=i+1; j<count; j++) {
				if (sort[i] > sort[j]) {
					temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}
			}
		}
		//�޼��� �̿��� - ó�� �ð��� �����
		//import java.util.Arrays
		//Arrays.sort(sort); - ��������
		//Arrays.sort(sort, Collections.reverseOrder()); - ��������
		
		for (int num : sort) {
			System.out.println(num);
		}
	}
}
