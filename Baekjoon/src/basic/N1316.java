package basic;

/**
 * 2022.01.09 일
 * @author bnj
 * 백준 N1316번 그룹 단어 체커
 * 
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 
 * 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 */

import java.util.Scanner; 
import java.util.HashSet;

public class N1316 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int groupCount = 0;
		int count = scan.nextInt();
		String[] str = new String[count];
		
		//개수만큼 단어 입력받기
		for (int i=0; i<count; i++) {
			str[i] = scan.next();
		}
		
		
		HashSet<String> checkStr = new HashSet<>();	//등장한 알파벳
		char beforeChr = '\u0000';	//직전 문자
		boolean isGroup = true;	//그룹단어 여부
		
		//케이스 별 반복
		for (int i=0; i<count; i++) {
			isGroup = true;
			checkStr.clear();
			
			//그룹단어 체크
			for (char chr : str[i].toCharArray()) {
				if (chr != beforeChr && checkStr.contains(String.valueOf(chr))) {
					isGroup = false;
					break;
				}
				
				beforeChr = chr;
				checkStr.add(String.valueOf(chr));
			}
			
			if (isGroup) {
				groupCount++;
			}
		}
		
		System.out.println(groupCount);
	}
}
