package implementation;

/**
 * 2022.05.18 수
 * @author bnj
 * 백준 1259번 팰린드롬수
 * 각 줄마다 주어진 수가 팰린드롬수면 yes 아니면 no를 출력한다.
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class N1259 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> numArr = new ArrayList<String>();

		String inputNum = scan.next();
		while (!inputNum.equals("0")) {
			numArr.add(inputNum);
			inputNum = scan.next();
		}
		
		for (int i = 0; i < numArr.size(); i++) {
			char[] word = numArr.get(i).toCharArray();
			
			boolean isPalindrome = true;
			int start = 0;
			int end = word.length - 1;
			
			while (start <= end) {
				if (word[start] != word[end]) {
					isPalindrome = false;
					break;
				}
				start++;
				end--;
			}
			
			if (isPalindrome) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}