/*
 * 2018-10-08 Mon
 * 2018년 프로그래머스 써머코딩 문제 - 영어끝말잇기
 * 
 * - 문제정의 -  
 * 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
 * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
 * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
 * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
 * 이전에 등장했던 단어는 사용할 수 없습니다.
 * 한 글자인 단어는 인정되지 않습니다.
 * 다음은 3명이 끝말잇기를 하는 상황을 나타냅니다.
 *
 * tank → kick → know → wheel → land → dream → mother → robot → tank
 *
 * 위 끝말잇기는 다음과 같이 진행됩니다.

 * 1번 사람이 자신의 첫 번째 차례에 tank를 말합니다.
 * 2번 사람이 자신의 첫 번째 차례에 kick을 말합니다.
 * 3번 사람이 자신의 첫 번째 차례에 know를 말합니다.
 * 1번 사람이 자신의 두 번째 차례에 wheel을 말합니다.
 * (계속 진행)
 * 끝말잇기를 계속 진행해 나가다 보면, 
 * 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다.
 * 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 
 * 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.
 * 
 * - 제한사항 - 
 * 끝말잇기에 참여하는 사람의 수 n은 2 이상 10 이하의 자연수입니다.
 * words는 끝말잇기에 사용한 단어들이 순서대로 들어있는 배열이며, 길이는 n 이상 100 이하입니다.
 * 단어의 길이는 2 이상 50 이하입니다.
 * 모든 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 끝말잇기에 사용되는 단어의 뜻(의미)은 신경 쓰지 않으셔도 됩니다.
 * 정답은 [ 번호, 차례 ] 형태로 return 해주세요.
 * 만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.
 * 
 * ex1) 
 * 입력 n : 3
 * 입력 words : {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"} 
 * 출력 : [3,3]
 * 
 * ex2) 
 * 입력 n : 5
 * 입력 words : {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"} 
 * 출력 : [0,0]
 * 
 * ex3) 
 * 입력 n : 2
 * 입력 words : {"hello", "one", "even", "never", "now", "world", "draw"} 
 * 출력 : [1,3]
 * 
 */

package Programmers.Summer2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnglishWordChain {
	public static int[] solution(int n, String[] words) {
		int [] answer = {0,0};	// 정답 배열 
		
		List<String> wordsList = new ArrayList<String>(); // 중복이 아닌 단어를 넣을 리스트  
		char prevLetter = words[0].charAt(words[0].length()-1);	// 앞단어의 맨 뒷글자 초기
		wordsList.add(words[0]);	// 미리 맨 첫번재 단어 넣기 
		
		for(int i = 1; i < words.length; i++) {
			char nextLetter = words[i].charAt(0);
			
//			System.out.println("===================================");
//			System.out.println(words[i]);
//			System.out.println(wordsList.toString());
			
			// 단어가 한글자이거나 끝말잇기에서 스펠링 틀린 부분 찾기
			if(words[i].length() == 1 || prevLetter != nextLetter) {
//				System.out.println("스펠링 틀림 ");
				int numWord = i / n;
				int numPerson = i % n;
				answer[0] = numPerson+1;
				answer[1] = numWord+1;
				return answer;
				
			// 단어가 중복될 경우 리턴 
			} else if(wordsList.contains(words[i])) {
//				System.out.println("중복");
				int numWord = i / n;
				int numPerson = i % n;
				answer[0] = numPerson+1;
				answer[1] = numWord+1;
				return answer;
			} else {
				wordsList.add(words[i]);
				prevLetter = words[i].charAt(words[i].length()-1);
			}
		}
		
        return answer;
    }

	public static void main(String[] args) {
//		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		System.out.println(Arrays.toString(solution(2, words)));
	}

}
 