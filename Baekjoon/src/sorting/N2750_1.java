package sorting;

/**
 * 2022.01.24 ��
 * @author bnj
 * ���� N2750�� �� �����ϱ� _ �������� ����
 * 
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� �� �־�����. �� ���� ������ 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
 * ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 * �ð����⵵�� O(n^2) - ���� ����, ���� ����, ���� ����
 */

import java.util.Scanner;

public class N2750_1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		int[] sort = new int[count];
		
		for (int i=0; i<count; i++) {
			sort[i] = scan.nextInt();
		}
		
		//���� ����
		int temp = 0, minIndex = 0;
		for (int i=1; i<sort.length; i++) {
			for (int j=i; j>0; j--) {
				if (sort[j] < sort[j-1]) {
					temp = sort[j];
					sort[j] = sort[j-1];
					sort[j-1] = temp;
				} else {
					break;
				}
			}
		}
		
		for (int num : sort) {
			System.out.println(num);
		}
	}
}
