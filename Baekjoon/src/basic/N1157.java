package basic;

/**
 * 2021.01.07 금
 * @author bnj
 * 백준 N1157번 단어 공부
 * 
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */

import java.util.Scanner;
import java.util.Arrays;

public class N1157 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		char maxChr = '\u0000';
		int maxCount = 0;
		String checkStr = "";
		
		String str = scan.next();
		str = str.toLowerCase();
		
		for (int i=0; i<str.length(); i++) {
			String chr = str.substring(i, i+1);
			
			if (checkStr.contains(chr)) continue;
			
			int count = countChar(str, chr);
			checkStr += chr;
			
			if (count > maxCount) {
				maxCount = count;
				maxChr = str.charAt(i);
			} else if (count == maxCount) {
				maxChr = '?';
			}
		}
		
		System.out.println(maxChr);
	}

	static int countChar(String str, String chr) {
		return str.length() - str.replace(chr, "").length();
	}
}
