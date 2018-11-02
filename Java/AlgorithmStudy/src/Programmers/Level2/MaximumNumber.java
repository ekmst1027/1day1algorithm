/*
 * 2018-10-31 Wed
 * Level2 - 문자열 내 p와 y의 개수
 * 
 * - 문제정의 -  
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. 
 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 
 * 다르면 False를 return 하는 solution를 완성하세요. 
 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 
 * 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 * 예를들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.
 * 
 * - 제한사항 -
 * 문자열 s의 길이 : 50 이하의 자연수
 * 문자열 s는 알파벳으로만 이루어져 있습니다.
 * 
 * ex1)
 * 입력 s : "pPoooyY"
 * 출력 : true
 * 
 * ex2)
 * 입력 : "Pyy"
 * 출력 : false
 * 
 * 
 */

package Programmers.Level2;


public class MaximumNumber {
	public static boolean solution(String s) {
		// 문자열을 모두 소문자로 변환
		s = s.toLowerCase();

		int pNum = 0;	// p갯수 
		int yNum = 0;	// y갯수 
		// 반복문을 돌면서 p의 갯수와 y의 갯수를 센다.
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p') {
				pNum++;
			} else if(s.charAt(i) == 'y') {
				yNum++;
			}
		}
		// p갯수와 y갯수가 같으면 true 리턴 아니면 false 리턴  
		if(pNum == yNum) {
			return true;
		} else {
			return false;
		}
		
    }

	public static void main(String[] args) {
		System.out.println(solution("pPoooyY"));
		System.out.println(solution("Pyy"));
	}

}
