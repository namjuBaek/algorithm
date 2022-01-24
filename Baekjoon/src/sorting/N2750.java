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
 * �ð����⵵�� O(n^2) - ���� ����, ���� ����, ���� ����
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
		
		//���� ����
		int temp = 0, minIndex = 0;
		for (int i=0; i<count-1; i++) {
			minIndex = i;
			for (int j=i+1; j<count; j++) {
				if (sort[j] < sort[minIndex]) {
					minIndex = j;
				}
			}
			
			temp = sort[minIndex];
			sort[minIndex] = sort[i];
			sort[i] = temp;
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