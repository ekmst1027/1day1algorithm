/*
 * 2018-10-19 Fri
 * 백준 - 문자열 사용하기 - 상수(2908)
 * 
 * - 문제정의 -  
 * 상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다. 
 * 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 
 * 상근이는 세 자리 숫자 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
 * 상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 
 * 예를 들어, 734과 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 
 * 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
 * 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
 *
 * - 입력 - 
 * 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다. 
 *
 * - 출력 - 
 * 첫째 줄에 상수의 대답을 출력한다.
 * 
 * ex1)
 * 입력 : 734 893
 * 출력 : 437
 * 
 *
 */

package BaekJoon.String;

import java.util.Scanner;

public class Constant {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// 변수 생성 및 문제 풀이
		// 각각의 수를 뒤집은 다음 더 큰 수를 가져옴
		int mod1 = 0;
		String reverse1 = "";
		while(num1 > 0) {
			mod1 = num1 % 10;
			num1 /= 10;
			reverse1 += String.valueOf(mod1);
		}
		
		int mod2 = 0;
		String reverse2 = "";
		while(num2 > 0) {
			mod2 = num2 % 10;
			num2 /= 10;
			reverse2 += String.valueOf(mod2);
		}
		
		System.out.println(Math.max(Integer.parseInt(reverse1), Integer.parseInt(reverse2)));
	}

}
