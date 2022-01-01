package hash;

import java.util.HashMap;

/**
 * Hash 두 번째 문제
 * 전화번호 목록
 * 1. phone_book[] : 전화번호부
 * 2. 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인지 확인
 * 3. 접두어인 경우가 있으면 false return / 없으면 true return
 */

public class hash2 {
    public static void main(String[] args) {
        boolean result = true;
        
        //String[] p1 = {"123", "456", "789"};
        String[] p1 = {"119", "97674223", "1195524421"};
        result = solution2(p1);
        
        if (result) System.out.println("한 번호가 다른 번호의 접두사인 경우가 없습니다.");
        else System.out.println("한 번호가 다른 번호의 접두사입니다.");
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for (int i=0; i<phone_book.length; i++) {
            for (int j=i+1; j<phone_book.length; j++) {                
                if (phone_book[i].startsWith(phone_book[j]) || phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
            }
            if (!answer) break;
        }
        
        return answer;
    }

    public static boolean solution2(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> hsMap = new HashMap<>();
        for (String number : phone_book) {
            hsMap.put(number, "");
        }

        for (String key : hsMap.keySet()) {
            for (int i=1; i<key.length(); i++) {
                if (hsMap.containsKey(key.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
            if (!answer) break;
        }

        return answer;
    }
}

/**
 * 2021.08.06
 * 그냥 생각나는대로 코딩해봤는데,, 채점해보니까 정확성은 통과하지만 효율성에서 탈락되었다.
 * 문제 카테고리가 해시인만큼 해시를 사용해서 작성해야 하는 것 같다. 
 * 해시를 사용한 버전으로 다시 업데이트 할 예정이다.
 * 
 * 2021.08.08
 * solution2 메서드가 hash를 사용한 풀이다.
 * 찾아보니 startsWith 메서드가 적지않은 계산을 한다고 한다. 이 때문에 효율성 체크에 걸린 것 같다.
 * 테스트를 통과하고 다른 사람들의 풀이를 보니, 배열을 sort하고 단일 for문을 사용하는 방법도 있었다.
 * 물론 그 코드도 startsWith 때문에 효율성에서 걸린 것 같지만 실무에서는 그 방법이 제일 낫지 않을까..? 생각한다.
 */