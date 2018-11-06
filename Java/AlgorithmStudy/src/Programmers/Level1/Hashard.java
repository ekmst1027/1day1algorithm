/*
 * 2018-11-6 Tue
 * Level1 - 하샤드 수
 * 
 * - 문제정의 -  
 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
 * 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
 * 자연수 n을 입력받아 n이 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 * 
 * - 제한사항 -
 * n은 1 이상, 10000 이하인 정수입니다.
 * 
 * ex1)
 * 입력 : 10
 * 출력 : true
 * 
 * ex2)
 * 입력 : 12
 * 출력 : true
 * 
 * ex3)
 * 입력 : 11
 * 출력 : false
 * 
 * ex4)
 * 입력 : 13
 * 출력 : false
 * 
 * 
 */

package Programmers.Level1;

public class Hashard {
	public static boolean solution(int x) {
		int x2 = x;
		int sum = 0;
		while(x > 0) {
			sum += x % 10;
			x /= 10;
		}
		if(x2 % sum == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(12));
		System.out.println(solution(11));
		System.out.println(solution(13));
	}

}
