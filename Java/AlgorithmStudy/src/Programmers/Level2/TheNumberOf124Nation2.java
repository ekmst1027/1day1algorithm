/*
 * 2018-10-22 Mon
 * Level2 - 124나의 숫자
 * 
 * - 문제정의 -  
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 * 124 나라에는 자연수만 존재합니다.
 * 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 * 자연수 n이 매개변수로 주어질 때, 
 * n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 *
 *  
 * - 제한사항 - 
 * n은 500,000,000이하의 자연수 입니다.
 * 
 * ex1) 
 * 입력 n : 1;
 * 출력 : 1
 * 
 * ex2) 
 * 입력 n : 2;
 * 출력 : 2
 * 
 * ex3) 
 * 입력 n : 3;
 * 출력 : 4
 * 
 * ex4) 
 * 입력 n : 4;
 * 출력 : 11
 * 
 * 
 */

// 재귀 안쓰고 해결 시도

package Programmers.Level2;

public class TheNumberOf124Nation2 {
	public static String solution(int n) {
		int[] num = {4, 1, 2};
		String answer = "";	// 정답
		
		while(n > 0) {
			System.out.println("n : " + n);
			answer = num[n % 3] + answer;
			System.out.println("answer : " + answer);
	        n = (n - 1) / 3;	// 이 식의 핵심
		}
		return answer;

	}

	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			System.out.println(i + " : " + solution(i));
			System.out.println("================");
		}
	}

}
