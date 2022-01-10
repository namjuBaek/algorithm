package basic;

/**
 * 2022.01.10 월
 * @author bnj
 * 백준 N1712번 손익분기점
 * 
 * 육각형으로 이루어진 벌집이 있다. 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 
 * 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 * 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
 */

import java.util.Scanner; 

public class N2292 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int level = 1;	//레벨
		int count = 1;	//레벨별 시작 숫자
		
		int N = scan.nextInt();
		
		while (true) {
			if (N == 1) break;
			if (count < N && N <= count+(6*level)) {
				level++;	//끝 레벨도 포함해야하기 때문
				break;
			}
			count += 6 * level;
			level++;
		}
		
		System.out.println(level);
		
	}
}
