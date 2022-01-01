package hash;

import java.util.Arrays;
/*
<완주하지 못한 선수>
단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주했다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 구해야 한다.
*/

public class hash4 {
    public static void main(String[] args) {
        String result;
        
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        
        result = solution(participant, completion);
        
        System.out.print(result);
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i=0;
        for (i=0; i<completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
                
        return participant[i];
    }
}

/**
 * 2021.09.11
 * 해시 1단계 문제인 베스트 앨범을 풀었다.
 * 2, 3단계는 풀어놓고 1단계는 안풀어놨길래 빠르게 풀어봤다.
 * 처음에는 전체 순회하는 방식으로 작성했는데, 효율성 테스트에서 떨어져서
 * 정렬한 후에 비교하는 방식으로 시도했다.
 * hash 카테고리에 있는 문제이기 때문에 hash 사용해서 작성하는 방법도 고민해봐야겠다.
 */