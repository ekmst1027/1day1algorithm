/*
 * 2018-11-1 Tue
 * 백준 - 구현 - 윷놀이(2490)
 * 
 * - 문제정의 -  
 * 우리나라 고유의 윷놀이는 네 개의 윷짝을 던져서 배(0)와 등(1)이 나오는 숫자를 세어 도, 개, 걸, 윷, 모를 결정한다. 
 * 네 개 윷짝을 던져서 나온 각 윷짝의 배 혹은 등 정보가 주어질 때 
 * 도(배 한 개, 등 세 개), 개(배 두 개, 등 두 개), 걸(배 세 개, 등 한 개), 윷(배 네 개), 모(등 네 개) 중 
 * 어떤 것인지를 결정하는 프로그램을 작성하라.
 *
 * - 입력 - 
 * 첫째 줄부터 셋째 줄까지 각 줄에 각각 한 번 던진 윷짝들의 상태를 나타내는 네 개의 정수(0 또는 1)가 빈칸을 사이에 두고 주어진다. 
 *
 * - 출력 - 
 * 첫째 줄부터 셋째 줄까지 한 줄에 하나씩 결과를  도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E로 출력 한다.
 * 
 * ex1)
 * 입력 : 
0 1 0 1
1 1 1 0
0 0 1 1
 * 출력 : 
B
A
B
 * 
 */

package BaekJoon.Implement;

import java.util.Scanner;

public class YutNori {

	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		
		// 변수 생성
		int[][] arr = new int[3][4];
		
		// 입력
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 각 윷이 무엇인지 알기 위해 숫자를 더함
		int[] sum = new int[3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				sum[i] += arr[i][j];
			}
		}
		
		// 더한 숫자에 따라 알파벳 표기
		for(int i = 0; i < 3; i++) {
			switch(sum[i]) {
			case 0:
				System.out.println("D");
				break;
			case 1:
				System.out.println("C");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("A");
				break;
			case 4:
				System.out.println("E");
				break;
			}
		}
		
		
	}
}
