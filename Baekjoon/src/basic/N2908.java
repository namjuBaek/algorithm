package basic;

/**
 * 2022.01.08 ��
 * @author bnj
 * ���� N2908�� ���
 * 
 * ������� ���� ����� ������ ���� ���Ѵ�. ����� ���ڸ� �дµ� ������ �ִ�. �̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���. 
 * ����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
 * ����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, ����� �� ���� 437�� 398�� �д´�. ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.
 * �� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �� ���� ���� ���� �� �ڸ� ���̸�, 0�� ���ԵǾ� ���� �ʴ�.
 */

import java.util.Scanner;

public class N2908 {

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
