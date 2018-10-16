/*
 * 2018-10-15 Mon
 * 알고리즘 문제해설 - 나머지 한 점
 * 
 * - 문제정의 -  
 * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 
 * 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 
 * 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 
 * 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
 *
 *  
 * - 제한사항 - 
 * v는 세 점의 좌표가 들어있는 2차원 배열입니다.
 * v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
 * 좌표값은 1 이상 10억 이하의 자연수입니다.
 * 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.

 * 
 * ex1) 
 * 입력 v : {{1, 4}, {3, 4}, {3, 10}};
 * 출력 result : {1, 10}
 * 
 * ex1) 
 * 입력 v : {{1, 1}, {2, 2}, {1, 2}}
 * 출력 result : {2, 1}
 * 
 * 
 * 
 */

package Programmers.ExplanationLecture;

import java.util.HashMap;
import java.util.Map;

// 직사각형을 만들기 위해서는 모든 좌표가 2개씩 나와야 한다.
public class RemainPoint2 {
	public static int[] solution(int[][] v) {
		// 각각 x좌표와 y좌표를 담을 맵을 생성
		Map<Integer, Integer> xPoint = new HashMap<Integer, Integer>();
		Map<Integer, Integer> yPoint = new HashMap<Integer, Integer>();
		// 정답배열
		int[] answer = new int [2];
		
		// 각각의 좌표를 키로 두고 좌표가 이미 맵에 있으면 +1을 한다.
		for(int i = 0; i < v.length; i++) {
			if(xPoint.containsKey(v[i][0])) {
				xPoint.put(v[i][0], xPoint.get(v[i][0]) + 1);
			} else {
				xPoint.put(v[i][0], 1);
			}
			
			if(yPoint.containsKey(v[i][1])) {
				yPoint.put(v[i][1], yPoint.get(v[i][1]) + 1);
			} else {
				yPoint.put(v[i][1], 1);
			}
		}
		
		// 좌표가 1번만 나온 값을 찾는다.
		for(Integer x : xPoint.keySet()) {
			if(xPoint.get(x) == 1) {
//				System.out.println(x);
				answer[0] = x;
			}
		}
		
		for(Integer y : yPoint.keySet()) {
			if(yPoint.get(y) == 1) {
//				System.out.println(y);
				answer[1] = y;
			}
		}
		
//		for(int i = 0; i < answer.length; i++) {
//			System.out.print(answer[i] + " ");
//		}
		
        return answer;
    }

	public static void main(String[] args) {
		int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		System.out.println(solution(v));
		int[][] y = {{1, 1}, {2, 2}, {1, 2}};
		System.out.println(solution(y));
	}

}
