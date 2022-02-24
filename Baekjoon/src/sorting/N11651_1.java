package sorting;

/**
 * 2022.02.24 ��
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
 * Arrays sort�� Comparator�� ����Ͽ� ����
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class N11651_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] coord = new int[N][2];
		int x = 0, y = 1;
		
		for (int i = 0; i < N; i++) {
			String coordData = br.readLine();
			coord[i][x] = Integer.parseInt(coordData.split(" ")[x]);
			coord[i][y] = Integer.parseInt(coordData.split(" ")[y]);
		}
		
		
		Arrays.sort(coord, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
	
		// ��ǥ ���� ��� ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(coord[i][x] + " " + coord[i][y] + "\n");
		}
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}
}
