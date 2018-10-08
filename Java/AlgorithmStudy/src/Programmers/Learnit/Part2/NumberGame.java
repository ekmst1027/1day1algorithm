/*
 * 2018-10-09 Tue
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 숫자 카드놀이
 * 백트래킹
 * 
 * - 문제정의 -  
 * 
 * 세인트 루이스부터 시카고로 가는 기차에 탑승할 땐 시간을 어떻게 보내야 할지가 큰 걱정이다. 
 * 시간을 보내기위해 게임을 하나 만들었다.
 * 자연수 S를 하나 고른 뒤 각 자리를 모두 곱하면서 한 자리 수가 나오기 전까지 계속해서 새로운 수를 만드는 게임이다.
 * 예를 들어, 95로 시작한다면, 9 x 5 = 45를 얻게 된다. 
 * 45도 두 자리 이상이기 때문에, 4 x 5 = 20를 얻게 된다. 
 * 그 다음 2 x 0 이 되고, 0은 한 자리 숫자이기 때문에 게임은 끝나게 된다.
 * 또, 396에서 시작한다면, 아래와 같은 과정을 거쳐 2로 끝나게 된다.
 * 3 x 9 x 6 =162, 1 x 6 x 2 = 12, 1 x 2 = 2
 * 자연수 S가 주어졌을 때, 숫자 놀이를 하는 과정을 출력하는 프로그램을 작성하시오.
 *
 *  
 * - 입력 - 
 * 숫자 놀이의 시작값 S가 주어진다. S는 1보다 크거나 같고 100,000보다 작거나 같은 자연수이다.
 * 
 * - 출력 -
 * 숫자 놀이가 끝나기 전 까지 나온 수를 공백으로 구분하여 출력한다. 첫 값은 입력으로 주어진 값이다.
 * 
 * ex1) 
 * 입력 : 95
 * 출력 : 95 45 20 0
 * 
 * 
 */

package Programmers.Learnit.Part2;

import java.util.Scanner;

public class NumberGame {
	public static void main(String[] args) {
		// 입력부 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// n의 각 자리수를 곱한 뒤 출력(n이 한자리수가 될때까지)
		while(true) {
			int result = 1;	// 곱해져서 출력될 값
			System.out.print(n + " ");
			// n이 한자리수일 경우 종료
			if(n < 10) {
				return;
			}
			while(n > 0) {
				int mod = n % 10;	// 각 자리의 수
//				System.out.println("mod : " + mod);
				result *= mod;	// 각 자리의 수를 곱한 값
//				System.out.println("mul : " + mul);
				n /= 10;
			}
			n = result;
		}
	}

}
