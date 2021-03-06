package basic;

/**
 * 2022.06.20 월
 * @author bnj
 * 백준 N2920 음계
 * 
 * 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
 * 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class N2920 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		StringBuffer num1 = new StringBuffer();
		StringBuffer num2 = new StringBuffer();
		int maxNum = 0;
				
		num1.append(scan.next());
		num2.append(scan.next());
		
		num1.reverse();
		num2.reverse();
		
			
		if (Integer.parseInt(num1.toString()) > Integer.parseInt(num2.toString())) {
			maxNum = Integer.parseInt(num1.toString());
		} else {
			maxNum = Integer.parseInt(num2.toString());
		}
		
		System.out.println(maxNum);		
	}
}
