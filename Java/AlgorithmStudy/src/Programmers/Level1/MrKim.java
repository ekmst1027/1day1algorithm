/*
 * 2018-11-4 Sun
 * Level1 - 서울에서 김서방 찾기
 * 
 * - 문제정의 -  
 * String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 
 * 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요. 
 * seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 * 
 * - 제한사항 -
 * seoul은 길이 1 이상, 1000 이하인 배열입니다.
 * seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
 * Kim은 반드시 seoul 안에 포함되어 있습니다.
 * 
 * ex1)
 * 입력 seoul : {"Jane", "Kim"}
 * 출력 : "김서방은 1에 있다."
 * 
 * 
 */

package Programmers.Level1;

public class MrKim {
	public static String solution(String[] seoul) {
		for(int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				return "김서방은 " + i + "에 있다";
			}
		}
		
		String answer = "";
		return answer;
	}

	public static void main(String[] args) {
		String[] a = { "Jane", "Kim" };
		System.out.println(solution(a));
	}

}
