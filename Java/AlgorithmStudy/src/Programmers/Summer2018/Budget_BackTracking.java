/*
 * 2018-10-09 Tue
 * 2018년 프로그래머스 써머코딩 문제 - 예산(난이도1)
 * 완전탐색으로 시도(백트래킹 버전)
 * 로직은 맞으나 런타임 에러로 실패 ㅠㅠ
 * 
 * - 문제정의 -  
 * S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다. 
 * 그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다. 
 * 그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.
 * 물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다. 
 * 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
 * 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 
 * 최대 몇 개의 부서에 물품을 지원해 줄 수 있는지 return 하도록 solution 함수를 완성해주세요.
 *
 *  
 * - 제한사항 - 
 * d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
 * d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
 * budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
 * 물품을 구매해 줄 수 있는 부서 개수의 최댓값을 return 하세요.
 * 
 * ex1) 
 * 입력 d : {1,3,2,5,4}	
 * 입력 budget : 9
 * 출력 : 3
 * 
 * ex2) 
 * 입력 d : {2,2,3,3}
 * 입력 budget : 10 
 * 출력 : 4
 * 
 */

package Programmers.Summer2018;

import java.util.Arrays;

public class Budget_BackTracking {
	static int N;
	static int[] arr;
	static int[] visited;
	static int budgets;
	static int max;

	public static int solution(int[] d, int budget) {

		// 변수 생성
		arr = d;	// 부서별 신청 예산 배열
		int sum = 0;	// 신청 예산의 합
		int cnt = 0; // 부서의 수
		visited = new int[d.length+1];
		budgets = budget;
		max = 0;
		
		// 백트래킹 
		btr(cnt, sum);
		
		return max;
	}

	public static void btr(int cnt, int sum) {
		// 탈출 조건
		if(sum > budgets) {
			return;
		}
		
		// 출력
		System.out.println("====================================");
		System.out.println("sum : " + sum);
		System.out.println("cnt : " + cnt);
		if(max < cnt) {
			max = cnt;
		}
		
		
		// 반복하며 백트래킹 
		for(int i = 0; i < arr.length; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				sum += arr[i];
				cnt++;
				btr(cnt, sum);
				cnt--;
				sum -= arr[i];
				visited[i] = 0;				
			}
		}

	}

	public static void main(String[] args) {
//		int a[] = { 1, 3, 2, 5, 4 };
//		System.out.println(solution(a, 9));
		int b[] = { 2, 2, 3, 3 };
		System.out.println(solution(b, 10));

	}

}
