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
 * 02.22 
 * - y좌표를 선택정렬하기 때문에 시간초과 -> 정렬방법 바꿔야 함 
 * 
 * - 먼저 x좌표를 정렬한 후 x값 별로 y좌표를 정렬하는 방식으로 풀었다.
 * - x좌표는 계수정렬로 정렬했고, x값 별 y좌표는 퀵 정렬을 사용하여 풀어 제출하니 통과되었다.
 * - x와 y값을 한꺼번에 정렬할 수 있는 방법이 있을까? 좀 더 고민해봐야 할 것 같다.
 * - 또 계수정렬을 사용하니 확실히 메모리를 많이 잡아먹는다..
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11650 {
	
	static int[][] sortCoord;
	static int[] tmp;

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
		int[] countArr = new int[max-min+1];
		for (int i = 0; i < N; i++) {
			countArr[coord[i][0] - min]++;
		}
		
		//직전 요소들의 값 합치기
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i-1];
		}
		
		//계수 정렬 - 입력 배열의 역순으로 요소들을 채움
		for (int i = N-1; i >= 0; i--) {
			sortCoord[countArr[coord[i][0] - min] - 1][0] = coord[i][0];
			sortCoord[countArr[coord[i][0] - min] - 1][1] = coord[i][1];		
			countArr[coord[i][0] - min]--;
		}
		
		// y 좌표 퀵정렬
		int start = 0;
		for (int i = 1; i < N; i++) {
			if (sortCoord[i-1][0] != sortCoord[i][0]) {
				//sortCoordY(start, i); - 선택정렬
				mergeSort(sortCoord, start, i-1);
				start = i;
			}
		}
		

		//sortCoordY(start, N); - 선택정렬
		mergeSort(sortCoord, start, N-1);
		
	
		// 좌표 정렬 결과 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(sortCoord[i][0] + " " + sortCoord[i][1] + "\n");
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}

	// Y좌표 정렬 메서드 - 선택정렬
	static public void sortCoordY(int start, int end) {
		int temp = 0;
		
		for (int j = start; j < end-1; j++) {
			for (int k = j+1; k < end; k++) {
				if (sortCoord[j][1] > sortCoord[k][1]) {
					temp = sortCoord[j][1];
					sortCoord[j][1] = sortCoord[k][1];
					sortCoord[k][1] = temp; 
				}
			}
		}
	}
	
	//배열 정렬하며 병합
	public static void merge(int[][] arr, int start, int end, int mid) {
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while (i <= mid && j <= end) {
			if (arr[i][1] < arr[j][1]) {
				tmp[k] = arr[i][1];
				i++;
			} else {
				tmp[k] = arr[j][1];
				j++;
			}
			k++;
		}
		//남은 데이터 삽입
		if (i > mid) {
			for (int f = j; f <= end; f++) {
				tmp[k] = arr[f][1];
				k++;
			}
		} else {
			for (int f = i; f <= mid; f++) {
				tmp[k] = arr[f][1];
				k++;
			}
		}
		
		//배열 정렬
		for (int f = start; f <= end; f++) {
			arr[f][1] = tmp[f];
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
