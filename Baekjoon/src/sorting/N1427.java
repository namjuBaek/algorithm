package sorting;

/**
 * 2022.02.02 ��
 * @author bnj
 * ���� N1427�� ��Ʈ�λ��̵�
 * 
 * �迭�� �����ϴ� ���� ����. ���� �־�����, �� ���� �� �ڸ����� ������������ �����غ���.
 * ù° �ٿ� �����Ϸ��� �ϴ� �� N�� �־�����. N�� 1,000,000,000���� �۰ų� ���� �ڿ����̴�.
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
