package sorting;

/**
 * 2022.02.06 일
 * @author bnj
 * 백준 N2751번 수 정렬하기_퀵 정렬 사용
 * 
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * 시간복잡도가 O(nlogn) - 병합정렬, 힙 정렬 or 내장 정렬 함수 사용
 * 
 * ----comment----
 * 퀵 정렬은 최악의 경우 시간복잡도가 O(n^2)이 될 수 있기 때문에 백준 2751번 문제에 제출했을 때 통과되지 않음.
 *  
 * 
 * Scanner로 입력받아 sort를 사용할 경우, 출력은 BufferedWriter를 쓰던가, StringBuilder를 써서 한번에 출력해줘야 한다.
 * (아니면 시간초과 발생)
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
		
		//퀵 정렬
		quickSort(sort, 0, count - 1);
		
		//정렬된 배열 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		for (int num : sort) {
			bw.write(num+"\n");   //버퍼에 있는 값 전부 출력
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
		
	//퀵 정렬
	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {	//원소가 1개일 때
			return;
		}
		
		int key = start;
		int i = start + 1;
		int j = end;
		int temp;
		
		while (i <= j) {
			while (i <= end && arr[key] >= arr[i]) {	//key보다 큰 값 찾기
				i++;
			}
			while (j > start && arr[key] <= arr[j]) { //key보다 작은 값 찾기
				j--;
			}
			
			if (i > j) {	//엇갈렸으면 key와 j 교환
				temp = arr[key];
				arr[key] = arr[j];
				arr[j] = temp;
			} else {	//엇갈리지 않았으면 i와 j 교환
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		quickSort(arr, start, j-1);		//j값을 기준으로 이전 인덱스 정렬
		quickSort(arr, j+1, end);		//j값을 기준으로 이후 인덱스 정렬
	}
}
