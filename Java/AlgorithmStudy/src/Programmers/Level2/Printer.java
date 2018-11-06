/*
 * 2018-11-6 Tue
 * Level2 - 프린터 - 스택/큐 
 * 
 * - 문제정의 -  
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 
 * 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
 * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 
 * 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 * 
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 * 
 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 
 * 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 
 * 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 
 * 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 * 
 * - 제한사항 -
 * 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
 * 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
 * location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 
 * 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
 * 
 * ex1)
 * 입력 priority : {2, 1, 3, 2}
 * 입력 location : 2
 * 출력 : 1
 * 
 * ex2)
 * 입력 priority : {1, 1, 9, 1, 1, 1}	
 * 입력 location : 0
 * 출력 : 5
 * 
 * 
 */

package Programmers.Level2;

import java.util.LinkedList;
import java.util.Stack;

public class Printer {
	public static int solution(int[] priorities, int location) {
		// 변수 생성 
		LinkedList<Integer> que = new LinkedList<Integer>(); // priorities 큐 
		LinkedList<Integer> order = new LinkedList<Integer>(); // priorities 인덱스 큐
		Stack<Integer> answer = new Stack<Integer>();	// 정답 스택
		//priorities의 값과 인덱스를 각각의 큐에 저장
		for(int i = 0; i < priorities.length; i++) {
			que.add(priorities[i]);
			order.add(i);
		}
//		System.out.println("order : " + order.toString());
//		System.out.println("que : " + que.toString());
		
		// 큐가 빌때까지 조건에 맞게 구현
		while(!que.isEmpty()) {
			// 해당하는 값과 인덱스를 큐에서 꺼냄
			int temp = que.pop();
			int tempOrder = order.pop();
			// 정답 스택에 인덱스를 미리 담아놓음 
			answer.add(tempOrder);
			
			// 나머지 큐의 값과 비교하며 더 큰 값이 있을 경우 맨 뒤로 보냄과 
			// 동시에 정답 스택에 담아놓은 인덱스도 함께 꺼냄
			for(int j = 0; j < que.size(); j++) {
				if(temp < que.get(j)) {
					que.add(temp);
					order.add(tempOrder);
					answer.pop();
					break;
				}
			}
//			System.out.println(que.toString());
		}
//		System.out.println(answer.toString());
		// 찾는 값이 있는 인덱스에서 + 1
		int answer1 = answer.indexOf(location) + 1;
		return answer1;
	}

	public static void main(String[] args) {
		int[] pr1 = {2, 1, 3, 2};
		System.out.println(solution(pr1, 2));
		int[] pr2 = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(pr2, 0));
		int[] pr3 = {2,2,2,1,3,4};
		System.out.println(solution(pr3, 3));
	}

}
