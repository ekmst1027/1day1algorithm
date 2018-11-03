/*
 * 2018-10-11 Thu
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 숨바꼭질
 * BFS
 * 
 * - 문제정의 -  
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
 * 수빈이는 걷거나 순간이동을 할 수 있다. 
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 *  
 * - 입력 - 
 * 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. 
 * N과 K는 정수이다.
 * 
 * - 출력 - 
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 * 
 * ex1) 
 * 입력 : 5 17
 * 출력 : 4
 * 
 * 
 * 
 */

package Programmers.Learnit.Part4;

import java.util.LinkedList;
import java.util.Scanner;

public class HideAndSeek {
	public static void main(String[] args) {
		// 1. 입력부
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 수빈이의 위치
		int K = sc.nextInt();	// 동생의 위치
		
		// 2. 변수 생성 
		LinkedList<Integer> que = new LinkedList<Integer>();
		int[] visited = new int[100001];
		que.add(N);	// 초기값
		visited[N] = 0;
		int cnt = 1;
		
		while(!que.isEmpty()) {
			int temp = que.pop();
//			System.out.println("cnt : " + cnt);
//			System.out.println("temp : " + temp);
//			System.out.println("visited[temp] : " + visited[temp]);
			if(temp == K) {
				break;
			}
			// -1 이동
			if(temp -1 >= 0 && visited[temp-1] == 0) {
				que.add(temp-1);
				visited[temp-1] = visited[temp] + 1;
				
			}
			// +1 이동
			if(temp + 1 < 100001 && visited[temp+1] == 0) {
				que.add(temp+1);
				visited[temp+1] = visited[temp] + 1;
			}
			// *2 이동
			if(temp * 2 < 10001 && visited[temp*2] == 0 ) {
				que.add(temp*2);
				visited[temp*2] = visited[temp] + 1;
			}
		}
		System.out.println(visited[K]);
		
		
		
	}

}
