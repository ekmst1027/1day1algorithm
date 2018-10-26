/*
 * 2018-10-25 Thu
 * Level2 - 탑
 * 
 * - 문제정의 -  
 * Finn은 요즘 수학공부에 빠져 있습니다. 
 * 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 
 * 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
 * 1 + 2 + 3 + 4 + 5 = 15
 * 4 + 5 + 6 = 15
 * 7 + 8 = 15
 * 15 = 15
 * 자연수 n이 매개변수로 주어질 때, 
 * 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 *  
 * - 제한사항 - 
 * n은 10,000 이하의 자연수 입니다.
 * 
 * ex1) 
 * 입력 n : 15;	
 * 출력 : 4;
 * 
 */

package Programmers.Level2;

public class NumberExpression {
	
	public static int solution(int n) {
		// 정답 카운트
		int count = 0;
		// 시작 인덱스
		int start = 1;
		
		// 반복문을 돌 동안 1부터 차례대로 n까지 더하며 합이 n일 경우 카운트를 증가하고
		// n보다 클 경우 바로 반복문을 빠져나와서 그 다음 시작인덱스부터 다시 더해간다.
		while(true) {
			int sum = 0;
			for(int i = start; i <= n; i++) {
//				System.out.println("start : " + start );
//				System.out.println("i : " + i);
				sum += i;
//				System.out.println("sum : " + sum);
				// 합이 n과 같을 경우 카운트도 증가시키고 시작인덱스도 증가시킨다. 
				// 그리고 반복문을 빠져나간다. 
				if(sum == n) {
					start++;
					count++;
//					System.out.println("카운트 올라감");
					break;
				// 합이 n보다 클 경우 더이상 볼 필요가 없으므로 시작인덱스를 증가시키고 반복문을 빠져나간다.
				} else if(sum > n) {
					start++;
					break;
				}
			}
			// 시작 인덱스가 n보다 클 경우 최종적으로 반복문을 빠져나간다.
			if(start > n) {
				break;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(21));
	}

}
