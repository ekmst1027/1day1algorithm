package Programmers.Test.level1;

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

