/*
 * 2019-05-02 Thu
 * 프로그래머스 - 스킬 체크 테스트 - 레벨1 - 문제1
 * 
 * - 문제정의 -  
 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
 * 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
 *
 *  
 * - 제한사항 - 
 * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 * 
 * ex1) 
 * 입력 : "a234"
 * 출력 : false
 * 
 * ex2)
 * 입력 : "1234"
 * 출력 : false
 * 
 */

package Programmers.Skil_Test.level1;

public class StringCheck {
	public static boolean solution(String s) {
	      boolean answer = true;
	      int a;
	      
	      // 문자열의 길이가 4 또는 6이라면
	      if(s.length() == 4 || s.length() == 6) {
	    	  try {
				a = Integer.parseInt(s);
			} catch (Exception e) {
				return false;
			}
	    	  return true;
	      } else {
	    	  return false;
	      }
	      
	  }

	public static void main(String[] args) {
		System.out.println(solution("a234"));
		System.out.println(solution("1234"));
	}

}
