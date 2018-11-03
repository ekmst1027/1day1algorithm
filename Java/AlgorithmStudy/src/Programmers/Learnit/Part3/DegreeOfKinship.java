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

import java.util.Scanner;
import java.util.Stack;

public class DegreeOfKinship {
	public static void dfs(int now, Stack<Integer> st, int[][] relation) {
		for(int i = 0; i < relation.length; i++) {
			if(relation[i][1] == now) {
				st.push(relation[i][0]);
				dfs(relation[i][0], st, relation);
			}
		}
	}
	
	public static int solution(int n, int[][] relation, int x, int y) {
		// 변수 생성(스택 생성)
		Stack<Integer> stFirst = new Stack<Integer>();
		Stack<Integer> stLast = new Stack<Integer>();
		
		// 스택에 값을 저장 및 재귀 호출
		stFirst.push(x);
		stLast.push(y);
		dfs(x, stFirst, relation);
		dfs(y, stLast, relation);
		
//		System.out.println(stFirst.toString());
//		System.out.println(stLast.toString());
		
		// 첫번재 스택을 복사
		Stack<Integer> stFirstCopy = (Stack<Integer>) stFirst.clone();
		
		int answer = 0;	// 가장 가까운 조
		int isAnswer = -1;	// 가장 가까운 조상을 구할 임시변수
		
		// 복사한 스택이 빌때까지 두 스택의 가장 가까운 조상을 구함
		while(!stFirstCopy.isEmpty()) {
			isAnswer = stFirstCopy.pop();
			if(stLast.contains(isAnswer)) {
				answer = isAnswer;
			}
		}
		
		// 촌수를 구하지 못할 경우 -1을 리턴
		if(answer == 0) {
			return -1;
		}
		
		// 가장 가까운 조상이 위치한 인덱스를 구해서 더함 
		int xDistant = stFirst.indexOf(answer);
		int yDistant = stLast.indexOf(answer);
//		System.out.println("x : " + xDistant);
//		System.out.println("y : " + yDistant);
//		
//		System.out.println(xDistant+ yDistant);
		
		
        return xDistant+ yDistant;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[m][2];
		for(int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		System.out.println(solution(n, arr, x, y));
		
//		int[][] a = {{1, 2}, {1, 3}, {2, 7}, {2, 8}, {2, 9}, {4, 5}, {4, 6}};
//		System.out.println(solution(9, a, 7, 3));
		
	}

}
