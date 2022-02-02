package sorting;

/**
 * 2022.02.02 수
 * @author bnj
 * 백준 N1427번 소트인사이드
 * 
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 */

import java.util.Scanner;
import java.util.Arrays;

public class N1427 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String num = scan.next();
		char[] sortedArr = num.toCharArray();
		
		Arrays.sort(sortedArr);		
		
		
		for (int i=sortedArr.length-1; i>=0; i--) {
			System.out.print(sortedArr[i]);
		}
	}
}
