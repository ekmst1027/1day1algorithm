/*
 * 2018-10-30 Tue
 * Level2 - 소수찾기
 * 
 * - 문제정의 -  
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
 * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * 
 * - 제한사항 -
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 
 * ex1)
 * 입력 : "17"
 * 출력 : 3
 * 
 * ex2)
 * 입력 : "011"
 * 출력 : 2
 * 
 * 
 */

package Programmers.Level2;

public class FindPrimeNumber {
	static int visited[];
	static int arr[];
	
	public static void btr(int idx, int sum) {
		if(idx == arr.length) {
			
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				sum += arr[i];
				idx++;
			}
		}
	}
	
	public static int solution(String numbers) {
		// 입력부
		arr = new int[numbers.length()];
		for(int i = 0; i < numbers.length(); i++) {
			arr[i] = numbers.charAt(i) - '0';
		}
		
		// 변수생성
		visited = new int[numbers.length()];
		int sum = 0;
		
		// 백트래킹
		for(int i = 0; i < numbers.length(); i++) {
			btr(i, sum);
		}
		
        int answer = 0;
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

}
