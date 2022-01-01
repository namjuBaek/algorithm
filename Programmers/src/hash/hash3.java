package hash;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/*
<베스트 앨범>
장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범으로 출시 
- 구해야 할 것
1) 장르별 플레이 수 합해서 가장 높은 장르 무엇인지..
2) 장르별 가장 플레이수 높은 곡 고유번호 무엇인지..
3) 재생횟수 같으면 고유 번호 낮은 노래 먼저 수록
*/

public class hash3 {
    public static void main(String[] args) {
        int[] result = {};
        
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        result = solution(genres, plays);
        
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
                
        HashMap<Integer, String> genreMap = new HashMap<>();    //고유번호 별 장르 해시맵
        HashMap<String, Integer> gpMap = new HashMap<>();      //장르 별 플레이수 해시맵
        
      //고유번호 별 데이터 세팅
        for (int i=0; i<genres.length; i++) {
            genreMap.put(i, genres[i]);
            
          //장르별 플레이수 세팅
            if (gpMap.get(genres[i]) != null) {
                gpMap.put(genres[i], gpMap.get(genres[i]) + plays[i]);    
            } else {
                gpMap.put(genres[i], plays[i]);    
            }
        }
        
        //속한 노래가 많이 재생된 장르 순으로 정렬
        List<String> genreRank = new ArrayList<>(gpMap.keySet());
        Collections.sort(genreRank, (value1, value2) -> (gpMap.get(value2).compareTo(gpMap.get(value1)))); 
        
        //장르 내에서 많이 재생된 노래 순으로 정렬
        List<Integer> resultList = new ArrayList<>();
        for (int i=0; i<genreRank.size(); i++) {
            HashMap<Integer, Integer> playHsMap = new HashMap<>();
            for (int j=0; j<genreMap.size(); j++) {
                if (genreMap.get(j).equals(genreRank.get(i))) {
                    playHsMap.put(j, plays[j]); 
                }
            }
            
            
            //내림차순으로 키 정렬
            List<Integer> playRank = new ArrayList<>(playHsMap.keySet());
            Collections.sort(playRank, (value1, value2) -> (playHsMap.get(value2).compareTo(playHsMap.get(value1)))); 
                        
            resultList.add(playRank.get(0));
            if (playRank.size() > 1) {
                resultList.add(playRank.get(1));
            }
        }
        
        int[] answer = new int[resultList.size()];

        int size = 0;
        for(Integer value : resultList){
            answer[size++] = value;
        }
        
        return answer;
    }
}

/**
 * 2021.08.11
 * 해시 3단계 문제인 베스트 앨범을 풀었다.
 * 뭔가 꾸역꾸역 하나씩 풀어가긴 했는데, 이 소스도 수정할 부분이 많다.
 * 한 번에 해결 방법이 탁탁 떠오르진 않아서 시간이 오래 걸리는데, 그렇다고 로직이 깔끔한 것도 아닌 것 같다..! 
 * 많이 풀다보면 문제해결능력도 향상된다고.. 믿고싶다.😥
 */