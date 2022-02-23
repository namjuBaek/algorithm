package sorting;

/**
 * 2022.02.23 ��
 * @author bnj
 * ���� N11651�� ��ǥ �����ϱ� 2
 * 
 * 2���� ��� ���� �� N���� �־�����. ��ǥ�� y��ǥ�� �����ϴ� ������, y��ǥ�� ������ x��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N (1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� i������ ��ġ xi�� yi�� �־�����. 
 * (-100,000 �� xi, yi �� 100,000) ��ǥ�� �׻� �����̰�, ��ġ�� ���� �� ���� ����.
 * 
 * ù° �ٺ��� N���� �ٿ� ���� ������ ����� ����Ѵ�.
 * 
 * ----comment----
 * ��ǥ �����ϱ� 1 �ڵ忡�� x, y ���� ������ �ٲ��־���.
 * ��ǥ �����ϱ� 1 (x��ǥ - �������, y��ǥ - ��������) 
 * ��ǥ �����ϱ� 2 (y��ǥ - �������, x��ǥ - ��������)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11651 {
	
	static int[][] sortCoord;
	static int[] tmp;
	static int x = 0, y = 1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] coord = new int[N][2];
		sortCoord = new int[N][2];
		tmp = new int[N];
		
		int max = -100001;
		int min = 100001;
		for (int i = 0; i < N; i++) {
			String coordData = br.readLine();
			coord[i][x] = Integer.parseInt(coordData.split(" ")[x]);
			coord[i][y] = Integer.parseInt(coordData.split(" ")[y]);
			
			if (coord[i][y] > max) {
				max = coord[i][y];
			}
			if (coord[i][y] < min) {
				min = coord[i][y];
			}
		}
		
		/* ��� ���� - y ��ǥ ����*/
		//ī���� �迭 ����
		int[] countArr = new int[max-min+1];
		for (int i = 0; i < N; i++) {
			countArr[coord[i][y] - min]++;
		}
		
		//���� ��ҵ��� �� ��ġ��
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i-1];
		}
		
		//��� ���� - �Է� �迭�� �������� ��ҵ��� ä��
		for (int i = N-1; i >= 0; i--) {	
			sortCoord[countArr[coord[i][y] - min] - 1][x] = coord[i][x];
			sortCoord[countArr[coord[i][y] - min] - 1][y] = coord[i][y];	
			countArr[coord[i][y] - min]--;
		}
		
		// x ��ǥ ��������
		int start = 0;
		for (int i = 1; i < N; i++) {
			if (sortCoord[i-1][y] != sortCoord[i][y]) {
				mergeSort(sortCoord, start, i-1);
				start = i;
			}
		}
		
		mergeSort(sortCoord, start, N-1);
		
	
		// ��ǥ ���� ��� ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(sortCoord[i][x] + " " + sortCoord[i][y] + "\n");
		}
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}
	
	//�迭 �����ϸ� ����
	public static void merge(int[][] arr, int start, int end, int mid) {
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while (i <= mid && j <= end) {
			if (arr[i][x] < arr[j][x]) {
				tmp[k] = arr[i][x];
				i++;
			} else {
				tmp[k] = arr[j][x];
				j++;
			}
			k++;
		}
		//���� ������ ����
		if (i > mid) {
			for (int f = j; f <= end; f++) {
				tmp[k] = arr[f][x];
				k++;
			}
		} else {
			for (int f = i; f <= mid; f++) {
				tmp[k] = arr[f][x];
				k++;
			}
		}
		
		//�迭 ����
		for (int f = start; f <= end; f++) {
			arr[f][x] = tmp[f];
		}
	}
	
	//���� �� ����
	public static void mergeSort(int[][] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, end, mid);	
		}
	}
}
