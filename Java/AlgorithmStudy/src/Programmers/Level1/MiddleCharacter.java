/*
 * 2018-10-10 Wed
 * Level1 - 가운데 글자 가져오기
 * 
 * - 문제정의 -  
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 *
 *  
 * - 제한사항 - 
 * s는 길이가 1 이상, 100이하인 스트링입니다.
 * 
 * ex1) 
 * 입력 : abcde
 * 출력 : c
 * 
 * ex2) 
 * 입력 : qwer
 * 출력 : we
 * 
 * 
 * 
 */
package Programmers.Level1;

public class MiddleCharacter {
	
	public static String solution(String s) {
		int a = s.length() % 2;
		if(s.length() % 2 != 0) {
			return String.valueOf(s.charAt(s.length() / 2));
		} else {
			return s.substring((s.length() / 2)-1, (s.length() / 2)+1);
		}
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
