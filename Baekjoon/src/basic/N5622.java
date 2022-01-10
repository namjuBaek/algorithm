package basic;

/**
 * 2022.01.08 ��
 * @author bnj
 * ���� N5622�� ���̾�
 * 
 * ��ȭ�� �ɰ� ���� ��ȣ�� �ִٸ�, ���ڸ� �ϳ��� ���� ������ �ݼ� ���� �ִ� �� ���� �ð�������� ������ �Ѵ�. 
 * ���ڸ� �ϳ� ������ ���̾��� ó�� ��ġ�� ���ư���, ���� ���ڸ� �������� ���̾��� ó�� ��ġ���� �ٽ� ������ �Ѵ�.
 * ���� 1�� �ɷ��� �� 2�ʰ� �ʿ��ϴ�. 1���� ū ���� �Ŵµ� �ɸ��� �ð��� �̺��� �� �ɸ���, �� ĭ ���� �ִ� ���ڸ� �ɱ� ���ؼ� 1�ʾ� �� �ɸ���.
 * ������� �ҸӴϴ� ��ȭ ��ȣ�� �� ���ڿ� �ش��ϴ� ���ڷ� �ܿ��. ��, � �ܾ �� ��, �� ���ĺ��� �ش��ϴ� ���ڸ� �ɸ� �ȴ�. ���� ���, UNUCIC�� 868242�� ����.
 * �ҸӴϰ� �ܿ� �ܾ �־����� ��, �� ��ȭ�� �ɱ� ���ؼ� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

import java.util.Scanner;

public class N5622 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int time = 0;
		String str = scan.next();
		
		for(char chr : str.toCharArray()) {
			time += getNumberTime(chr);
		}
		
		System.out.println(time);				
	}
	
	static int getNumberTime(char chr) {
		int	time = 0;
		
		switch (chr) {
			case 'A':
			case 'B':
			case 'C':
				time = 3;
				break;
			case 'D':
			case 'E':
			case 'F':
				time = 4;
				break;
			case 'G':
			case 'H':
			case 'I':
				time = 5;
				break;
			case 'J':
			case 'K':
			case 'L':
				time = 6;
				break;
			case 'M':
			case 'N':
			case 'O':
				time = 7;
				break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				time = 8;
				break;
			case 'T':
			case 'U':
			case 'V':
				time = 9;
				break;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				time = 10;
				break;
		}
		
		return time;
	}
}
