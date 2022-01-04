package basic;

import java.util.Scanner;

/**
 * 2021.01.04 화
 * @author bnj
 * 백준 4344번
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */

public class N4344 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		int studentCount = 0;
		
		int[] score;
		int sum = 0, avg = 0, topStudent = 0;
		double[] percent = null;
		
		count = scan.nextInt();
		percent = new double[count];
		
		for (int i = 0; i < count; i++) {
			//케이스 별 학생 수 입력
			studentCount = scan.nextInt();
			score = new int[studentCount];
			
			//케이스 별 학생 점수 입력
			sum = 0;
			for (int j = 0; j < studentCount; j++) {
				score[j] = scan.nextInt();
				
				sum += score[j];
			}
			
			//평균을 넘는 학생들의 비율 계산
			avg = sum / studentCount;
			
			topStudent = 0;
			for (int j = 0; j < studentCount; j++) {
				if (score[j] > avg) {
					topStudent++;
				}
			}
			
			percent[i] = ((double) topStudent / studentCount) * 100;
		}

		for (int i = 0; i < count; i++) {
			System.out.println(String.format("%.3f", percent[i]) + "%");
		}
	}

}
