package basic;

/**
 * 2021.01.08 토
 * @author bnj
 * 백준 N1152번 단어의 개수
 * 
 * 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
 * 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.
 * 
 * 주의사항 : 공백만 주어지는 경우가 존재함.
 */

import java.util.Scanner;

public class N1152 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		str = str.strip();
		if (str.length() == 0) {
			System.out.println(0);	
		} else {
			System.out.println(str.split(" ").length);
		}
		
	}
}
