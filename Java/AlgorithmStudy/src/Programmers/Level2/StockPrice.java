/*
 * 2018-10-20 Sat
 * Level2 - 주식가격
 * 
 * - 문제정의 -  
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
 * 가격이 유지된 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * (아마도 가격이 떨어지지 않은 시간을 말하는 듯)
 *
 *  
 * - 제한사항 - 
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 * 
 * ex1) 
 * 입력 prices : {498,501,470,489};
 * 출력 : {2,1,1,0};
 * 
 * 
 */

package Programmers.Level2;

import java.util.Arrays;

public class StockPrice {
	public static int[] solution(int[] prices) {
		// 정답 배열(가격 배열과 같은 길이)
        int[] answer = new int[prices.length];
        
        // 2중 포문을 통해 가격이 떨어지는 인덱스를 찾음
        // 가격이 떨어질 경우 해당 거리만큼 정답 배열에 입력
        // 그렇지 않을 경우 가격이 떨어지지 않는 것이기 때문에 +1을 더해간다
        for(int i = 0; i < prices.length; i++) {
//        	System.out.println(prices[i]);
        	for(int j = i+1; j < prices.length; j++) {
        		if(prices[i] > prices[j]) {
        			answer[i] = j-i;
//        			System.out.println(prices[j]);
        			break;
        		} else {
        			answer[i] += 1;
        		}
        	}
//        	System.out.println("=============================");
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

	public static void main(String[] args) {
		int[] price = {498,501,470,489};
		System.out.println(solution(price));
	}

}
