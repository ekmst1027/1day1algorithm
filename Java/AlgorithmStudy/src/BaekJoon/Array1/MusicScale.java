/*
 * 2018-10-15 Mon
 * 백준 - 1차원 배열 - 음계(2920)
 * 
 * - 문제정의 -  
 * 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 
 * 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. 
 * c는 1로, d는 2로, ..., C를 8로 바꾼다.
 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
 * 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 *
 * - 입력 - 
 * 첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다. 
 *
 * - 출력 - 
 * 첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.
 * 
 * ex1)
 * 입력 : 1 2 3 4 5 6 7 8
 * 출력 : ascending
 * 
 * ex1)
 * 입력 : 8 7 6 5 4 3 2 1
 * 출력 : descending
 * 
 * ex1)
 * 입력 : 8 1 7 2 6 3 5 4
 * 출력 : mixed
 * 
 *
 *
 */

package BaekJoon.Array1;

import java.util.Scanner;

public class MusicScale {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언
		int[] scale = new int[8];
		for(int i = 0; i < scale.length; i++) {
			scale[i] = sc.nextInt();
		}
		
		// 오름차순일 경우 
		if(scale[0] == 1 && scale[7] == 8) {
			int temp = scale[0];
			for(int i = 1; i < scale.length; i++) {
				if((temp + 1) == scale[i]) {
					temp = scale[i];
				} else {
					System.out.println("mixed");
					return;
				}
			}
			
			System.out.println("ascending");
		
		// 내림차순일 경우
		} else if(scale[0] == 8 && scale[7] == 1) {
			int temp = scale[0];
			for(int i = 1; i < scale.length; i++) {
				if((temp - 1) == scale[i]) {
					temp = scale[i];
				} else {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
			
		// 둘다 아닐 경우
		} else {
			System.out.println("mixed");
		}
	}

}
