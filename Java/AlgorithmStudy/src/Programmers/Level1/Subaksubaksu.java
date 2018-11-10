/*
 * 2018-11-10 Sat
 * Level1 - 수박수박수 
 * 
 * - 문제정의 -  
 * 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
 * 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.
 * 
 * - 제한사항 -
 * n은 길이 10,000이하인 자연수입니다.

 * 
 * ex1)
 * 입력 n : 3
 * 출력 : "수박수"
 * 
 * ex2)
 * 입력 n : 3
 * 출력 : "수박수박"
 * 
 */

package Programmers.Level1;

public class Subaksubaksu {
	public static String solution(int n) {
		String answer = "";
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				answer += "수";
			} else {
				answer += "박";
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

}
