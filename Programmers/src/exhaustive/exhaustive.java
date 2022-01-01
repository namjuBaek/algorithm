package exhaustive;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 * <모의고사>
 * 1. answers[] : 정답 목록
 * 2. 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 3. 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 4. 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 5. 가장 많은 문제를 맞힌 사람이 누구인지 리턴
 * 6. 단, 여럿일 경우, 오름차순 정렬 *  
 */

public class exhaustive {
    public static void main(String[] args) {
        int[] result = {};
        //int[] answers = {1, 3, 2, 4, 2}; //결과 : 1 2 3
        int[] answers = {1, 2, 3, 4, 5};   //결과 : 1
        
        result = solution(answers);
        System.out.print("가장 높은 점수를 받은 사람 : ");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] score = new int[3];
        Arrays.fill(score, 0);
        
        int[][] student = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
      //학생 별 문제 정답 수 체크
        int pointer = 0;
        for (int i=0; i<student.length; i++) {
            pointer = 0;
            for (int j=0; j<answers.length; j++) {
                if (pointer == student[i].length) {
                    pointer = 0;
                }

                if (answers[j] == student[i][pointer]) {
                    score[i]++;
                }
                pointer++;
            } 
        }
        
      //가장 많은 문제를 맞힌 사람
        List<Integer> topList = new ArrayList<>();
        int max = score[0];
        for (int i=0; i<score.length; i++) {
            if (max < score[i]) {
                topList.clear();
                topList.add(i+1);
                max = score[i];
            } else if (max == score[i]) {
                topList.add(i+1);
            }
        }     
        answer = new int[topList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = topList.get(i);
        }
        
        return answer;
    }
}

/**
 * 2021.08.12
 * 프로그래머스 완전탐색 1단계 문제 풀이
 */