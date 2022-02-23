package sorting;

/**
 * 2022.02.23 수
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
 * 좌표 정렬하기 1 (x좌표 - 계수정렬, y좌표 - 병합정렬) 
 * 좌표 정렬하기 2 (y좌표 - 계수정렬, x좌표 - 병합정렬)
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
		
		/* 계수 정렬 - y 좌표 정렬*/
		//카운팅 배열 세팅
		int[] countArr = new int[max-min+1];
		for (int i = 0; i < N; i++) {
			countArr[coord[i][y] - min]++;
		}
		
		//직전 요소들의 값 합치기
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i-1];
		}
		
		//계수 정렬 - 입력 배열의 역순으로 요소들을 채움
		for (int i = N-1; i >= 0; i--) {	
			sortCoord[countArr[coord[i][y] - min] - 1][x] = coord[i][x];
			sortCoord[countArr[coord[i][y] - min] - 1][y] = coord[i][y];	
			countArr[coord[i][y] - min]--;
		}
		
		// x 좌표 병합정렬
		int start = 0;
		for (int i = 1; i < N; i++) {
			if (sortCoord[i-1][y] != sortCoord[i][y]) {
				mergeSort(sortCoord, start, i-1);
				start = i;
			}
		}
		
		mergeSort(sortCoord, start, N-1);
		
	
		// 좌표 정렬 결과 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(sortCoord[i][x] + " " + sortCoord[i][y] + "\n");
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
	
	//배열 정렬하며 병합
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
		//남은 데이터 삽입
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
		
		//배열 정렬
		for (int f = start; f <= end; f++) {
			arr[f][x] = tmp[f];
		}
	}
	
	//분할 후 병합
	public static void mergeSort(int[][] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, end, mid);	
		}
	}
}
