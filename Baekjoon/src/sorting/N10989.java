package sorting;

/**
 * 2022.02.10 ��
 * @author bnj
 * ���� N10989�� �� �����ϱ�3_��� ���� ���
 * 
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N(1 �� N �� 10,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���� �־�����. �� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
 * 
 * �ð����⵵�� O(n) - ��� ����
 * 
 * ----comment----
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N10989 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int max = 0;
		int count = Integer.parseInt(br.readLine());
		int[] data = new int[count];
		int[] sort = new int[count];
				
		for (int i = 0; i < count; i++) {
			data[i] = Integer.parseInt(br.readLine());
			if (max < data[i]) {
				max = data[i];
			}
		}
		
		//ī���� �迭 ����
		int[] countArr = new int[max];	//1���� ����
		for (int i = 0; i < count; i++) {
			countArr[data[i]-1]++;
		}
		
		//���� ��ҵ��� �� ��ġ��
		for (int i = 1; i < max; i++) {
			countArr[i] += countArr[i-1];
		}
		
		
		//��� ���� - �Է� �迭�� �������� ��ҵ��� ä��
		for (int i = count-1; i >= 0; i--) {
			sort[countArr[data[i]-1]-1] = data[i];
			countArr[data[i]-1]--;
		}
		
		
		//���ĵ� �迭 ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //�Ҵ�� ���ۿ� �� �־��ֱ�
		for (int num : sort) {
			bw.write(num+"\n");   //���ۿ� �ִ� �� ���� ���
		}
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}
}
