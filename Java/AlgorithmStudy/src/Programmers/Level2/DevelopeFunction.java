/*
 * 2018-10-21 Sun
 * Level2 - 기능개발
 * 
 * - 문제정의 -  
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 
 * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 각 배포마다 
 * 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 *  
 * - 제한사항 - 
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 * 
 * ex1) 
 * 입력 progresses : {93,30,55};
 * 입력 speeds : {1,30,5};
 * 출력 : {2, 1}
 * 
 */

package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DevelopeFunction {
	public static int[] solution(int[] progresses, int[] speeds) {
		// 변수 입력
		int N = progresses.length;
		int[] day = new int[N];
		Stack<Integer> reverseDay = new Stack<Integer>();
		List<Integer> ans = new ArrayList<Integer>();
		
		// 남은 작업일수 계산
		for(int i = 0; i < N; i++) {
			day[i] = ((int) Math.ceil((double) (100-progresses[i]) / speeds[i]));
		}
		
		// 앞의 작업일수가 더 많이 남을 경우 뒤의 작업이 빨리 끝나도 기다려야 하기 때문에 앞의 작업일수와 같은 날짜로 맞춤
		int remain = 0;
		for(int i = 0; i < N; i++) {
			if(remain < day[i]) {
				remain = day[i];
			} else {
				day[i] = remain;
			}
		}
		
		// 스택사용을 위해 계산한 작업일수를 반대로 저장
		reverseDay.push(-1);
		for(int i = N-1; i >= 0; i--) {
			reverseDay.push(day[i]);
		}
		
//		System.out.println(reverseDay.toString());
		
		// 스택에서 값을 꺼내면서 같으면 카운트를 더하고 다르면 정답배열에 저장하며 카운트 초기화
		int count = 0;
		remain = day[0];
		while(!reverseDay.isEmpty()) {
			int temp = reverseDay.pop();
//			System.out.println("remain : " + remain);
//			System.out.println("temp : " + temp);
			if(remain == temp) {
				count++;
			} else {
				ans.add(count);
				count = 1;
			}
			remain = temp;
		}
		int[] answer = new int[ans.size()];
		
//		System.out.println(ans.toString());
		for(int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
//		System.out.println(Arrays.toString(day));
		
        return answer;
    }

	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(solution(progresses, speeds));
	}

}
