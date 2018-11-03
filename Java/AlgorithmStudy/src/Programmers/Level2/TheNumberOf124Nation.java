/*
 * 2018-10-20 Sat
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

// 재귀를 사용해서 해결(하지만 재귀를 안쓰고 반복문으로도 해결 가능)

package Programmers.Level2;

public class TheNumberOf124Nation {
	static int[] arr = {1, 2, 4};
	
	// 재귀함수
	public static String btr(int n, String ans) {
		String answer = "";
		
		// 종료 조건
		if(n < 3) {
			ans = String.valueOf(arr[n]) + ans;
//			System.out.println("종료조건 ans : " + ans);
			return ans;
		}
//		System.out.println("n : " + n);
		
		// 종료조건에 해당하지 않을 경우 다시 종료조건에 맞게 3을 나누어 재귀
		ans = arr[n%3] + ans;
//		System.out.println("재귀 가기 전 ans : " + ans);
		n /= 3;
		ans = btr(n-1, ans);
//		System.out.println("재귀 돌고 ans : " + ans);
		
		return ans;
	}
	
	public static String solution(int n) {
		String answer = "";	// 정답
		String ans = "";	// 임시로 값을 저장할 문자열
		n = n-1;	// arr배열과 순서를 맞추기 위해 n-1
		
		answer = btr(n, ans);	// 재귀
		
		return answer;

	}

	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			System.out.println(i + " : " + solution(i));
			System.out.println("================");
		}
	}

}
