package basic;

/**
 * 2022.01.07 ��
 * @author bnj
 * ���� 10809�� ���ĺ� ã��
 * ���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. ������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡�� ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� ���� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 */

import java.util.Scanner;

public class N10809 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] alphabet = new int[26];
		String s = scan.next();
		
		for (int i=0; i<26; i++) {
			alphabet[i] += s.indexOf((char)(i+97));
		}

		for (int count : alphabet) {
			System.out.print(count + " ");
		}
	}
	
}
