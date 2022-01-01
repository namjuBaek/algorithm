package weekly;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/** 
 * ���α׷��ӽ� ��Ŭ�� 4���� ����Ǯ��
 * ��� ���� ��� ��ȣ���� �Է��ϸ� �׿� �´� �������� return�ϴ� ���α׷�
 * table : ������ ��� (������ 5, 4, 3, 2, 1��)
 * languages : ������ ��� ���
 * preference : ��� �� ��ȣ��
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
        System.out.println("��õ ���� : " + result);
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        //������ ��� ����
        HashMap<String, List<String>> jobLanguageRank = new HashMap<>();

        for (String jobLanguages: table) {
            String jobLanguage[] = jobLanguages.split(" ");
            List<String> languageRank = new ArrayList<>();
            for (int i=1; i<jobLanguage.length; i++) {
                languageRank.add(jobLanguage[i]);
            }

            jobLanguageRank.put(jobLanguage[0], languageRank);
        }

        //������ �� ���� ����
        HashMap<String, Integer> jobScore = new HashMap<>();

        for (String key : jobLanguageRank.keySet()) {
            for (int i=0; i<languages.length; i++) {
                List<String> languageRank = jobLanguageRank.get(key);
                for (int j=0; j<languageRank.size(); j++) {
                    if (languageRank.get(j).equals(languages[i])) {
                        int score = preference[i] * (5-j);  //6-j : ������ ���߾�� ����
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


        //���� ������ ���� ������ ã�� (���� ������ ���, �̸��� ���� ������ ���� ���� ���� ����)
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
 * 4���� ���α׷��ӽ� ��Ŭ�� ����
 * 3�� ������ ���� �ʰ� Ǯ �� ���� �� ������,,
 * �ذ����� �ٷ� �������� �ʴ´�. 
 * 
 * 1. ���� ���ϱ� ���� ������ ������ ����
 * 2. �������� ���� ������ �ִ��� ã�� (��ȣ�� * ����)�� ����� ����� ���� �ؽø� ������ ����
 * 3. ���� ���� �� ���� ���� ������ ���� ã�� 
 * 
 * ũ�� �� �ܰ�� ������ �ڵ��ߴµ� �������� ���� �������� �ڵ尡 ���.
 * �� �� ����غ��߰ڴ�.
 */