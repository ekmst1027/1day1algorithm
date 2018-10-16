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

//직사각형을 만들기 위해서는 모든 좌표가 2개씩 나와야 한다.
//XOR을 사용해서 같지 않은 좌표 1개를 출력한다.
public class RemainPoint2 {
	public static int[] solution(int[][] v) {
		int[] answer = {0, 0};
		
		for(int i = 0; i < v.length; i++) {
//			System.out.println("answer[0] : " + answer[0] + "  " + "v[i][0] : " + v[i][0]);
//			System.out.println(answer[0] ^ v[i][0]);
//			System.out.println("answer[1] : " + answer[1] + "  " + "v[i][1] : " + v[i][1]);
//			System.out.println(answer[1] ^ v[i][1]);
			answer[0] ^= v[i][0];
			answer[1] ^= v[i][1];
		}
		
//		System.out.println(Arrays.toString(answer));
		
     return answer;
 }

	public static void main(String[] args) {
		int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		System.out.println(solution(v));
		int[][] y = {{1, 1}, {2, 2}, {1, 2}};
		System.out.println(solution(y));
	}

}
