/*
 * 2018-11-15 Thu
 * 백준 - 수찾기 - 1920
 * 
 * - 문제정의 -  
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 
 * 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 *
 * - 입력 - 
 * 첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다.
 * 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
 * 다음 줄에는 M(1≤M≤100,000)이 주어진다. 
 * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
 * 모든 정수들의 범위는 int 로 한다.
 *
 * - 출력 - 
 * M개의 줄에 답을 출력한다. 
 * 존재하면 1을, 존재하지 않으면 0을 출력한다.  
 * 
 * ex1)
 * 입력 : 
5
4 1 5 2 3
5
1 3 7 9 5
 * 출력 :
1
1
0
0
1
 * 
 * 
 */

package BaekJoon.Free;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] comp = new int[n];
		for(int i = 0; i < n; i++) {
			comp[i] = sc.nextInt();
		}
		Arrays.sort(comp);
		
		int m = sc.nextInt();
		int[] ans = new int[m];
		for(int i = 0; i < m; i++) {
			ans[i] = sc.nextInt();
		}
		Arrays.sort(ans);
		
		List<Integer> answer = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				if(comp[i] == ans[j]) {
					answer.add(1);
				}
			}
		}
	}
}
