package greedy;

/**
 * 2022.03.01 화
 * @author bnj
 * [이것이 취업을 위한 코딩 테스트다] 교재
 * 
 * <큰 수의 법칙>
 * 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만들어야 한다.
 * 단, 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징이다.
 * 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다. -> 3, 4, 3 ,4, 3 배열이 주어지고 M이 5, K가 2일 때 4(1idx) + 4(1idx) + 4(3idx) + 4(3idx) + 4(1idx) = 28이 가능하다.
 * 
 * K는 항상 M보다 작거나 같다.
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
		int M = Integer.parseInt(inputCount.nextToken());	// 숫자가 더해지는 횟수
		int K = Integer.parseInt(inputCount.nextToken());	// 연속으로 더할수 있는 횟수
				
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
