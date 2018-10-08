/*
 * 2018-10-09 Tue
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 모든 순열 
 * 백트래킹
 * 
 * - 문제정의 -  
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 *
 *  
 * - 입력 - 
 * 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
 * 
 * - 출력 -
 * 첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.
 * 
 * ex1) 
 * 입력 : 3
 * 출력 : 1 2 3
 * 		 1 3 2
 * 		 2 1 3
 * 		 2 3 1
 * 		 3 1 2
 * 		 3 2 1
 * 
 * 
 */

package Programmers.Learnit.Part2;

import java.util.Scanner;

public class Permutation {
	static int N;
	static int[] arr;
	static int[] visited;
	
	public static void btr(int cnt) {
		// 3-1. 탈출 조건
		if(cnt == N) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// 3-2. 가지치기
		
		// 3-3. 반복하며 백트래킹
		for(int i = 1; i <= N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				arr[cnt] = i;
				cnt++;
				btr(cnt);
				cnt--;
				arr[cnt] = 0;
				visited[i] = 0;
				
			}
		}
	}

	public static void main(String[] args) {
		// 1. 입력부
		Scanner sc = new Scanner(System.in);
		
		// 2. 변수 생성
		int n = sc.nextInt();	// 유일하게 입력받을 값
		N = n;
		arr = new int[N];	// 값을 저장할 배열
		visited = new int[N+1];	// 중복을 피하기 위한 배열
		int cnt = 0;	// 인덱스
		
		// 3. 백트래킹
		btr(cnt);
	}
}
