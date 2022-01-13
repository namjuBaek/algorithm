package bruteforce;

/**
 * 2022.01.12 수
 * @author bnj
 * 백준 N7568번 덩치
 * 
 * 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다. 어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
 * 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다. 
 * N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다. 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다. 
 * 이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다. 아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.
 * 
 * 이름	(몸무게, 키)	덩치 등수
 * A	(55, 185)	2
 * B	(58, 183)	2
 * C	(88, 186)	1
 * D	(60, 175)	2
 * E	(46, 155)	5
 * 
 * 위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다. 
 * 그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다. 
 * 그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다. 
 * 위 경우에 3등과 4등은 존재하지 않는다. 
 * 여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.
 * 
 * 첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다
 */

import java.util.Scanner;
import java.util.HashMap;

public class N7568 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int person = scan.nextInt();
		HashMap<Integer, Integer[]> data = new HashMap<Integer, Integer[]>();
		
		int[] ranks = new int[person]; //순위 저장 배열
		
		//전체 사람 키와 몸무게 입력
		for (int i=0; i<person; i++) {
			Integer[] bulk = new Integer[2];	//for 바깥에 선언 시 data에 모두 동일한 bulk 배열이 들어감
			
			bulk[0] = scan.nextInt();
			bulk[1] = scan.nextInt();
			
			data.put(i, bulk);
		}
		
		
		int count = 0;
		for (int i=0; i<data.size(); i++) {
			for (int j=0; j<data.size(); j++) {
				if (i == j) continue;
				
				Integer[] bulk1 = data.get(i);
				Integer[] bulk2 = data.get(j);
				
				// 덩치 비교
				if (bulk1[0] < bulk2[0] && bulk1[1] < bulk2[1]) {
					count++;
				}
			}
			ranks[i] = count + 1;
			count = 0;
		}
		
		for (int rank : ranks) {
			System.out.println(rank);
		}
	}
}
