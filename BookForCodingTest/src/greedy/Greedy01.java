package greedy;

/**
 * 2022.03.01 ȭ
 * @author bnj
 * [�̰��� ����� ���� �ڵ� �׽�Ʈ��] ����
 * 
 * <ū ���� ��Ģ>
 * �پ��� ���� �̷���� �迭�� ���� �� �־��� ������ M�� ���Ͽ� ���� ū ���� ������ �Ѵ�.
 * ��, �迭�� Ư���� �ε����� �ش��ϴ� ���� �����ؼ� K���� �ʰ��Ͽ� ������ �� ���� ���� �� ��Ģ�� Ư¡�̴�.
 * ���� �ٸ� �ε����� �ش��ϴ� ���� ���� ��쿡�� ���� �ٸ� ������ �����Ѵ�. -> 3, 4, 3 ,4, 3 �迭�� �־����� M�� 5, K�� 2�� �� 4(1idx) + 4(1idx) + 4(3idx) + 4(3idx) + 4(1idx) = 28�� �����ϴ�.
 * 
 * K�� �׻� M���� �۰ų� ����.
 * 
 * ----comment----
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy01 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer inputCount = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(inputCount.nextToken());
		int M = Integer.parseInt(inputCount.nextToken());	// ���ڰ� �������� Ƚ��
		int K = Integer.parseInt(inputCount.nextToken());	// �������� ���Ҽ� �ִ� Ƚ��
				
		StringTokenizer inputNumber = new StringTokenizer(br.readLine()); 
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputNumber.nextToken());
		}
		
		Arrays.sort(arr);
			
		int result = 0;
		for (int i = 0; i < M; i++) {
			if ((i+1) / K == 0) {
				result += arr[N-2];
			} else {
				result += arr[N-1];	
			}			
		}
		
		System.out.println(result);
	}

}
