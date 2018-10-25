/*
 * 2018-10-25 Thu
 * Level2 - 탑
 * 
 * - 문제정의 -  
 * 수평 직선에 높이가 서로 다른 탑 N대를 세웠습니다. 
 * 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다. 
 * 발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신합니다. 
 * 또한, 한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.
 * 예를 들어 높이가 6, 9, 5, 7, 4인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다. 
 * 그러면, 탑은 다음과 같이 신호를 주고받습니다. 
 * 높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑이 수신하고, 
 * 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다. 
 * 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신할 수 없습니다.
 * 맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때 
 * 각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return 하도록 solution 함수를 작성해주세요.
 *  
 * - 제한사항 - 
 * heights는 길이 2 이상 100 이하인 정수 배열입니다.
 * 모든 탑의 높이는 1 이상 100 이하입니다.
 * 신호를 수신하는 탑이 없으면 0으로 표시합니다.
 * 
 * ex1) 
 * 입력 height : {6,9,5,7,4};	
 * 출력 : {0,0,2,2,4};
 * 
 * ex2) 
 * 입력 height : {3,9,9,3,5,7,2};	
 * 출력 : {0,0,0,3,3,3,6};
 * 
 * ex3) 
 * 입력 height : {1,5,3,6,7,6,5};	
 * 출력 : {0,0,2,0,0,5,6};
 * 
 */

package Programmers.Level2;

public class Tower {
	public static int[] solution(int[] heights) {
		// 배열 길이를 저장
		int N = heights.length;
		// 정답 배열
		int[] answer = new int[N];

		// 2중 포문을 돌면서 앞에 더 큰 수가 있으면 정답 배열에 넣고 바로 브레이크
		for(int i = N-1; i >= 1; i--) {
			for(int j = i-1; j >= 0; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j+1;
					break;
				}
			}
		}
		
        return answer;
    }

	public static void main(String[] args) {
//		int[] height1 = {6,9,5,7,4};
//		System.out.println(solution(height1));
		int[] height2 = {3,9,9,3,5,7,2};
		System.out.println(solution(height2));
	}

}
