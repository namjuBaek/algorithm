package bruteforce;

/**
 * 2022.01.13 목
 * @author bnj
 * 백준 N1018번 체스판 다시 칠하기
 * 
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 
 * 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 */

import java.util.Scanner;

public class N1018 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		scan.nextLine();
		
		String[] chess = new String[N];
		
		for (int i=0; i<N; i++) {
			chess[i] = scan.nextLine();
			
		}
		
		int count = 0;
		int min = 99999999;
		
		
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				//시작 좌표 : [i][j]
				for (int k=0; k<8; k++) {
					for (int f=0; f<8; f++) {
						if (
								k % 2 != 0 && f % 2 != 0 && chess[i+k].substring(j+f, j+f+1).equals("B") ||
								k % 2 != 0 && f % 2 == 0 && chess[i+k].substring(j+f, j+f+1).equals("W") ||
								k % 2 == 0 && f % 2 != 0 && chess[i+k].substring(j+f, j+f+1).equals("W") ||
								k % 2 == 0 && f % 2 == 0 && chess[i+k].substring(j+f, j+f+1).equals("B"))
						{
							count++;
						}
					}
				}
				if (count < min) {
					min = count;
				}
				count = 0;
				
				
				for (int k=0; k<8; k++) {
					for (int f=0; f<8; f++) {
						if (
								k % 2 != 0 && f % 2 != 0 && chess[i+k].substring(j+f, j+f+1).equals("W") ||
								k % 2 != 0 && f % 2 == 0 && chess[i+k].substring(j+f, j+f+1).equals("B") ||
								k % 2 == 0 && f % 2 != 0 && chess[i+k].substring(j+f, j+f+1).equals("B") ||
								k % 2 == 0 && f % 2 == 0 && chess[i+k].substring(j+f, j+f+1).equals("W"))
						{
							count++;
						}
					}
				}
				if (count < min) {
					min = count;
				}
				count = 0;
				
			}
		}	
		
		System.out.println(min);
	}
}
