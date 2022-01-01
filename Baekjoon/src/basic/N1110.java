package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon 1110번
 * 더하기 사이클
 */
public class N1110 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int cycleCount = 0;
        int result = -1;
        
        int first = num / 10;
        int second = num % 10;
        int sum = first + second;
        while(result != num) {
            first = second;
            second = (sum) % 10;
            sum = first + second;

            result = Integer.parseInt(first + "" + second);
            cycleCount++;
        }
        
        System.out.println(cycleCount);
    }    
}

