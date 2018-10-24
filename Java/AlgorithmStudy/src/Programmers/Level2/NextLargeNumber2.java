/*
 * 2018-10-24 Wed
 * Level2 - 다음 큰 숫자
 * 
 * - 문제정의 -  
 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 *
 *  
 * - 제한사항 - 
 * n은 1,000,000 이하의 자연수 입니다.
 * 
 * ex1) 
 * 입력 : 78
 * 출력 : 83
 * 
 * ex2) 
 * 입력 : 15
 * 출력 : 23
 * 
 */

// Integer.bitCount() 메소드를 이용하여 보다 쉽게 해결
package Programmers.Level2;

public class NextLargeNumber2 {
	public static int solution(int n) {
//	      System.out.println(Integer.toBinaryString(n));

		// 비교할 수를 저장
		int comp = n + 1;
		
		// Integer.bitCount()메소드를 이용해서 1의 갯수를 셈
		int nCount = Integer.bitCount(n);
//	      System.out.println(nCount);
		
		// 비교하는 수의 1의 갯수와 인풋값의 1의 갯수가 같으면 리턴
		while (true) {
			int compCount = Integer.bitCount(comp);
			if (nCount == compCount) {
				break;
			}
			comp++;
		}
		return comp;
	}

	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}

}
