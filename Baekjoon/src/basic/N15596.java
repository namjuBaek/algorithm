package basic;


/**
 * 2021.01.04 ȭ
 * @author bnj
 * ���� 15596��
 * ���� n���� �־����� ��, n���� ���� ���ϴ� �Լ��� �ۼ��Ͻÿ�.
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
