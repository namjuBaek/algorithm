package sorting;

/**
 * 2022.02.10 목
 * @author bnj
 * 백준 N10989번 수 정렬하기3_계수 정렬 사용
 * 
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
 * 
 * 시간복잡도가 O(n) - 계수 정렬
 * 
 * ----comment----
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N10989 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int max = 0;
		int count = Integer.parseInt(br.readLine());
		int[] data = new int[count];
		int[] sort = new int[count];
				
		for (int i = 0; i < count; i++) {
			data[i] = Integer.parseInt(br.readLine());
			if (max < data[i]) {
				max = data[i];
			}
		}
		
		//카운팅 배열 세팅
		int[] countArr = new int[max];	//1부터 시작
		for (int i = 0; i < count; i++) {
			countArr[data[i]-1]++;
		}
		
		//직전 요소들의 값 합치기
		for (int i = 1; i < max; i++) {
			countArr[i] += countArr[i-1];
		}
		
		
		//계수 정렬 - 입력 배열의 역순으로 요소들을 채움
		for (int i = count-1; i >= 0; i--) {
			sort[countArr[data[i]-1]-1] = data[i];
			countArr[data[i]-1]--;
		}
		
		
		//정렬된 배열 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		for (int num : sort) {
			bw.write(num+"\n");   //버퍼에 있는 값 전부 출력
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
}
