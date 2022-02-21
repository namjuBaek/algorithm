package sorting;

/**
 * 2022.02.21 월
 * @author bnj
 * 백준 N11650번 좌표 정렬하기
 * 
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. 
 * (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * 
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 * 
 * ----comment----
 * 02.21 - 음수가 있다는 점을 고려해야 함
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
		
		/* 계수 정렬 - x 좌표 정렬*/
		//카운팅 배열 세팅
		int[] countArr = new int[Math.abs(min) + Math.abs(max)];	//1부터 시작
		for (int i = 0; i < N; i++) {
			countArr[coord[i][0] + (Math.abs(min)+1) - 1]++;
		}
		
		//직전 요소들의 값 합치기
		for (int i = 1; i < max; i++) {
			countArr[i] += countArr[i-1];
		}
		
		//계수 정렬 - 입력 배열의 역순으로 요소들을 채움
		for (int i = N-1; i >= 0; i--) {
			sortCoord[countArr[coord[i][0] - 1] - 1][0] = coord[i][0];
			sortCoord[countArr[coord[i][0] - 1] - 1][1] = coord[i][1];		
			countArr[coord[i][0] - 1]--;
		}
		
		// y 좌표 정렬
		
		int start = 0;
		for (int i = 1; i < N; i++) {
			if (sortCoord[i-1][0] != sortCoord[i][0]) {
				sortCoordY(start, i);
				start = i;
			}
		}
		
		sortCoordY(start, N);
		
	
		// 좌표 정렬 결과 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(sortCoord[i][0] + " " + sortCoord[i][1] + "\n");
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}

	// Y좌표 정렬 메서드
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
