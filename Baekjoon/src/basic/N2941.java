package basic;

/**
 * 2022.01.09 일
 * @author bnj
 * 백준 N2941번 크로아티아 알파벳
 * 
 * č	c=
 * ć	c-
 * dž	dz=
 * đ	d-
 * lj	lj
 * nj	nj
 * š	s=
 * ž	z=
 * ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
 */

import java.util.Scanner;

public class N2941 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int countWord = 0;
		
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String str = scan.next();
		
		for (String alphabet : croatia) {
			while (str.contains(alphabet)) {
				str = str.replaceFirst(alphabet, ".");	//.으로 치환하지 않고 아예 없앨경우, 문자가 합쳐져 다른 알파벳이 되는 경우가 발생 ex) nljj -> nj로 바뀌어서 한 문자로 인식됨.
				countWord++;
			}
		}
		
		str = str.replace(".", "");
		countWord += str.length();
		
		System.out.println(countWord);		
	}
}
