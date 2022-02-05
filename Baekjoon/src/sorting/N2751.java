package sorting;

/**
 * 2022.01.15 ��
 * @author bnj
 * ���� N2751�� �� �����ϱ�
 * 
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� �� �־�����. �� ���� ������ 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
 * ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 * �ð����⵵�� O(nlogn) - ��������, �� ���� or ���� ���� �Լ� ���
 * 
 * ----comment----
 * �������� 1
 * ���������� ����� ����Ǯ�̸� �����ߴµ� �ð� �ʰ��� ����.
 * ���� Ŀ�´�Ƽ�� ������ ������ ���� ����� ������ ���� �־� �о��
 * ����� System.out.println()���� �ؼ� ���� ��������.
 * BufferedWriter�� ����ؼ� �����ϴ� ���������� ����Ǿ���.
 * BufferedReader�� BufferedWriter�� ���ؼ��� ���� �� �� ������߰ڴ�.
 */

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class N2751 {

	static int[] sort;
	static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		sort = new int[count];
		tmp = new int[count];	//���Ŀ� �迭
		
		for (int i = 0; i < count; i++) {
			sort[i] = scan.nextInt();
		}
		
		//���� ����
		mergeSort(sort, 0, count - 1);
		
		//���ĵ� �迭 ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //�Ҵ�� ���ۿ� �� �־��ֱ�
		for (int num : sort) {
			bw.write(num+"\n");   //���ۿ� �ִ� �� ���� ���
		}
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}
	
	//�迭 �����ϸ� ����
	public static void merge(int[] arr, int start, int end, int mid) {
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				tmp[k] = arr[i];
				i++;
			} else {
				tmp[k] = arr[j];
				j++;
			}
			k++;
		}
		//���� ������ ����
		if (i > mid) {
			for (int f = j; f <= end; f++) {
				tmp[k] = arr[f];
				k++;
			}
		} else {
			for (int f = i; f <= mid; f++) {
				tmp[k] = arr[f];
				k++;
			}
		}
		
		//�迭 ����
		for (int f = start; f <= end; f++) {
			arr[f] = tmp[f];
		}
	}
	
	//���� �� ����
	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, end, mid);	
		}
	}
}
