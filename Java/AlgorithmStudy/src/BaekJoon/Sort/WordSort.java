/*
 * 2018-11-3 Sat
 * 백준 - 정렬해보기 - 단어 정렬(1181)
 * 
 * - 문제정의 -  
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 *
 * - 입력 - 
 * 첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 
 * 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
 * 주어지는 문자열의 길이는 50을 넘지 않는다. 
 *
 * - 출력 - 
 * 조건에 따라 정렬하여 단어들을 출력한다. 
 * 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 * 
 * ex1)
 * 입력 : 
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours

 * 출력 : 
i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
 * 
 */

package BaekJoon.Sort;

import java.util.Scanner;

public class WordSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] stArr = new String[N];
		
		for(int i = 0; i < N; i++) {
			stArr[i] = sc.next();
		}
		
		// 길이 순서대로 정렬
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < N-1; j++) {
				if(stArr[j].length() > stArr[j+1].length()) {
					String temp = stArr[j];
					stArr[j] = stArr[j+1];
					stArr[j+1] = temp;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < N-1; i++) {
			if(stArr[i].equals(stArr[i+1])) {
				stArr[i+1] = "";
				count++;
			}
		}
		
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < N-1; j++) {
				if(stArr[j].length() > stArr[j+1].length()) {
					String temp = stArr[j];
					stArr[j] = stArr[j+1];
					stArr[j+1] = temp;
				}
			}
		}
		
		int n = N-count;
		String[] stAnswer = new String[n];
		for(int i = 0; i < n; i++) {
			stAnswer[i] = stArr[count++];
		}
		
		for(int i = 0; i < n-1; i++) {
			for(int j = i; j <n-1; j++) {
				if(stAnswer[j].length() == stAnswer[j+1].length()) {
					if(stAnswer[j].compareTo(stAnswer[j+1]) > 0) {
						String temp = stAnswer[j];
						stAnswer[j] = stAnswer[j+1];
						stAnswer[j+1] = temp;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(stAnswer[i]);
		}
	}
}
