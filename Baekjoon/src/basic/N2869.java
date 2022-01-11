package basic;

/**
 * 2022.01.11 화
 * @author bnj
 * 백준 N2869번 달팽이는 올라가고 싶다
 * 
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2869 {

	public static void main(String[] args) throws IOException {
		
		//Scanner 사용 시 시간 초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
		String s = br.readLine(); 
		
		StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
		int A = Integer.parseInt(st.nextToken()); 
		int B = Integer.parseInt(st.nextToken()); 
		int V = Integer.parseInt(st.nextToken()); 
		
		if ((V-A) % (A-B) == 0) {
			System.out.println((V-A) / (A-B) + 1);
		} else {
			System.out.println((V-A) / (A-B) + 2);	
		}
	}
}
