/*
 * 2019-05-02 Thu
 * 프로그래머스 - 스킬 체크 테스트 - 레벨1 - 문제2
 * 
 * - 문제정의 -  
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 *
 * - 제한사항 - 
 * n은 10,000,000,000이하인 자연수입니다.
 * 
 * ex1) 
 * 입력 : 12345
 * 출력 : [5,4,3,2,1]
 * 
 */

package Programmers.Skil_Test.level1;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {
	
	public static int[] solution(long n) {
	      List<Integer> aList = new ArrayList<>();
	      int i = 0;
	      int mod;
	      
	      while(n > 0) {
	    	  mod = (int) (n % 10);
	    	  aList.add(mod);
	    	  n = n / 10;
	    	  i += i;
	    	  
	      }
	      int[] answer = new int[aList.size()];
	      
	      for(int j = 0; j < aList.size(); j++) {
	    	  answer[j] = aList.get(j);
	      }
	      
//	      for(int j = 0; j < aList.size(); j++) {
//	    	  System.out.println(answer[j]);
//	      }
	      
	      return answer;
	  }

	public static void main(String[] args) {
		System.out.println(solution(12345));
	}

}

