package basic;

/**
 * 2021.01.08 ��
 * @author bnj
 * ���� N1152�� �ܾ��� ����
 * 
 * ���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����. �� ���ڿ����� �� ���� �ܾ ������? �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.
 * �ܾ�� ���� �� ���� ���еǸ�, ������ �����ؼ� ������ ���� ����. ���� ���ڿ��� �������� �����ϰų� ���� �� �ִ�.
 * 
 * ���ǻ��� : ���鸸 �־����� ��찡 ������.
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
