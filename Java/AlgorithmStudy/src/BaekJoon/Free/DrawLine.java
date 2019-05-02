/*
 * 2018-11-13 Tue
 * 백준 - 선 그리기 - 16396
 * 
 * - 문제정의 -  
 * 준용이의 조카 준섭이는 크레파스로 한 직선에 평행한 여러 개의 선분을 그리고 있었다.
 * 준섭이의 모습을 보고 있던 준용이는 준섭이가 그린 모든 선들을 직선 좌표에 투사(projection)했을 때 
 * 투사된 선들의 길이 합이 궁금하였다.
 * 준용이에게 잘 보여야하는 여러분은 준용이의 궁금증을 해결하기 위해 프로그램을 구현해주자.
 *
 * - 입력 - 
 * 첫 번째 줄에는 준섭이가 그린 선의 개수 N이 입력된다.
 * 두 번째 줄부터 N+1 번째 줄까지는 준섭이가 그린 선의 시작 좌표 Xi와 끝 좌표 Yi 가 순서대로 주어진다. 
 * Xi 와 Yi 는 정수이며, 띄어쓰기로 구분된다.
 * N의 범위는 1부터 10,000까지이다. 선의 시작 좌표와 끝 좌표는 1부터 10,000까지의 자연수이다.
 *
 * - 출력 - 
 * 직선 좌표에 투사된 선의 총 길이 합을 정수로 출력한다. 
 * 
 * ex1)
 * 입력 : 
4
1 3
2 5
4 9
11 13
 * 출력 : 
10
 * 
 */

package BaekJoon.Free;

import java.util.LinkedList;
import java.util.Scanner;

public class DrawLine {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> queX = new LinkedList<Integer>();
		LinkedList<Integer> queY = new LinkedList<Integer>();
		
		for(int i = 0; i < n; i++) {
			queX.add(sc.nextInt());
			queY.add(sc.nextInt());
		}
		
		
		// 투사된 평행선
		int[] line = new int[10003];
		int max = 0;
		
		// 평행선에 줄 긋기
		while(!queX.isEmpty()) {
			int dotX = queX.pop();
			int dotY = queY.pop();
			if(max < dotY) {
				max = dotY;
			}
			for(int i = dotX; i <= dotY; i++) {
				line[i] = 1;
			}
		}
		
		int count = 0;
		for(int i = 1; i <= max+2; i++) {
			if(line[i-1] != line[i]) {
				count++;
				if(count % 2 == 0) {
					queY.add(i-1);
				} else {
					queX.add(i);
				}
			}
		}
		
		int sum = 0;
		while(!queX.isEmpty()) {
			int dotX = queX.pop();
			int dotY = queY.pop();
			sum += dotY - dotX;
		}
		
		System.out.println(sum);
	}

}
