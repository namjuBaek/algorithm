package sorting;

/**
 * 2022.02.20 ��
 * @author bnj
 * ���� N2108�� �����
 * 
 * ���� ó���ϴ� ���� ����п��� ����� �߿��� ���̴�. ����п��� N���� ���� ��ǥ�ϴ� �⺻ ��谪���� ������ ���� �͵��� �ִ�. ��, N�� Ȧ����� ��������.
 * ������ : N���� ������ ���� N���� ���� ��
 * �߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
 * �ֺ� : N���� ���� �� ���� ���� ��Ÿ���� ��
 * ���� : N���� ���� �� �ִ񰪰� �ּڰ��� ����
 * N���� ���� �־����� ��, �� ���� �⺻ ��谪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N(1 �� N �� 500,000)�� �־�����. ��, N�� Ȧ���̴�. �� ���� N���� �ٿ��� �������� �־�����. �ԷµǴ� ������ ������ 4,000�� ���� �ʴ´�.
 * 
 * ----comment----
 * 02.20 
 * - �ݷʸ� ��ã����.. ���� ����ȵ�
 * 02.21 
 * - �������� ���� ��� sum�� �ڷ����� float�̶� ������� ���ߴ� �ſ���. double�� �ٲ��� ���� ���
 * float�� ���� 8�ڸ����� ���� �� ������ �� ���������� 4000 * 50�� = 2,000,000,000 ���� ���� ���� �� �ֱ� ������ sum�� �ڷ����� double�� �����ؾ� �Ѵ�. 
 * �ڷ����� �� �����ϰ� Ǯ��..
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class N2108 {
	
	public static void main(String[] args) throws IOException {
		
		int avg = 0, med = 0, mod = 0, diff = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//������ �Է�
		int count = Integer.parseInt(br.readLine());
		int[] data = new int[count];
		
		for (int i = 0; i < count; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		//��հ� ���ϱ�
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum += data[i];
		}
		avg = (int) Math.round((double)sum / count);
		
		
		//�߾Ӱ� ���ϱ�
		Arrays.sort(data);
		med = data[count / 2];
		
		
		//�ֺ� ���ϱ�
		ArrayList<Integer> modeArr = new ArrayList<Integer>();

		int modMax = 1;
		int modCount = 1;
		int modNum = 4001;
		for (int i = 0; i < count; i++) {
			if (i == 0) {
				modNum = data[i];
				modCount = 1;
				modMax = modCount;
				continue;
			}
			
			if (modNum != data[i]) {
				if (modCount > modMax) {
					modMax = modCount;
					modeArr.clear();
					modeArr.add(data[i-1]);
				} else if (modCount == modMax) {
					modeArr.add(data[i-1]);
				}
				
				modCount = 1;
				modNum = data[i];
			} else {
				modCount++;
			}	
		}
		
		if (modCount > modMax) {
			modMax = modCount;
			modeArr.clear();
			modeArr.add(data[count-1]);
		} else if (modCount == modMax) {
			modeArr.add(data[count-1]);
		}
		
		Collections.sort(modeArr);
		
		if (modeArr.size() > 1) {
			mod = modeArr.get(1);
		} else {
			mod = modeArr.get(0);
		}
		
		
		//���̰� ���ϱ�
		diff = data[count-1] - data[0];
		
		//��� ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //�Ҵ�� ���ۿ� �� �־��ֱ�
		
		bw.write(Math.round((double)sum / count) + "\n");   	//������
		bw.write(med + "\n");		//�߾Ӱ�
		bw.write(mod + "\n");		//�ֺ�
		bw.write(diff + "\n");		//����
		
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}
}
