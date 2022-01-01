package weekly;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/** 
 * 프로그래머스 위클리 4주차 문제풀이
 * 사용 언어와 언어 선호도를 입력하면 그에 맞는 직업군을 return하는 프로그램
 * table : 직군별 언어 (직업군 5, 4, 3, 2, 1순)
 * languages : 개발자 사용 언어
 * preference : 사용 언어별 선호도
*/

class Solution {

    public static void main(String[] args) {
        String[] table = {
            "SI JAVA JAVASCRIPT SQL PYTHON C#", 
            "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", 
            "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", 
            "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", 
            "GAME C++ C# JAVASCRIPT C JAVA"
        };

        String[] languages = {
            "PYTHON", "C++", "SQL"
        };

        int[] preference = {
            7, 5, 5
        };

        String result = solution(table, languages, preference);
        System.out.println("추천 직업 : " + result);
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        //직군별 언어 저장
        HashMap<String, List<String>> jobLanguageRank = new HashMap<>();

        for (String jobLanguages: table) {
            String jobLanguage[] = jobLanguages.split(" ");
            List<String> languageRank = new ArrayList<>();
            for (int i=1; i<jobLanguage.length; i++) {
                languageRank.add(jobLanguage[i]);
            }

            jobLanguageRank.put(jobLanguage[0], languageRank);
        }

        //직군별 총 점수 저장
        HashMap<String, Integer> jobScore = new HashMap<>();

        for (String key : jobLanguageRank.keySet()) {
            for (int i=0; i<languages.length; i++) {
                List<String> languageRank = jobLanguageRank.get(key);
                for (int j=0; j<languageRank.size(); j++) {
                    if (languageRank.get(j).equals(languages[i])) {
                        int score = preference[i] * (5-j);  //6-j : 직군별 개발언어 순위
                        if (jobScore.containsKey(key)) {
                            jobScore.put(key, jobScore.get(key) + score);
                        } else {
                            jobScore.put(key, score);
                        }
                        break;
                    }
                }
            }    
        }


        //가장 점수가 높은 직업군 찾기 (동일 점수일 경우, 이름이 사전 순으로 가장 빠른 직업 선택)
        String maxKey = String.valueOf(jobScore.keySet().toArray()[0]);
        for (String key: jobScore.keySet()) {            
            if (jobScore.get(maxKey) < jobScore.get(key)) {
                maxKey = key;
            } else if (jobScore.get(maxKey) == jobScore.get(key)) {
                if (maxKey.compareTo(key) > 0) {
                    maxKey = key;
                }
            }
        }

        answer = maxKey;

        return answer;
    }
}


/**
 * 2021.09.02
 * 4주차 프로그래머스 위클리 문제
 * 3중 포문을 쓰지 않고도 풀 수 있을 것 같은데,,
 * 해결방법이 바로 떠오르진 않는다. 
 * 
 * 1. 먼저 비교하기 좋게 직군별 언어순위 저장
 * 2. 직군별로 사용언어가 순위에 있는지 찾아 (선호도 * 순위)로 계산한 결과를 더해 해시맵 변수에 저장
 * 3. 총합 점수 중 가장 높은 점수의 직군 찾기 
 * 
 * 크게 세 단계로 나뉘어 코딩했는데 가독성이 많이 떨어지고 코드가 길다.
 * 좀 더 고민해봐야겠다.
 */