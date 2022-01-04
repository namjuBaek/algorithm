package basic;

import java.util.Scanner;
import java.util.HashSet;

/**
 * @author bnj
 * 백준 3052번
 * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램
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
