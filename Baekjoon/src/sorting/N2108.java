package sorting;

/**
 * 2022.02.20 토
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
 * ----comment----
 * 반례를 못찾겠음.. 백준 통과안됨
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
		
		int avg = 0, mead = 0, mod = 0, diff = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//데이터 입력
		int count = Integer.parseInt(br.readLine());
		int[] data = new int[count];
		
		for (int i = 0; i < count; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		//평균값 구하기
		float sum = 0;
		for (int i = 0; i < count; i++) {
			sum += data[i];
		}
		avg = (int) Math.round((double)sum / count);
		
		
		//중앙값 구하기
		Arrays.sort(data);
		mead = data[count / 2];
		
		
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
		
		bw.write(avg + "\n");   	//산술평균
		bw.write(mead + "\n");		//중앙값
		bw.write(mod + "\n");		//최빈값
		bw.write(diff + "\n");		//범위
		
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
}
