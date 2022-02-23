package sorting;

/**
 * 2022.02.23 수
 * @author bnj
 * 백준 N1181번 단어 정렬
 * 
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 * 
 * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
 * 주어지는 문자열의 길이는 50을 넘지 않는다.
 * 
 * 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 * 
 * ----comment----
 * Collections.sort comparator에 대해 학습하고 이를 활용해서 정렬을 해보았다.
 * 이전에 풀었던 좌표 정렬하기 문제도 Arrays.sort comparator를 사용해서 풀면 훨씬 코드를 개선할 수 있을 것 같다.
 * Collections.sort는 Arraylist용
 * Arrays.sort는 Array용
 * 
 * 추후에 Comparable과 Comparator의 차이에 대해서도 확실하게 개념정리를 해야겠다. 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class N1181 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> words = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}
		
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				// 길이가 같으면
				if (o1.length() == o2.length()) {
					// 알파벳 순서 비교 
					return o1.compareTo(o2);
						
				} else {
					return o1.length() - o2.length();
				}
			}	
		});
		
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(words.get(0) + "\n");
		for (int i = 1; i < words.size(); i++) {
			if (!words.get(i-1).equals(words.get(i))) {
				bw.write(words.get(i) + "\n");	
			}
		}
		bw.flush();
		bw.close();
		
		
	}
}
