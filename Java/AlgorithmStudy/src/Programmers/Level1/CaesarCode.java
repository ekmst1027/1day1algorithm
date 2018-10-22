/*
 * 2018-10-22 Mon
 * Level1 - 시저 암호
 * 
 * - 문제정의 -  
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
 * 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 
 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 *
 *  
 * - 제한사항 - 
 * 공백은 아무리 밀어도 공백입니다.
 * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
 * s의 길이는 8000이하입니다.
 * n은 1 이상, 25이하인 자연수입니다.
 * 
 * ex1) 
 * 입력 s : "AB";
 * 입력 n : 1;
 * 출력 : "BC";
 * 
 * ex2) 
 * 입력 s : "z";
 * 입력 n : 1;
 * 출력 : "a";
 * 
 * ex3) 
 * 입력 s : "a B z";
 * 입력 n : 4;
 * 출력 : "e F d";
 * 
 * 
 */

package Programmers.Level1;

public class CaesarCode {
	public static String solution(String s, int n) {
		// 변수 생성
		String answer = "";	// 정답 배
		int[] arr = new int[s.length()];	// 아스키 코드를 저장할 배열
		
		// 각 문자에 해당하는 아스키코드를 정수 배열에 저장
		for(int i = 0; i < s.length(); i++) {
			arr[i] = (int) s.charAt(i);
		}
		
		// 대문자는 대문자에서 소문자는 소문자에서 돌게 설정
		// 대문자 소문자 이외에는 그냥 출력
		for(int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			if(temp >= 65 && temp <= 90) {
				temp = temp + n; 
				if(temp > 90) {
					temp = temp - 26;
				}
				answer += String.valueOf((char) temp);
			} else if(temp >= 97 && temp <= 122) {
				temp = temp + n;
				if(temp > 122) {
					temp = temp - 26;
				}
				arr[i] = temp;
				answer += String.valueOf((char) temp);
			} else {
				answer += String.valueOf((char) temp);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("AB", 1));
		System.out.println(solution("z", 1));
		System.out.println(solution("a B z", 4));
	}

}
