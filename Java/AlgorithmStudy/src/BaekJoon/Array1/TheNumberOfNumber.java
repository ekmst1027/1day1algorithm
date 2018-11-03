/*
 * 2018-10-15 Mon
 * 백준 - 1차원 배열 - 숫자의 개수
 * 
 * - 문제정의 -  
 * 세 개의 자연수 A, B, C가 주어질 때 
 * A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 예를 들어 A = 150, B = 266, C = 427 이라면
 * A × B × C = 150 × 266 × 427 = 17037300 이 되고,
 * 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 *
 * - 입력 - 
 *  첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 같거나 크고, 1,000보다 작은 자연수이다.
 *
 * - 출력 - 
 * 첫째 줄에는 A×B×C의 결과에 0 이 몇 번 쓰였는지 출력한다. 
 * 마찬가지로 둘째 줄부터 열 번째 줄까지 A×B×C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
 * 
 * ex1) 
 * 입력 : 150
 * 		 266
 * 		 427
 * 출력 : 3
 * 		 1
 * 		 0
 * 		 2
 * 		 0
 * 		 0
 * 		 0
 * 		 2
 * 		 0
 * 		 0
 * 
 */

package BaekJoon.Array1;

import java.util.Scanner;

public class TheNumberOfNumber {
	public static void main(String[] args) {

		// 입력부
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();	// 첫번째 수가 입력될 변수
		int num2 = sc.nextInt();	// 두번째 수가 입력될 변수
		int num3 = sc.nextInt();	// 세번째 수가 입력될 변수
		
		// 변수 할당
		int[] arr = new int[10];	// 정답이 입력될 배열
		
		int mod = 0;	// 10으로 나눈 나머지를 저장할 변수
		int mulNum = num1 * num2 * num3;	// 세 수를 곱한 수
		// 세 수를 곱한 수를 10으로 나눈 후 나머지에 해당하는 배열의 자리에서 +1을 한다.
		while(mulNum > 0) {
			mod = mulNum % 10;
			arr[mod]++;
			mulNum /= 10;
		}
		// 정답대로 출력
		for(int i = 0; i < 10; i++) {			
			System.out.println(arr[i]);
		}
	}

}
