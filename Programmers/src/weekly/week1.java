package weekly;

/**
 * 프로그래머스 위클리 1주차 문제풀이
 * <부족한 금액  계산하기>
 * 1. price : 놀이기구의 원래 이용료 / money : 현재 소지한 금액 / count : 놀이기구 탑승 횟수
 * 2. 놀이기구를 N번째 이용하면 원래 이용료의 N배 지불
 * 3. 놀이기구를 count번 탄 후 현재 소지한 금액에서 얼마가 모자라는지 return
 * 4. 금액이 부족하지 않으면 0 리턴
 */


class week1 {
    public static void main(String[] args) {
        long result1, result2 = 0;

        result1 = solution(300, 1000, 2);
        System.out.println("결과1 : " + result1);

        result2 = solution(5, 10, 4);
        System.out.println("결과2 : " + result2);
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;
        long totalPrice = 0;

        for (int i=1; i<=count; i++) {
            totalPrice += (price*i);
        }

        answer = (money > totalPrice) ? 0 : totalPrice - money;

        return answer;
    }
}

/**
 * 처음 로직을 작성할 때 자료형의 크기를 고려하지 않고 totalPrice를 int로 작성했는데,
 * 특정 테스트케이스에서 걸렸다. 
 * price와 count 최댓값이 2500이라 overflow가 발생했던 것이다.
 * 로직뿐 아니라 자료형도 고려하여 작성해야 한다.
 * 
 * 다른 사람들의 코드를 보니 수식을 사용하여 로직코드를 줄였다.
 * 1 ~ count의 합을 n(n+1)/2 수식으로 구함
 * --> long totalPrice = price * ((long)count * (1 + count) / 2);
 * 
 * Math.max를 이용하여 한 줄로도 작성 가능하다.
 */
