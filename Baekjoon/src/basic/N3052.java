package basic;

import java.util.Scanner;
import java.util.HashSet;

/**
 * @author bnj
 * ���� 3052��
 * �� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���Ѵ�. �� ���� ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷�
 * 
 */

public class N3052 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num[] = new int[10];
		
		HashSet<Integer> hashSet = new HashSet<>();

		for (int i=0; i<10; i++) {
			num[i] = scan.nextInt();
			
			hashSet.add(num[i] % 42);
		}
		
		System.out.println(hashSet.size());
	}

}
