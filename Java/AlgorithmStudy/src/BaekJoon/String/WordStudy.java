/*
 * 2018-10-17 Wed
 * 백준 - 문자열 사용하기 - 단어공부(1157)
 * 
 * - 문제정의 -  
 * 알파벳 대소문자로 된 단어가 주어지면, 
 * 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
 * 단, 대문자와 소문자를 구분하지 않는다.
 *
 * - 입력 - 
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
 * 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.  
 *
 * - 출력 - 
 * 각 테스트 케이스에 대해 P를 출력한다.
 * 
 * ex1)
 * 입력 : Mississipi
 * 출력 : ?
 * 
 * ex2)
 * 입력 : zZa
 * 출력 : Z 
 * 
 * ex3)
 * 입력 : z
 * 출력 : Z
 * 
 * ex4)
 * 입력 : baaa
 * 출력 : A
 *
 */

package BaekJoon.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordStudy {
	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toUpperCase();
		
		// 변수생성
		Map<String, Integer> stMap = new HashMap<String, Integer>();
		// 알파벳과 단어에서 나온 횟수를 맵으로 계산
		for(int i = 0; i < str.length(); i++) {
			if(!stMap.containsKey(String.valueOf(str.charAt(i)))) {
				stMap.put(String.valueOf(str.charAt(i)), 1);
			} else {
				stMap.put(String.valueOf(str.charAt(i)), stMap.get(String.valueOf(str.charAt(i))) + 1);
			}
		}
		
		int max = 0;
		int idx = 0;
		String maxSt = "";
		int[] comp = new int[stMap.size()];
		// 알파벳 횟수중에 가장 큰 수를 구함과 동시에 비교하기 위해 배열로 저장
		for(Object st : stMap.keySet()) {
			comp[idx] = stMap.get(st);
			if(max < stMap.get(st)) {
				max = stMap.get(st);
				maxSt = String.valueOf(st);
			}
			idx++;
		}
		// 오름차순 정렬
		Arrays.sort(comp);
		// 알파벳이 1개일 경우 그대로 출력
		if(stMap.size() == 1) {
			System.out.println(maxSt);
		// 오름차순 정렬했을 때 가장 큰 수와 그 전의 수가 같으면 중복이기 때문에 물음표 출력
		} else if(comp[stMap.size()-1] == comp[stMap.size()-2]) {
			System.out.println("?");
		// 그렇지 않을 경우 미리 구해두었던 키에 해당하는 알파벳을 출력
		} else {
			System.out.println(maxSt);
		}
		
		
	}

}
