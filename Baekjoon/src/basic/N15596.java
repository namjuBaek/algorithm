package basic;


/**
 * 2021.01.04 화
 * @author bnj
 * 백준 15596번
 * 정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.
 */

public class N15596 {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4 ,5};
		
		System.out.println(sum(a));
	}
	
	static long sum(int[] a) {
		long sum = 0; 
		for (int num : a) { 
			sum += num; 
		}
		
		return sum;		
	}

}
