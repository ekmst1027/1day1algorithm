/*
 * 2018-10-30 Tue
 * Level1 - 같은 숫자는 싫어
 * 
 * - 문제정의 -  
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
 * 배열 arr에서 제거 되고 남은 수들을 return 하는 solution 함수를 완성해 주세요. 
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
 * 예를들면
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 * 
 * - 제한사항 -
 * 배열 arr의 크기 : 1,000,000 이하의 자연수
 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 * 
 * ex1)
 * 입력 : {1,1,3,3,0,1,1}	
 * 출력 : {1,3,0,1}
 * 
 * ex2)
 * 입력 : {4,4,4,3,3}
 * 출력 : {4,3}
 * 
 * 
 */

package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class AvoidSameNumber {
	public static int[] solution(int []arr) {
		List<Integer> aList = new ArrayList<Integer>();
        
		int prev = arr[0];
		aList.add(prev);
        for(int i = 1; i < arr.length; i++) {
        	if(prev != arr[i]) {
        		prev = arr[i];
        		aList.add(prev);
        	}
        }
        int[] answer = new int[aList.size()];
        
        for(int i = 0; i < aList.size(); i++) {
        	answer[i] = aList.get(i);
        }

        return answer;
	}

	public static void main(String[] args) {
		int[] a1 = {1,1,3,3,0,1,1,2};
		System.out.println(solution(a1));
		int[] a2 = {4,4,4,3,3};
		System.out.println(solution(a2));
	}

}
