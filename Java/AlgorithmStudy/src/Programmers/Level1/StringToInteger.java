/*
 * 2018-11-9 Fri
 * Level2 - 땅따먹기 - DP 
 * 
 * - 문제정의 -  
 * 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
 * 
 * - 제한사항 -
 * s의 길이는 1 이상 5이하입니다.
 * s의 맨앞에는 부호(+, -)가 올 수 있습니다.
 * s는 부호와 숫자로만 이루어져있습니다.
 * s는 0으로 시작하지 않습니다.
 * 
 * ex1)
 * 입력 land : {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
 * 출력 : 16
 * 
 * 
 */

package Programmers.Level1;

public class StringToInteger {
	public static int solution(String s) {
		if(s.charAt(0) == '+') {
			String st = s.substring(1, s.length());
			return Integer.parseInt(st);
		} else if(s.charAt(0) == '-') {
			String st = s.substring(1, s.length());
			return -Integer.parseInt(st);
		} else {
			return Integer.parseInt(s);
		}
		
	}

	public static void main(String[] args) {
		System.out.println(solution("+1234"));
		System.out.println(solution("-1234"));
	}

}
