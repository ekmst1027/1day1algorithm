/*
 * 2018-11-3 Sat
 * 백준 - k번째 수 - 11004
 * 
 * - 문제정의 -  
 * 수 N개 A1, A2, ..., AN이 주어진다. 
 * A를 오름차순 정렬했을 때, 
 * 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
 *
 * - 입력 - 
 * 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.
 * 둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)
 *
 * - 출력 - 
 * A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.
 * 
 * ex1)
 * 입력 : 
5 2
4 1 2 3 5
 * 출력 : 
2
 * 
 */

package BaekJoon.Free;

import java.util.Arrays;
import java.util.Scanner;

public class Kst {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		
		// 배열 개수
		int N = sc.nextInt();
		// k번째 수
		int k = sc.nextInt();
		// 배열
		int[] nArr = new int[N];
		
		// 배열 입력
		for(int i = 0; i < N; i++) {
			nArr[i] = sc.nextInt();
		}
		
		// 오름차순 정렬
		Arrays.sort(nArr);
		
		// 출력
		System.out.println(nArr[k-1]);
	}

}
