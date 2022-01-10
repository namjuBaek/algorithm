package basic;

/**
 * 2022.01.04 ȭ
 * @author bnj
 * ���� 4673��
 * 
 * ���� ���� n�� �־����� ��, �� ���� �����ؼ� n, d(n), d(d(n)), d(d(d(n))), ...�� ���� ���� ������ ���� �� �ִ�. 
 * ���� ���, 33���� �����Ѵٸ� ���� ���� 33 + 3 + 3 = 39�̰�, �� ���� ���� 39 + 3 + 9 = 51, ���� ���� 51 + 5 + 1 = 57�̴�. �̷������� ������ ���� ������ ���� �� �ִ�.
 * 33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
 * n�� d(n)�� �����ڶ�� �Ѵ�. ���� �������� 33�� 39�� �������̰�, 39�� 51�� ������, 51�� 57�� �������̴�. �����ڰ� �� ������ ���� ��쵵 �ִ�. ���� ���, 101�� �����ڰ� 2��(91�� 100) �ִ�.
 * �����ڰ� ���� ���ڸ� ���� �ѹ���� �Ѵ�
 * 10000���� �۰ų� ���� ���� �ѹ��� �� �ٿ� �ϳ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

import java.util.Arrays;

public class N4673 {

	public static void main(String[] args) {
		
		boolean[] selfCheck = new boolean[10001];
		Arrays.fill(selfCheck, true);
		
		for (int i=1; i<=selfCheck.length; i++) {
			int num = sum(i);
			
			if (num > 10000) continue;
			
			selfCheck[num] = false;	//�����ڰ� �ִ� ���� üũ
		}
		
		for (int i=1; i<selfCheck.length; i++) {
			if (selfCheck[i]) {
				System.out.println(i);
			}
		}
	}
	
	//�־��� ������ �� �ڸ����� ���� �����ϴ� �Լ�
	static int sum(int num) {
		int result = num;
		
		while (num != 0){
            result += num % 10;
            num /= 10;
        }
		
		return result;
	}
}
