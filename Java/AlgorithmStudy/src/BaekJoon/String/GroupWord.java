/*
 * 2018-10-28 Sun
 * 백준 - 문자열 사용하기 - 그룹단어체커(1316)
 * 
 * - 문제정의 -  
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 
 * 각 문자가 연속해서 나타나는 경우만을 말한다. 
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
 * kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 *
 *  
 * - 입력 - 
 * 첫째 줄에 단어의 개수 N이 들어온다. 
 * N은 100보다 작거나 같은 자연수이다. 
 * 둘째 줄부터 N개의 줄에 단어가 들어온다. 
 * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 * 
 * - 출력 - 
 * 첫째 줄에 그룹 단어의 개수를 출력한다.
 * 
 * ex1) 
 * 입력
3
happy
new
year 
출력 : 3

 * ex2) 
 * 입력
4
aba
abab
abcabc
a
출력 : 1
 * 
 * 
 */

package BaekJoon.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroupWord {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] groupWord = new String[n];
		for(int i = 0; i < n; i++) {
			groupWord[i] = sc.next();
		}
		
		// 변수 생성
		int answer = 0;	// 정답 변수
		
		// 단어 하나씩 루프 돌면서 검증
		for(String word : groupWord) {
			// 해당 단어에서 연속으로 중복된 글자를 뺀 단어를 만들었는데도 중복이 있으면 그룹 단어가 아님 
			
			int count = 0;	// 해당 단어가 그룹 단어인지 검증
			Map<String, Integer> check = new HashMap<String, Integer>();	// 그룹 단어 검증에 필요한 해쉬
			char prev = word.charAt(0);	// 첫번째 글자
			String temp = String.valueOf(prev); // 중복을 뺀 글자
			// 직전 글자와 같지 않을 경우에만 단어에 글자를 추가(중복 제거)
			for(int i = 1; i < word.length(); i++) {
				if(prev != word.charAt(i)) {
					temp += word.charAt(i);
				}
				prev = word.charAt(i);
			}
			
			// 중복을 뺀 단어임에도 중복된 단어가 나타나는지 검증
			for(int i = 0; i < temp.length(); i++) {
				String comp = String.valueOf(temp.charAt(i));
				if(!check.containsKey(comp)) {
					check.put(comp, 1);
					count++;
				} else {
					break;
				}
			}
			if(count == temp.length()) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
