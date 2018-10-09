/*
 * 2018-10-09 Tue
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 연결 요소의 개수
 * DFS
 * 
 * - 문제정의 -  
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 *
 *  
 * - 입력 - 
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
 * (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
 * 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
 * (1 ≤ u, v ≤ N, u ≠ v) 
 * 같은 간선은 한 번만 주어진다.
 * 
 * - 출력 -
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 * 
 * ex1) 
 * 입력 : 6 5
 * 		 1 2
 * 		 2 5
 * 		 5 1
 * 		 3 4
 * 		 4 6
 * 출력 : 2
 * 
 * ex2) 
 * 입력 : 6 8
 * 		 1 2
 * 		 2 5
 * 		 5 1
 * 		 3 4
 * 		 4 6
 * 		 5 4
 *		 2 4
 * 		 2 3
 * 출력 : 1
 * 
 * 
 */


package Programmers.Learnit.Part3;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectedComponent {
	static int[][] graph;
	static int[] visited;
	static int N;
	static int M;
	static int Answer;

	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 노드의 수 
		M = sc.nextInt();	// 간선의 수
		graph = new int[M][2];	// 주소록 
		for(int i = 0; i < M; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
		}
		
		// 변수 생성
		visited = new int[N+1];
		Answer = 0;
		
		// 방문하지 않았던 점을 찾아가며 재귀호출
		for(int i = 0; i < M; i++) {
			// 연결되어 있는 두 노드 중 앞에 있는 노드에 방문하지 않았으면
			if(visited[graph[i][0]] == 0) {
				Answer++;
				dfs(graph[i][0]);	// 현재 있는 위치에서 재귀호출
			}
		}
		
		// 연결되지 않은 점들도 하나의 연결 요소로 생각하고 Answer에 더해줌
		for(int i = 1; i < N+1; i++) {
			if(visited[i] == 0) {
				Answer++;
			}
		}
		System.out.println(Answer);		
	}
	
	public static void dfs(int now) {
		// 방문한 점을 표시하고
		visited[now] = Answer;
		System.out.println(Arrays.toString(visited));
		// 주소록을 뒤지면서 재귀호출 
		for(int i = 0; i < M; i++) {
			// 간선 앞번호가 현재 위치면서 간선 뒷번호를 방문하지 않았을 때, 간선 뒷번호를 재귀호출
			if(visited[graph[i][1]] == 0 && graph[i][0] == now) {
				dfs(graph[i][1]);
			// 간선 뒷번호가 현재 위치면서 간선 앞번호를 방문하지 않았을 때, 간선 앞번호를 재귀호출
			} else if(visited[graph[i][0]] == 0 && graph[i][1] == now) {
				dfs(graph[i][0]);
			}
		}
	}

}
