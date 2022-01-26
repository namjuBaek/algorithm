package sorting;

/**
 * 2022.01.24 월
 * @author bnj
 * 백준 N2750번 수 정렬하기 _ 버블정렬 버전
 * 
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * 시간복잡도가 O(n^2) - 선택 정렬, 삽입 정렬, 버블 정렬
 */

import java.util.Scanner;

public class N2750_2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		int[] sort = new int[count];
		
		for (int i=0; i<count; i++) {
			sort[i] = scan.nextInt();
		}
		
		//버블 정렬
		int temp = 0;
		for (int i=0; i<sort.length-1; i++) {
			for (int j=0; j<sort.length-(i+1); j++) {
				if (sort[j] > sort[j+1]) {
					temp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = temp;
				}
			}
		}
		
		for (int num : sort) {
			System.out.println(num);
		}
	}
}
