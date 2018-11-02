/*
 * 2018-10-12 Fri
 * 2017년 프로그래머스 써머코딩 문제 - 소수만들기(난이도2)
 * BFS
 * 
 * - 문제정의 -  
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
 * nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
 * 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * - 제한사항 -
 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * nums의 각 원소는 1 이상 1000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 *  
 * ex1) 
 * 입력 nums : {1,2,3,4}
 * 출력 : 1
 * 
 * ex2) 
 * 입력 nums : {1,2,7,6,4}	
 * 출력 : 4
 * 
 * 
 * 
 */

package Programmers.Summer2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
	static int visited[];
	static int N;
	static int arr[];
	static List<Integer> arrList;
	
	public static void btr(int cnt, int sum) {
		
		if(cnt == 3) {
			System.out.println(Arrays.toString(visited));
			System.out.println(sum);
			arrList.add(sum);
			return;
		}
		
		if(arrList.contains(sum)) {
			return;
		}
		
		
		for(int i = cnt; i < N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				cnt++;
				sum += arr[i];
				btr(cnt, sum);
				sum -= arr[i];
				cnt--;
				visited[i] = 0;
			}
		}
	}
	
	public static int solution(int[] nums) {
		// 변수 생성
		N = nums.length;
		visited = new int[N];
		arr = nums;
		int cnt = 0;
		int sum = 0;
		arrList = new ArrayList<Integer>();
		System.out.println("N : " + N);
		
		btr(cnt, sum);
		
		int answer = -1;

        return answer;
    }

	public static void main(String[] args) {
//		int[] nums = {1,2,3,4};
//		System.out.println(solution(nums));
		int[] num2 = {1,2,7,6,4};
		System.out.println(solution(num2));
	}

}
