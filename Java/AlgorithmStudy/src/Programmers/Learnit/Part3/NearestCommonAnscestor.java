/*
 * 2018-10-09 Tue
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 가장 가까운 공통 조상
 * DFS(스택 이용)
 * 
 * - 문제정의 -  
 * 루트가 있는 트리(rooted tree)가 주어지고, 그 트리 상의 두 정점이 주어질 때 그들의 가장 가까운 공통 조상(Nearest Common Anscestor)은 다음과 같이 정의됩니다.
 * 두 노드의 가장 가까운 공통 조상은, 두 노드를 모두 자손으로 가지면서 깊이가 가장 깊은(즉 두 노드에 가장 가까운) 노드를 말합니다.
 * 예를 들어 15와 11를 모두 자손으로 갖는 노드는 4와 8이 있지만, 그 중 깊이가 가장 깊은(15와 11에 가장 가까운) 노드는 4 이므로 가장 가까운 공통 조상은 4가 됩니다.
 * 트리에 대한 정보를 담은 2차원 배열 tree, 가장 가까운 조상을 구할 두 노드 x, y가 매개변수로 주어질 때, 
 * 가장 가까운 공통 조상을 return하도록 solution함수를 작성해주세요.
 *
 *  
 * - 제한사항 - 
 * 트리를 구성하는 노드의 수는 2 이상 10,000 이하입니다.
 * tree 배열의 행의 수는 (트리를 구성하는 노드의 수 - 1) 입니다.
 * tree의 각 행 [A, B]의 의미는 A가 B의 조상이라는 의미입니다.
 * x, y는 서로 다른 정수이며 1 이상 (트리를 구성하는 노드의 수) 이하입니다.
 * 
 * - 출력 -
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 * 
 * ex1) 
 * 입력 tree : {{2, 3}, {3, 4}, {3, 1}, {1, 5}}
 * 입력 x : 3
 * 입력 y : 5	
 * 출력 : 3
 * 
 * 
 * 
 */

package Programmers.Learnit.Part3;

import java.util.Stack;

public class NearestCommonAnscestor {
	public static void dfs(int now, Stack<Integer> st, int graph[][]) {
		// 주소록을 확인하면서 stack에 적립
		for(int i = 0; i < graph.length; i++) {
			// 자식 노드가 현재 위치일 때 부모 노드를 스택에 저장 후 현재위치로 바꿈
			if(graph[i][1] == now) {
				st.push(graph[i][0]);
				dfs(graph[i][0], st, graph);
			}
		}
	}
	
	public static int solution(int[][] graph, int first, int last) {
		
		// 1. 변수 생성 
		Stack<Integer> stFirst = new Stack<Integer>();	// first의 조상을 순서대로 저장
		Stack<Integer> stLast = new Stack<Integer>();	// last의 조상을 순서대로 저장 
		int answer = 0;
		
		// 2. 각 출발지에서의 조상을 순서대로 스택에 저장
		stFirst.push(first);
		stLast.push(last);
		dfs(first, stFirst, graph);
		dfs(last, stLast, graph);
		
		System.out.println(stFirst.toString());
		System.out.println(stLast.toString());
		
		int isAnswer = -1;	// stFirst의 맨 위에 값을 임시 저장할 변수
		
		// stFirst의 맨 위에서부터 꺼내가며 stLast와 겹치는지 확인
		// 가장 가까운 조상은 스택의 아래쪽에 있을 것이기 때문에 stFirst가 빌때까지 계속해서 확인
		while(!stFirst.isEmpty()) {
			isAnswer = stFirst.pop();
			if(stLast.contains(isAnswer)) {
				answer = isAnswer;
			} else {
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] a = {{2, 3}, {3, 4}, {3, 1}, {1, 5}};
		System.out.println(solution(a, 3, 5));
	}

}
