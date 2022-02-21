package sorting;

/**
 * 2022.02.20 일
 * @author bnj
 * 백준 N2108번 통계학
 * 
 * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
 * 
 * ----comment----
 * 02.20 
 * - 반례를 못찾겠음.. 백준 통과안됨
 * 02.21 
 * - 데이터의 합을 담는 sum의 자료형이 float이라서 통과하지 못했던 거였다. double로 바꾸자 백준 통과
 * float는 숫자 8자리까지 담을 수 있지만 이 문제에서는 4000 * 50만 = 2,000,000,000 까지 값이 나올 수 있기 때문에 sum의 자료형을 double로 선언해야 한다. 
 * 자료형을 잘 생각하고 풀자..
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
		
		//데이터 입력
		int count = Integer.parseInt(br.readLine());
		int[] data = new int[count];
		
		for (int i = 0; i < count; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		//평균값 구하기
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum += data[i];
		}
		avg = (int) Math.round((double)sum / count);
		
		
		//중앙값 구하기
		Arrays.sort(data);
		med = data[count / 2];
		
		
		//최빈값 구하기
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
		
		
		//차이값 구하기
		diff = data[count-1] - data[0];
		
		//결과 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		
		bw.write(Math.round((double)sum / count) + "\n");   	//산술평균
		bw.write(med + "\n");		//중앙값
		bw.write(mod + "\n");		//최빈값
		bw.write(diff + "\n");		//범위
		
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
}
