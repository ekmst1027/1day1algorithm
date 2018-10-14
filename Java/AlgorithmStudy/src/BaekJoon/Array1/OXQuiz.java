/*
 * 2018-10-15 Mon
 * 백준 - 1차원 배열 - OX퀴즈(8958)
 * 
 * - 문제정의 -  
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. 
 * O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 *
 * - 입력 - 
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 
 * 각 테스트 케이스는 한 줄로 이루어져 있고, 
 * 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 
 * 문자열은 O와 X만으로 이루어져 있다.
 *
 * - 출력 - 
 * 각 테스트 케이스마다 점수를 출력한다.
 * 
ex) 
입력 
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX

출력
10
9
7
55
30
 *
 *
 */

package BaekJoon.Array1;

import java.util.Scanner;

public class OXQuiz {
	public static void main(String[] args) {
		// 입력부 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 테스트케이스 개수
		String[] strArr = new String[N];	// OX를 담을 배열 
		String a = sc.nextLine();	// 가비지값(개행문자를 담음)
		int[] answer = new int[N];	// 정답 배열
		
		// OX를 담음
		for(int i = 0; i < N; i++) {
			strArr[i] = sc.nextLine();
		}
		
		// 각 줄마다 카운트 수와 합을 초기화
		for(int i = 0; i < strArr.length; i++) {
			int count = 0;
			int sum = 0;
			// 현재 줄에서 O면은 카운트를 늘리고 X일 경우 카운트를 초기화
			// 마지막까지 끝나면 sum에 최종 카운트를 더함 그리고 정답 배열에 할당
			for(int j = 0; j < strArr[i].length(); j++) {
				char temp = strArr[i].charAt(j);
				if(temp == 'X') {
					count = 0;
				} else {
					count++;
				}
				sum += count;
			}
			answer[i] = sum;
		}
		// 출력하기
		for(int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
	}
}

