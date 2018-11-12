/*
 * 2018-11-12 Mon
 * 백준 - 피보나치 함수 - 1003
 * 
 * - 문제정의 -  
 * N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 *
 * - 입력 - 
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 *
 * - 출력 - 
 * 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 * 
 * ex1)
 * 입력 : 
3
0
1
3
 * 출력 : 
1 0
0 1
1 2
 * 
 */

package BaekJoon.DP;

import java.util.Scanner;

public class Fibonacci {
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp = new int[41];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 0; i < n; i++) {
			int input = arr[i];
			if(input == 0) {
				System.out.println(1 + " " + 0);
			} else if(dp[input] != 0) {
				System.out.println(dp[input-1] + " " + dp[input]);
			} else {
				for(int j = 2; j <= input; j++) {
					dp[j] = dp[j-1] + dp[j-2];
				}
				System.out.println(dp[input-1] + " " + dp[input]);
			}
		}
	}
}
