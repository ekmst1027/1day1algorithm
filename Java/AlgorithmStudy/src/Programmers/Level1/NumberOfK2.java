/*
 * 2018-10-10 Wed
 * Level1 - k번째 수
 * 
 * - 문제정의 -  
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
 * commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 
 * 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 *  
 * - 제한사항 - 
 * array의 길이는 1 이상 100 이하입니다.
 * array의 각 원소는 1 이상 100 이하입니다.
 * commands의 길이는 1 이상 50 이하입니다.
 * commands의 각 원소는 길이가 3입니다.
 * 
 * ex1) 
 * 입력 array : {1, 5, 2, 6, 3, 7, 4}
 * 입력 commands : {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}	
 * 출력 : {5, 6, 3}
 * 
 */

// CopyOfRange함수를 쓰면 더 간단하게 풀 수 있음
package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfK2 {
	public static int[] solution(int[] array, int[][] commands) {
		// commands.length 길이 만큼의 정답 배열
		int answer[] = new int[commands.length];
		for(int i = 0; i < commands.length; i++) {
			// 원본 배열에서 시작 인덱스와 종료 인덱스를 지정해서 부분 배열 가져오기
			int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			// 정렬
			Arrays.sort(temp);
			// 문제에서 원하는 답 가져오기
			answer[i] = temp[commands[i][2]-1];
//			System.out.println(Arrays.toString(temp));
		}
		System.out.println(Arrays.toString(answer));
		
		
        return answer;
    }

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(solution(array, commands));
	}

}
