package sorting;

/**
 * 2022.01.15 토
 * @author bnj
 * 백준 N2750번 수 정렬하기
 * 
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 */

import java.util.Scanner;

public class N2750 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		int[] sort = new int[count];
		
		for (int i=0; i<count; i++) {
			sort[i] = scan.nextInt();
		}
		
		int temp;
		for (int i=0; i<count; i++) {
			for (int j=i+1; j<count; j++) {
				if (sort[i] > sort[j]) {
					temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}
			}
		}
		//메서드 이용방법 - 처리 시간은 비슷함
		//import java.util.Arrays
		//Arrays.sort(sort); - 오름차순
		//Arrays.sort(sort, Collections.reverseOrder()); - 내림차순
		
		for (int num : sort) {
			System.out.println(num);
		}
	}
}
