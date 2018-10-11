/*
 * 2018-10-12 Fri
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 바이러스
 * BFS
 * 
 * - 문제정의 -  
 * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 
 * 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 * 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
 * 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 
 * 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
 * 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
 * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 알고 싶다.
 * 컴퓨터의 수 computer, 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍이 담긴 2차원 배열 pair가 매개변수로 주어질 때, 
 * 1번 컴퓨터에 의해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 return 하도록 solution 함수를 작성하시오.
 *
 * - 제한사항 -
 * 컴퓨터의 수는 1대 이상 100대 이하이다.
 * 컴퓨터의 쌍은 1개 이상 ((컴퓨터의 수 - 1) * 컴퓨터의 수) / 2 개 이하이다.
 * pair의 각 행 [A, B]는 A와 B 컴퓨터가 연결되어 있다는 의미이다.
 *  
 * - 입력 - 
 * 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. 
 * N과 K는 정수이다.
 * 
 * - 출력 - 
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 * 
 * ex1) 
 * 입력 computer : 7
 * 입력 pair : {{1, 2}, {2, 3}, {1, 5}, {5, 2}, {5, 6}, {4, 7}}
 * 출력 : 4
 * 
 * 
 * 
 */

package Programmers.Learnit.Part4;

import java.util.LinkedList;
import java.util.Scanner;

public class Virus {
	public static int solution(int computer, int[][] pair) {
		// 변수 생성
		LinkedList<Integer> que = new LinkedList<Integer>();	// 연결된 노드를 담을 큐
		int[] visited = new int[computer+1];	// 연결된 노드를 표시할 배열
		int count = 0;	// 연결된 노드 수
		que.add(1);	// 초기값 할당
		visited[1] = 1;	// 초기값 할당
		
		// 큐가 비어있을 때까지 연결된 노드를 찾아다니면서 연결된 노드가 있을 경우 카운트 추가
		while(!que.isEmpty()) {
			int temp = que.pop();
//			System.out.println("temp : " + temp);
//			System.out.println("count : " + count);
//			System.out.println(Arrays.toString(visited));
			for(int i = 0; i < pair.length; i++) {
				if(pair[i][0] == temp && visited[pair[i][1]] == 0) {
					visited[pair[i][1]] = 1;
					que.add(pair[i][1]);
					count++;
				} else if(pair[i][1] == temp && visited[pair[i][0]] == 0) {
					visited[pair[i][0]] = 1;
					que.add(pair[i][0]);
					count++;
				}
			}
		}
		
//		System.out.println(Arrays.toString(visited));
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt();
		int n = sc.nextInt();
		int[][] pair = new int[n][2];
		for(int i = 0; i < n; i++) {
			pair[i][0] = sc.nextInt();
			pair[i][1] = sc.nextInt();
		}
		System.out.println(solution(computer, pair));
		
	}

}
