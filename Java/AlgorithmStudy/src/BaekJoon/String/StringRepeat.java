/*
 * 2018-10-17 Wed
 * 백준 - 문자열 사용하기 - 문자열반복(2675)
 * 
 * - 문제정의 -  
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. 
 * S에는 QR Code "alphanumeric" 문자만 들어있다.
 * QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
 *
 * - 입력 - 
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 
 * 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.  
 *
 * - 출력 - 
 * 각 테스트 케이스에 대해 P를 출력한다.
 * 
 * ex1)
 * 입력 : 2
 * 		 3 ABC
 * 		 5 /HTP
 * 출력 : AAABBBCCC
 * 		 /////HHHHHTTTTTPPPPP
 *
 */

package BaekJoon.String;

import java.util.Scanner;

public class StringRepeat {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	// 테스트 케이스 수
		String[] str = new String[N];
		String gb = sc.nextLine();	// 문자열 받아올 때 개행문자 받기
		for(int i = 0; i < N; i++) {
			str[i] = sc.nextLine();
		}
		
		// 배열로 만든 문자열을 쉼표로 분리하여 횟수를 나타내는 숫자 부분과 글자 부분으로 나눈다.
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(str[i].split(" ")[0]);
			String st = str[i].split(" ")[1];
			// 글자들의 각 글자를 미리 받은 숫자 만큼 반복한다.
			for(int j = 0; j < st.length(); j++) {
				for(int k = 0; k < n; k++) {
					System.out.print(st.charAt(j));
				}
			}
			System.out.println();
//			System.out.println(n);
//			System.out.println(st);
		}
	}

}
