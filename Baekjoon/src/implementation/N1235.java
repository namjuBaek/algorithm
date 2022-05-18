package implementation;

/**
 * 2022.05.19 목
 * @author bnj
 * 백준 1235번 학생 번호
 * 이번에는 학생들을 더욱 효율적으로 관리하기 위해 학생마다 고유한 학생 번호를 부여하기로 하였다. 
 * 학생 번호는 0부터 9 사이의 숫자로 이루어진 문자열로, 모든 학생들의 학생 번호는 서로 다르지만 그 길이는 모두 같다.
 * 학생들의 번호가 주어 졌을 때, 뒤에서 k자리만을 추려서 남겨 놓았을 때 모든 학생들의 학생 번호를 서로 다르게 만들 수 있는 최소의 k를 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에는 학생의 수 N(2≤N≤1,000)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 학생의 학생 번호가 순서대로 주어진다. 
 * 모든 학생들의 학생 번호는 서로 다르지만 그 길이는 모두 같으며, 0부터 9 사이의 숫자로 이루어진 문자열이 주어진다. 
 * 문자열의 길이는 100보다 작거나 같다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N1235 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		int k = 0;	//학생 번호를 다르게 만들 수 있는 최소 k자리
		
		String[] studentArr = new String[count];
		int len = 0;
		for (int i = 0; i < count; i++) {
			studentArr[i] = br.readLine();
			len = String.valueOf(studentArr[i]).length();
		}
				
		
		int pointer = len;
		boolean isOverlap = true;
		while (isOverlap) {
			isOverlap = false;
			
			pointer--;
			k++;
			
			ArrayList<String> compareNum = new ArrayList<String>();
			for (int i = 0; i < studentArr.length; i++) {
				
				if (compareNum.contains(studentArr[i].substring(pointer, len))) {
					isOverlap = true;
					break;
				} else {
					compareNum.add(studentArr[i].substring(pointer, len));
				}
			}
		}
		
		System.out.println(k);
	}
}