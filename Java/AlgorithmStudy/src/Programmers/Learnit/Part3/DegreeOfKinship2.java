/*
 * 2018-10-09 Tue
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 촌수계산
 * DFS(스택 이용)
 * 
 * - 문제정의 -  
 * 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 
 * 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 
 * 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 
 * 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
 * 전체 사람의 수 n, 부모 자식간의 관계를 담은 2차원 배열 relation, 촌수를 알고 싶은 두 사람 x, y가 매개변수로 주어질 때, 
 * 두 사람의 촌수를 return하도록 solution함수를 작성하시오.
 *
 *  
 * - 제한사항 - 
 * 사람들은 1, 2, 3, ..., n(1≤n≤100)의 연속된 번호로 표시된다.
 * relation의 각 행은 2개의 열로 이루어져 있으며 [A, B] 는 A가 B의 부모라는 의미이다.
 * x, y는 서로 다른 정수이며 1 이상 n 이하이다.
 * 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때에는 -1을 return 한다.
 * 
 * ex1) 
 * 입력 n : 9
 * 입력 tree : {{1, 2}, {1, 3}, {2, 7}, {2, 8}, {2, 9}, {4, 5}, {4, 6}}
 * 입력 x : 7
 * 입력 y : 3	
 * 출력 : 3
 * 
 * 
 * 
 */

package Programmers.Learnit.Part3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DegreeOfKinship2 {

	public static void main(String[] args) {
		// 1. 입력부
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int m = sc.nextInt();
		int[][] relation = new int[m][2];
		for(int i = 0; i < relation.length; i++) {
			relation[i][0] = sc.nextInt();
			relation[i][1] = sc.nextInt();
		}
		
		// 2. 변수 선언
		int visited[] = new int[n+1];
		Stack<Integer> st = new Stack<Integer>();
		// 문제의 요구조건을 만족하기 위해 visited를 -1로 채워넣는다.(촌수 계산을 위해)
		Arrays.fill(visited, -1);
		visited[x] = 0;	// x의 위치가 기준이기 때문에 0으로 초기화
		
		// 스택에 초기값 x를 넣는다
		st.push(x);
		
		int temp = 0;	// 스택에서 꺼낸 값을 저장할 임시 변수 
		
		while(!st.isEmpty()) {
			System.out.println(Arrays.toString(visited));
			temp = st.pop();
			for(int i = 0; i < m; i ++) {
				//주소록을 뒤져가면서 간선의 시작점이 스택에서 꺼낸 값과 같은지, 끝점이 방문하지 않은 점인지 확인(temp가 부모인 경우)
				if(relation[i][0] == temp && visited[relation[i][1]] == -1) {
					st.push(relation[i][1]);	// 스택에 집어 넣고
					visited[relation[i][1]] = visited[relation[i][0]] + 1;	// 촌수값을 1 증가시킨다
					
				// 반대로 간선의 끝점이 스택에서 꺼낸 값과 같고, 시작점이 방문하지 않은 점인지 확인(temp가 자식인 경우)
				} else if(relation[i][1] == temp && visited[relation[i][0]] == -1){
					st.push(relation[i][0]);
					visited[relation[i][0]] = visited[relation[i][1]] + 1;
				}
			}
		}
		System.out.println(visited[y]);
	}

}
