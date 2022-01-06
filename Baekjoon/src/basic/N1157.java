package basic;

/**
 * 2021.01.07 ��
 * @author bnj
 * ���� N1157�� �ܾ� ����
 * 
 * ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�. ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
 * ù° �ٿ� �� �ܾ�� ���� ���� ���� ���ĺ��� �빮�ڷ� ����Ѵ�. ��, ���� ���� ���� ���ĺ��� ���� �� �����ϴ� ��쿡�� ?�� ����Ѵ�.
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
