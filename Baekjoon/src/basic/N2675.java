package basic;

/**
 * 2022.01.06 ��
 * @author bnj
 * ���� N2675�� ���ڿ� �ݺ�
 * 
 * ���ڿ� S�� �Է¹��� �Ŀ�, �� ���ڸ� R�� �ݺ��� �� ���ڿ� P�� ���� �� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * ��, ù ��° ���ڸ� R�� �ݺ��ϰ�, �� ��° ���ڸ� R�� �ݺ��ϴ� ������ P�� ����� �ȴ�. S���� QR Code "alphanumeric" ���ڸ� ����ִ�.
 * QR Code "alphanumeric" ���ڴ� 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: �̴�.
 * ù° �ٿ� �׽�Ʈ ���̽��� ���� T(1 �� T �� 1,000)�� �־�����. 
 * �� �׽�Ʈ ���̽��� �ݺ� Ƚ�� R(1 �� R �� 8), ���ڿ� S�� �������� ���еǾ� �־�����. 
 * S�� ���̴� ��� 1�̸�, 20���ڸ� ���� �ʴ´�. 
 */

import java.util.Scanner;
import java.util.Arrays;

public class N2675 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int totalCount = scan.nextInt();
		String[] newStr = new String[totalCount];
		Arrays.fill(newStr, "");
		
		for (int i=0; i<totalCount; i++) {
			int repeat = scan.nextInt();
			String str = scan.next();
		
			for (int j=0; j<str.length(); j++) {
				newStr[i] = newStr[i] + "" +  str.substring(j, j+1).repeat(repeat);
			}
		}
		
		for (String str : newStr) {
			System.out.println(str);
		}
	}

}
