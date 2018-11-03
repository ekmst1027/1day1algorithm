/*
 * 2018-10-31 Wed
 * Level1 - 문자열 내맘대로 정렬하기
 * 
 * - 문제정의 -  
 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 
 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
 * 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 
 * 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
 * 
 * - 제한사항 -
 * strings는 길이 1 이상, 50이하인 배열입니다.
 * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
 * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
 * 모든 strings의 원소의 길이는 n보다 큽니다.
 * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 * 
 * ex1)
 * 입력 string : {"sun", "bed", "car"}
 * 입력 n : 1
 * 출력 : {"car", "bed", "sun"}
 * 
 * ex2)
 * 입력 string : {"abce", "abcd", "cdx"}
 * 입력 n : 2
 * 출력 : {"abcd", "abce", "cdx"}
 * 
 * ex3)
 * 입력 string : {"computers", "teenager", "desktop", "bodyguard", "flowers"}
 * 입력 n : 1
 * 출력 : {"abcd", "abce", "cdx"}
 * 
 * 
 */

package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheNumberOfPAndY {
	public static String[] solution(String[] strings, int n) {
		Map<String, String> words = new HashMap<String, String>();
		List<String> wordList = new ArrayList<String>();
		
		// 맵에 원래단어 : 축약단어로 저장
		for(int i = 0; i < strings.length; i++) {
			  String temp = strings[i].substring(n);
			  words.put(strings[i], temp);
		}
		
		// 리스트에 축약 단어 저장
		for(String word : words.keySet()) {
//			System.out.println(word + " : " + words.get(word));
			wordList.add(words.get(word));
		}
		
		// 축약단어 정렬
		Collections.sort(wordList);
//		System.out.println(wordList.toString());
		
		String[] answer = new String[wordList.size()];
		for(String word : words.keySet()) {
			System.out.println("out word : " + word);
			for(int i = 0; i < wordList.size(); i++) {
				if(wordList.get(i).equals(words.get(word))) {
					System.out.println("in word : " + word);
					answer[i] = word;
					break;
				}
			}
		}
		
//		for(int i = 0; i < wordList.size(); i++) {
//			for(String word : words.keySet()) {
//				if(wordList.get(i).equals(words.get(word))) {
//					answer[i] = word;
//					words.remove(word);
//				}
//			}
//		}
		
		
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		return answer;
	  }

	public static void main(String[] args) {
//		String[] s1 = {"computers", "teenager", "desktop", "bodyguard", "flowers"};
//		String[] s1 = {"abce", "abcd", "cdx"};
		String[] s1 = {"abzcd","cdzab","abzfg","abzaa","abzbb","bbzaa"};
		System.out.println(solution(s1, 2));
//		['desktop', 'teenager', 'flowers', 'bodyguard', 'computers']
	}

}
