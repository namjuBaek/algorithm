package hash;

import java.util.HashMap;

/**
 * 1. clothes[][] : 스파이가 가진 의상의 종류와 이름이 담긴 2차원 배열
 * 2. clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 3. 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 4. 같은 이름을 가진 의상은 존재하지 않습니다.
 * 5. 스파이는 하루에 최소 한 개의 의상은 입습니다.
 * 6. 서로 다른 옷의 조합의 수를 리턴
 */

public class hash1 {
    public static void main(String[] args) {
        int result = 0;
        String[][] clothes = {
            {"yellowhat", "headgear"}, 
            {"bluesunglasses", "eyewear"}, 
            {"green_turban", "headgear"}
        };
        
        result = solution(clothes);
        System.out.println("총 조합 수 : " + result);
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        for (int i=0; i<clothes.length; i++) {
            if (clothesMap.containsKey(clothes[i][1])) {
                clothesMap.put(clothes[i][1], clothesMap.get(clothes[i][1]) + 1);
            } else {
                clothesMap.put(clothes[i][1], 1);
            }
        }
        
        for (String key : clothesMap.keySet()) {
            answer *= clothesMap.get(key) + 1;
        }     
        
        return answer - 1;
    }
}

/**
 * 2021.08.10
 * hash 2단계 2번째 문제..
 * 이 문제는 hash를 잘 사용하는 것보다 조합의 수를 구하는 공식을 찾는 게 더 중요한 문제라고 생각한다.
 * 사실 공식을 직접 구한 것이 아니라, 종류별 곱한 값에 1을 더하고 최종값에 -1을 하는게 공식이라는 글을 보고 작성한 코드이다.
 * 수학적 지식이 부족한게 이런 문제들을 풀다보니 느껴진다 .. 😥
 */