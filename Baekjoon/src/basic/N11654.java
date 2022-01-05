package basic;

/**
 * 2021.01.06 수
 * @author bnj
 * 백준 11654번 아스키 코드
 * 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
 * 
 */

import java.util.Scanner;

public class N11654 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		char chr = scan.next().charAt(0);
		
		System.out.println((int) chr);
	}

}
