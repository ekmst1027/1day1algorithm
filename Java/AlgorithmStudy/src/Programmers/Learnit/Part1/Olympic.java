/*
 * 2018-10-07 Sun
 * Part1 - 논리구현 
 * 
 * - 문제정의 -  
 * 올림픽은 참가에 의의가 있기에 공식적으로는 국가간 순위를 정하지 않는다. 
 * 그러나, 많은 사람들이 자신의 국가가 얼마나 잘 하는지에 관심이 많기 때문에 비공식적으로는 국가간 순위를 정하고 있다.
 * 두 나라가 각각 얻은 금, 은, 동메달 수가 주어지면, 보통 다음 규칙을 따라 어느 나라가 더 잘했는지 결정한다.
 *  1. 금메달 수가 더 많은 나라
 *  2. 금메달 수가 같으면, 은메달 수가 더 많은 나라
 *  3. 금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
 * 각 국가는 1부터 N 사이의 정수로 표현된다. 
 * 한 국가의 등수는 (자신보다 더 잘한 나라 수) + 1로 정의된다. 
 * 만약 두 나라가 금, 은, 동메달 수가 모두 같다면 두 나라의 등수는 같다.
 * 예를 들어, 1번 국가가 금메달 1개, 은메달 1개를 얻었고, 2번 국가와 3번 국가가 모두 은메달 1개를 얻었으며, 
 * 4번 국가는 메달을 얻지 못하였다면, 1번 국가가 1등, 2번 국가와 3번 국가가 공동 2등, 4번 국가가 4등이 된다. 
 * 이 경우 3등은 없다.
 * 등수를 알고 싶은 국가 K, 각 국가를 나타내는 정수와 이 국가가 얻은 금, 은, 동메달의 수를 담은 배열 record가 매개변수로 주어질 때, 
 * K 국가가 몇 등을 했는지 알려주는 solution 함수를 작성하시오.
 * 
 * - 제한사항 - 
 * 1. 주어지는 국가의 개수는 1개 이상 1000개 이하입니다.
 * 2. 1 ≤ K ≤ record배열의 길이
 * 3. 이차원 배열 record의 각 행의 첫번째 값은 국가를 나타내는 정수, 두번째 값은 금메달의 수, 세번째 값은 은메달의 수, 
 * 	  네번째 값은 동메달의 수를 나타낸다. 전체 메달 수의 총합은 1,000,000 이하이다.
 * 
 * ex) 입력 k : 3
 * 	   입력 record : {{1, 1, 2, 0}, {2, 0, 1, 0}, {3, 0, 1, 0}, {4, 0, 0, 1}}	
 *     출력 : 2
 * 
 */

package Programmers.Learnit.Part1;

import java.util.Arrays;

public class Olympic {
	public static int solution(int K, int[][] record) {
		int[] bestOrder = new int[record.length+1];
		int order = 0;
		for(int i = 1; i < record[0].length; i++) {
			int maxMedal = 0;
			int bestNation = 0;
			for(int j = 0; j < record.length; j++) {
				if(bestOrder[j] == 0) {
					if(maxMedal < record[j][i]) {
						System.out.println(record[j][i]);
						maxMedal = record[j][i];
						bestNation = record[j][0];
					}
					bestOrder[bestNation] = ++order;
				}
			}
		}
		System.out.println(Arrays.toString(bestOrder));
        int answer = 0;
        return answer;
    }

	public static void main(String[] args) {
		int[][] arr = {{1, 1, 2, 0}, {2, 0, 1, 0}, {3, 0, 1, 0}, {4, 0, 0, 1}};
		System.out.println(solution(3, arr));

	}

}
