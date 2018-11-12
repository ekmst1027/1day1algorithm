/*
 * 2018-11-12 Mon
 * Level1 - x만큼 간격이 있는 n개의 숫자
 * 
 * - 문제정의 -  
 * 함수 solution은 정수 x와 자연수 n을 입력 받아, 
 * x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
 * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 * 
 * - 제한사항 -
 * x는 -10000000 이상, 10000000 이하인 정수입니다.
 * n은 1000 이하인 자연수입니다.
 * 
 * ex1)
 * 입력 x : 2
 * 입력 n : 5
 * 출력 : {2,4,6,8,10}
 * 
 * ex2)
 * 입력 x : 4
 * 입력 n : 3
 * 출력 : {4,8,12}
 * 
 * ex3)
 * 입력 x : -4
 * 입력 n : 2
 * 출력 : {-4,-8}
 * 
 */

package Programmers.Level1;

import java.util.Arrays;

public class TheNumberOfN {
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		long ans = x;
		for(int i = 0; i < n; i++) {
			answer[i] = ans;
			ans += x;
		}
//		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 5));
		System.out.println(solution(4, 3));
		System.out.println(solution(-4, 2));
	}

}
