package sorting;

/**
 * 2022.02.24 목
 * @author bnj
 * 백준 N11651번 좌표 정렬하기 2
 * 
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. 
 * (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * 
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 * 
 * ----comment----
 * 좌표 정렬하기 1 코드에서 x, y 정렬 순서만 바꿔주었다.
 * Arrays sort의 Comparator를 사용하여 정렬
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
	
		// 좌표 정렬 결과 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(coord[i][x] + " " + coord[i][y] + "\n");
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
}
