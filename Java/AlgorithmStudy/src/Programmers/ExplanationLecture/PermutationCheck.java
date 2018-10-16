/*
 * 2018-10-15 Mon
 * 알고리즘 문제해설 - 순열 검사
 * 
 * - 문제정의 -  
 * 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
 * 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 
 * 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.
 *
 *  
 * - 제한사항 - 
 * 배열의 길이는 10만 이하입니다.
 * 배열의 원소는 0 이상 10만 이하인 정수입니다.
 * 
 * ex1) 
 * 입력 arr : {4, 1, 3, 2}
 * 출력 : true
 * 
 * ex2) 
 * 입력 arr : {4, 1, 3}
 * 출력 : false
 * 
 * 
 * 
 */

package Programmers.ExplanationLecture;

import java.util.Arrays;

public class PermutationCheck {
	public static boolean solution(int[] arr) {
		// 오름차순 정렬
		Arrays.sort(arr);
		
		// 우선 길이가 맞는지 확인
        if(arr.length != arr[arr.length-1]) {
        	return false;
        }
        
        // 1씩 더하면서 아닌 경우 false 반환
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++) {
        	if((temp + 1) == arr[i]) {
        		temp = arr[i];
        	} else {
        		return false;
        	}
        }

        return true;
    }

	public static void main(String[] args) {
		int[] arr1 = {4,1,3,2};
		int[] arr2 = {4,1,3};
		
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
	}

}
