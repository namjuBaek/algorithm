package sorting;

/**
 * 2022.02.21 ��
 * @author bnj
 * ���� N11650�� ��ǥ �����ϱ�
 * 
 * 2���� ��� ���� �� N���� �־�����. ��ǥ�� x��ǥ�� �����ϴ� ������, x��ǥ�� ������ y��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N (1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� i������ ��ġ xi�� yi�� �־�����. 
 * (-100,000 �� xi, yi �� 100,000) ��ǥ�� �׻� �����̰�, ��ġ�� ���� �� ���� ����.
 * 
 * ù° �ٺ��� N���� �ٿ� ���� ������ ����� ����Ѵ�.
 * 
 * ----comment----
 * 02.21 - ������ �ִٴ� ���� ����ؾ� ��
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11650 {
	
	static int[][] sortCoord;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] coord = new int[N][2];
		sortCoord = new int[N][2];
		
		int max = -100001;
		int min = 100001;
		for (int i = 0; i < N; i++) {
			String coordData = br.readLine();
			coord[i][0] = Integer.parseInt(coordData.split(" ")[0]);
			coord[i][1] = Integer.parseInt(coordData.split(" ")[1]);
			
			if (coord[i][0] > max) {
				max = coord[i][0];
			}
			if (coord[i][0] < min) {
				min = coord[i][0];
			}
		}
		
		/* ��� ���� - x ��ǥ ����*/
		//ī���� �迭 ����
		int[] countArr = new int[Math.abs(min) + Math.abs(max)];	//1���� ����
		for (int i = 0; i < N; i++) {
			countArr[coord[i][0] + (Math.abs(min)+1) - 1]++;
		}
		
		//���� ��ҵ��� �� ��ġ��
		for (int i = 1; i < max; i++) {
			countArr[i] += countArr[i-1];
		}
		
		//��� ���� - �Է� �迭�� �������� ��ҵ��� ä��
		for (int i = N-1; i >= 0; i--) {
			sortCoord[countArr[coord[i][0] - 1] - 1][0] = coord[i][0];
			sortCoord[countArr[coord[i][0] - 1] - 1][1] = coord[i][1];		
			countArr[coord[i][0] - 1]--;
		}
		
		// y ��ǥ ����
		
		int start = 0;
		for (int i = 1; i < N; i++) {
			if (sortCoord[i-1][0] != sortCoord[i][0]) {
				sortCoordY(start, i);
				start = i;
			}
		}
		
		sortCoordY(start, N);
		
	
		// ��ǥ ���� ��� ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(sortCoord[i][0] + " " + sortCoord[i][1] + "\n");
		}
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}

	// Y��ǥ ���� �޼���
	static public void sortCoordY(int start, int end) {
		int temp = 0;
		
		for (int j = start; j < end; j++) {
			for (int k = j+1; k < end; k++) {
				if (sortCoord[j][1] > sortCoord[k][1]) {
					temp = sortCoord[j][1];
					sortCoord[j][1] = sortCoord[k][1];
					sortCoord[k][1] = temp; 
				}
			}
		}
	}
}
