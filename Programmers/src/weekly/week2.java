package weekly;

import java.util.Arrays;

/**
 * 프로그래머스 위클리 2주차 문제풀이
 * <학점 부여>
 * 1. scores[][] : 학생들이 자신과 다른 학생의 과제를 평가한 점수표
 * 2. i행 j열의 값은 i번 학생이 평가한 j번 학생의 과제 점수
 * 3. 각 학생들이 받은 점수의 평균을 구하여, 기준에 따라 학점을 부여
 * 4. 단, 학생들이 자기 자신을 평가한 점수가 평가받은 점수 중에 유일한 최고점 또는 유일한 최저점이라면 그 점수는 제외하고 평균을 구한다.
 * 5. 90이상 A, 80이상 90미만 B, 70이상 80미만 C, 50이상 70미만 D, 50미만 F
 * 6. 학생들의 학점을 하나의 문자열로 만들어 return
 */

public class week2 {

    public static void main(String[] args) {
        String grade = "";
        int[][] scores = {
            {100, 90, 98, 88, 65},
            {50, 45, 99, 85, 77},
            {47, 88, 95, 80, 67},
            {61, 57, 100, 80, 65},
            {24, 90, 94, 75, 65}
        };

        grade = solution(scores);
        System.out.println("학점 : " + grade);
    }

    public static String solution(int[][] scores) {
        String answer = "";
        
        //제외 여부 배열
        boolean[] isExcept = new boolean[scores.length];
        Arrays.fill(isExcept, false);
        
        //학생별 평균 저장 배열
        int[] result = new int[scores.length];
        
        int max, min;
        for (int i=0; i<scores.length; i++) {
            min = 101;
            max = -1;
            for (int j=0; j<scores[i].length; j++) {
                if (i != j) {
                    if (min > scores[j][i]) {
                        min = scores[j][i];
                    }
                    if (max < scores[j][i]) {
                        max = scores[j][i];
                    }
                }
            } 
            
            
            //제외되어야 하는지 여부 체크
            if (min > scores[i][i] || max < scores[i][i]) {
                isExcept[i] = true;
            }
            
            //학생 별 평균 점수 저장
            int avg = 0;
            for (int j=0; j<scores[i].length; j++) {     
                if (!(isExcept[i] && i == j)) {
                    //제외되어야 할 점수는 빼고 총합 계산
                    avg += scores[j][i];    
                }
            }
            
            if (isExcept[i]) {
                avg = avg / (scores[i].length-1);
            } else {
                avg = avg / scores[i].length;
            }
            
            result[i] = avg;
        }
        
        //학점 부여
        for (int grade : result) {
            switch (grade/10) {
                case 9:
                    answer += "A";
                    break;
                case 8:
                    answer += "B";
                    break;
                case 7:
                    answer += "C";
                    break;
                case 6:
                case 5:
                    answer += "D";
                    break;
                default:
                    answer += "F";
            }
        }
                
        return answer;
    }
}

/**
 * 2021.08.09
 * 프로그래머스 2주차 문제가 나와서 풀어보았다.
 * 어찌어찌 풀긴했는데, 개선할 수 있는게 있는지 좀 더 고민해봐야 할 것 같다.
 * String으로 + 연산을 하는 것보다 StringBuilder로 append를 하는 게 성능이 더 좋다고 알고있는데 
 * (--> String 문자열 붙이기에 관한 성능문제는 블로그에 글 올리면서 다시 정리해봐야겠다..!!)
 * 기본으로 세팅해준 변수 answer이 String이라서 그냥 +로 처리했다.
 * 로직 개선할 때 StringBuilder를 사용해봐야겠다.
 */