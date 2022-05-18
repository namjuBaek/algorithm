package implementation;

/**
 * 2022.05.19 ��
 * @author bnj
 * ���� 1235�� �л� ��ȣ
 * �̹����� �л����� ���� ȿ�������� �����ϱ� ���� �л����� ������ �л� ��ȣ�� �ο��ϱ�� �Ͽ���. 
 * �л� ��ȣ�� 0���� 9 ������ ���ڷ� �̷���� ���ڿ���, ��� �л����� �л� ��ȣ�� ���� �ٸ����� �� ���̴� ��� ����.
 * �л����� ��ȣ�� �־� ���� ��, �ڿ��� k�ڸ����� �߷��� ���� ������ �� ��� �л����� �л� ��ȣ�� ���� �ٸ��� ���� �� �ִ� �ּ��� k�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ��� �л��� �� N(2��N��1,000)�� �־�����. ��° �ٺ��� N���� �ٿ� ���� �� �л��� �л� ��ȣ�� ������� �־�����. 
 * ��� �л����� �л� ��ȣ�� ���� �ٸ����� �� ���̴� ��� ������, 0���� 9 ������ ���ڷ� �̷���� ���ڿ��� �־�����. 
 * ���ڿ��� ���̴� 100���� �۰ų� ����.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N1235 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		int k = 0;	//�л� ��ȣ�� �ٸ��� ���� �� �ִ� �ּ� k�ڸ�
		
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