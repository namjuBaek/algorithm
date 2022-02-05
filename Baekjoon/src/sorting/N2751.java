package sorting;

/**
 * 2022.01.15 토
 * @author bnj
 * 백준 N2751번 수 정렬하기
 * 
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * 시간복잡도가 O(nlogn) - 병합정렬, 힙 정렬 or 내장 정렬 함수 사용
 * 
 * ----comment----
 * 시행착오 1
 * 병합정렬을 사용한 문제풀이를 제출했는데 시간 초과가 떴다.
 * 백준 커뮤니티에 동일한 문제를 겪은 사람이 질문한 글이 있어 읽어보니
 * 출력을 System.out.println()으로 해서 생긴 문제였다.
 * BufferedWriter를 사용해서 제출하니 성공적으로 통과되었다.
 * BufferedReader와 BufferedWriter에 관해서도 언제 한 번 살펴봐야겠다.
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
		tmp = new int[count];	//정렬용 배열
		
		for (int i = 0; i < count; i++) {
			sort[i] = scan.nextInt();
		}
		
		//병합 정렬
		mergeSort(sort, 0, count - 1);
		
		//정렬된 배열 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		for (int num : sort) {
			bw.write(num+"\n");   //버퍼에 있는 값 전부 출력
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
	
	//배열 정렬하며 병합
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
		//남은 데이터 삽입
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
		
		//배열 정렬
		for (int f = start; f <= end; f++) {
			arr[f] = tmp[f];
		}
	}
	
	//분할 후 병합
	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, end, mid);	
		}
	}
}
