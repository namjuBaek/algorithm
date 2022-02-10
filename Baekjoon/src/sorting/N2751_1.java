package sorting;

/**
 * 2022.02.06 ��
 * @author bnj
 * ���� N2751�� �� �����ϱ�_�� ���� ���
 * 
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� �� �־�����. �� ���� ������ 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
 * ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 * �ð����⵵�� O(nlogn) - ��������, �� ���� or ���� ���� �Լ� ���
 * 
 * ----comment----
 * �� ������ �־��� ��� �ð����⵵�� O(n^2)�� �� �� �ֱ� ������ ���� 2751�� ������ �������� �� ������� ����.
 *  
 * 
 * Scanner�� �Է¹޾� sort�� ����� ���, ����� BufferedWriter�� ������, StringBuilder�� �Ἥ �ѹ��� �������� �Ѵ�.
 * (�ƴϸ� �ð��ʰ� �߻�)
 */

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class N2751_1 {

	static int[] sort;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		sort = new int[count];
		
		for (int i = 0; i < count; i++) {
			sort[i] = scan.nextInt();
		}
		
		//�� ����
		quickSort(sort, 0, count - 1);
		
		//���ĵ� �迭 ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //�Ҵ�� ���ۿ� �� �־��ֱ�
		for (int num : sort) {
			bw.write(num+"\n");   //���ۿ� �ִ� �� ���� ���
		}
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}
		
	//�� ����
	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {	//���Ұ� 1���� ��
			return;
		}
		
		int key = start;
		int i = start + 1;
		int j = end;
		int temp;
		
		while (i <= j) {
			while (i <= end && arr[key] >= arr[i]) {	//key���� ū �� ã��
				i++;
			}
			while (j > start && arr[key] <= arr[j]) { //key���� ���� �� ã��
				j--;
			}
			
			if (i > j) {	//���������� key�� j ��ȯ
				temp = arr[key];
				arr[key] = arr[j];
				arr[j] = temp;
			} else {	//�������� �ʾ����� i�� j ��ȯ
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		quickSort(arr, start, j-1);		//j���� �������� ���� �ε��� ����
		quickSort(arr, j+1, end);		//j���� �������� ���� �ε��� ����
	}
}
