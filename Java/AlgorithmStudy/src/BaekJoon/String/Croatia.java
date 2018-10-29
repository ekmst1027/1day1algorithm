/*
 * 2018-10-29 Mon
 * 백준 - 문자열 사용하기 - 크로아티아 알파벳(2941)
 * 
 * - 문제정의 -  
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 
 * 따라서, 다음과 같이 크로아티아 알파벳을 다음과 같이 변경해서 입력했다.
 * 크로아티아 알파벳	변경
 * č	c=
 * ć	c-
 * dž	dz=
 * ñ	d-
 * lj	lj
 * nj	nj
 * š	s=
 * ž	z=
 * 
 * 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 
 * 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. 
 * lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
 *
 * - 입력 - 
 * 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
 * 문제 설명에 나와있는 크로아티아 알파벳만 주어진다. 
 *
 * - 출력 - 
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * 
 * ex1)
 * 입력 : ljes=njak
 * 출력 : 6
 * 
 * ex2)
 * 입력 : ddz=z=
 * 출력 : 3
 * 
 * ex3)
 * 입력 : nljj
 * 출력 : 3
 * 
 * ex4)
 * 입력 : c=c=
 * 출력 : 2
 * 
 */

package BaekJoon.String;

import java.util.Scanner;

public class Croatia {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		// 변수 생성 
		// 크로아티아 문자에 해당하는 알파벳을 배열로 저장
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		// 배열을 돌면서 크로아티아 문자에 해당하는 알파벳은 임의의 알파벳으로 치환
		for(String cr : croatia) {
			if(input.contains(cr)) {
//				System.out.println("cr : " + cr);
				input = input.replaceAll(cr, "a");
//				System.out.println("input : " + input);
			}
		}
//		System.out.println(input);
		System.out.println(input.length());
		
	}

}
