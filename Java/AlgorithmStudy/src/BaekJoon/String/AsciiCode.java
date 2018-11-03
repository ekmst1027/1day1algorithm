/*
 * 2018-10-15 Mon
 * 백준 - 문자열 사용하기 - 아스키코드(11654)
 * 
 * - 문제정의 -  
 * 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
 *
 * - 입력 - 
 * 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다. 
 *
 * - 출력 - 
 * 입력으로 주어진 글자의 아스키 코드 값을 출력한다.
 * 
 * ex1)
 * 입력 : A
 * 출력 : 65
 * 
 * ex2)
 * 입력 : C
 * 출력 : 67
 * 
 * ex3)
 * 입력 : 0
 * 출력 : 48
 * 
 * ex4)
 * 입력 : 9
 * 출력 : 57
 * 
 * ex5)
 * 입력 : a
 * 출력 : 97
 * 
 * ex6)
 * 입력 : z
 * 출력 : 122
 * 
 *
 */

package BaekJoon.String;

import java.util.Scanner;

public class AsciiCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 먼저 문자로 받아서 아스키 코드로 변환하기
		String str = sc.next();
		char ch = str.charAt(0);
		System.out.println((int) ch);
	}
}
