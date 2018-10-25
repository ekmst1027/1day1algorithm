/*
 * 2018-10-25 Thu
 * Level1 - 모의고사
 * 
 * - 문제정의 -  
 * 수포자는 수학을 포기한 사람의 준말입니다. 
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 *  
 * - 제한사항 - 
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 
 * ex1) 
 * 입력 answer : {1,2,3,4,5}	
 * 출력 : {1}
 * 
 * ex2) 
 * 입력 answer : {1,3,2,4,2}	
 * 출력 : {1,2,3}
 * 
 */

package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockTest {
	
	public static int[] solution(int[] answers) {
		int N = answers.length;
		
		List<Integer> ansList = new ArrayList<Integer>();
		
		// 각각 해당하는 케이스대로 해당하는 배열을 만들어서 저장
		int[] supo1 = new int[N];
		for(int i = 0; i < N; i++) {
			supo1[i] = (i%5)+1;
		}
		
		int[] supo2 = new int[N];
		int count = 1;
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) {
				supo2[i] = 2;
			} else {
				if(count > 5) {
					count = 1;
				} else if(count == 2) {
					count++;
				}
				supo2[i] = count;
				count++;
			}
		}
		
		int[] supo3 = new int[N];
		int[] supo3Ans = {3,3,1,1,2,2,4,4,5,5};
		count = 0;
		for(int i = 0; i < N; i++) {
			if(count == supo3Ans.length)
				count = 0;
			supo3[i] = supo3Ans[count++];
		}
		
		System.out.println(Arrays.toString(supo1));
		System.out.println(Arrays.toString(supo2));
		System.out.println(Arrays.toString(supo3));
		
		// 답지와 찍은답이 얼마나 맞는지 비교하며 카운트를 센다
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(int i = 0; i < N; i++) {
			if(answers[i] == supo1[i]) {
				count1++;
			}
			if(answers[i] == supo2[i]) {
				count2++;
			}
			if(answers[i] == supo3[i]) {
				count3++;
			}
		}
		
//		System.out.println("count1 : " + count1);
//		System.out.println("count2 : " + count2);
//		System.out.println("count3 : " + count3);
		
		// Math.max()를 이용하면 훨씬 간단
		// 각 카운트 센거를 비교해서 경우의 수대로 리스트에 저장
		if(count1 > count2) {
			if(count1 > count3) {
				ansList.add(1);
			} else if(count1 == count3) {
				ansList.add(1);
				ansList.add(3);
			} else {
				ansList.add(3);
			}
		} else if(count1 < count2) {
			if(count2 > count3) {
				ansList.add(2);
			} else if(count2 == count3) {
				ansList.add(2);
				ansList.add(3);
			} else {
				ansList.add(3);
			}
		} else if(count1 == count2) {
			if(count1 > count3) {
				ansList.add(1);
				ansList.add(2);
			} else if(count1 < count3) {
				ansList.add(3);
			} else {
				ansList.add(1);
				ansList.add(2);
				ansList.add(3);
			}
		}
		
		// 정렬 후 리턴
		Collections.sort(ansList);
		
		int[] answer = new int[ansList.size()];
		for(int i = 0; i < ansList.size(); i++) {
			answer[i] = ansList.get(i);
		}
        return answer;
    }

	public static void main(String[] args) {
		int[] answer = {1,2,3,4,5}; //,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,};
		System.out.println(solution(answer));
//		int[] answer2 = {1,3,2,4,2};
//		System.out.println(solution(answer2));
	}

}
