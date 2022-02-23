package sorting;

/**
 * 2022.02.23 ��
 * @author bnj
 * ���� N1181�� �ܾ� ����
 * 
 * ���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 1. ���̰� ª�� �ͺ���
 * 2. ���̰� ������ ���� ������
 * 
 * ù° �ٿ� �ܾ��� ���� N�� �־�����. (1 �� N �� 20,000) ��° �ٺ��� N���� �ٿ� ���� ���ĺ� �ҹ��ڷ� �̷���� �ܾ �� �ٿ� �ϳ��� �־�����. 
 * �־����� ���ڿ��� ���̴� 50�� ���� �ʴ´�.
 * 
 * ���ǿ� ���� �����Ͽ� �ܾ���� ����Ѵ�. ��, ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ����Ѵ�.
 * 
 * ----comment----
 * Collections.sort comparator�� ���� �н��ϰ� �̸� Ȱ���ؼ� ������ �غ��Ҵ�.
 * ������ Ǯ���� ��ǥ �����ϱ� ������ Arrays.sort comparator�� ����ؼ� Ǯ�� �ξ� �ڵ带 ������ �� ���� �� ����.
 * Collections.sort�� Arraylist��
 * Arrays.sort�� Array��
 * 
 * ���Ŀ� Comparable�� Comparator�� ���̿� ���ؼ��� Ȯ���ϰ� ���������� �ؾ߰ڴ�. 
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
				
				// ���̰� ������
				if (o1.length() == o2.length()) {
					// ���ĺ� ���� �� 
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
