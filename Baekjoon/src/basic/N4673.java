package basic;

/**
 * 2022.01.04 화
 * @author bnj
 * 백준 4673번
 * 
 * 양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다. 
 * 예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 이런식으로 다음과 같은 수열을 만들 수 있다.
 * 33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
 * n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다.
 * 생성자가 없는 숫자를 셀프 넘버라고 한다
 * 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 */

import java.util.Arrays;

public class N4673 {

	public static void main(String[] args) {
		
		boolean[] selfCheck = new boolean[10001];
		Arrays.fill(selfCheck, true);
		
		for (int i=1; i<=selfCheck.length; i++) {
			int num = sum(i);
			
			if (num > 10000) continue;
			
			selfCheck[num] = false;	//생성자가 있는 숫자 체크
		}
		
		for (int i=1; i<selfCheck.length; i++) {
			if (selfCheck[i]) {
				System.out.println(i);
			}
		}
	}
	
	//주어진 숫자의 각 자릿수를 합쳐 리턴하는 함수
	static int sum(int num) {
		int result = num;
		
		while (num != 0){
            result += num % 10;
            num /= 10;
        }
		
		return result;
	}
}
