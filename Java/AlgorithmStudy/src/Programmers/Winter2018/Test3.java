package Programmers.Winter2018;
/*
 * 2018-10-27 Sat
 * 코딩테스트 - 좌표
 * 
 * - 문제정의 -  
 * 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
 * U: 위쪽으로 한 칸 가기
 * D: 아래쪽으로 한 칸 가기
 * R: 오른쪽으로 한 칸 가기
 * L: 왼쪽으로 한 칸 가기
 * 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 
 * 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
 * 예를 들어, ULURRDLLU로 명령했다면
 * 1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.
 * 8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.
 * 이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다. 
 * 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다. 
 * (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)
 * 단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
 * 예를 들어, LULLLLLLU로 명령했다면
 * 1번 명령어부터 6번 명령어대로 움직인 후, 7, 8번 명령어는 무시합니다. 다시 9번 명령어대로 움직입니다.
 * 이때 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.
 * 명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.
 *
 *  
 * - 제한사항 - 
 * dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
 * dirs의 길이는 500 이하의 자연수입니다.
 * 
 * ex1) 
 * 입력 dirs : "ULURRDLLU";
 * 출력 : 3;
 * 
 * ex2) 
 * 입력 dirs : "LULLLLLLU";
 * 출력 : 0;
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test3 {
	
	public static int solution(String dirs) {
		LinkedList<Integer> queX = new LinkedList<Integer>();
		LinkedList<Integer> queY = new LinkedList<Integer>();
		List<String> ansList = new ArrayList<String>();
		
		for(int i = 0; i < dirs.length(); i++) {
			switch(dirs.charAt(i)) {
			
			case 'D':
				queX.add(0);
				queY.add(-1);
				break;
			case 'U':
				queX.add(0);
				queY.add(1);
				break;
			case 'L':
				queX.add(-1);
				queY.add(0);
				break;
			case 'R':
				queX.add(1);
				queY.add(0);
				break;
			}
		}
		
		System.out.println(queX.toString());
		System.out.println(queY.toString());
		
		int sumX = 0;
		int sumY = 0;
		int count = 0;
		int containCount = 0;
		while(!queX.isEmpty()) {
			count++;
			int x = queX.pop();
			int y = queY.pop();
			sumX = sumX + x;
			sumY = sumY + y;
			if(sumX < -5 || sumX > 5 || sumY < -5 || sumY > 5) {
				sumX = sumX - x;
				sumY = sumY - y;
				continue;
			}
			String temp = String.valueOf(sumX) + String.valueOf(sumY);
			System.out.println("count : " + count);
			System.out.println("x : " + x);
			System.out.println("y : " + y);
			System.out.println("sumX : " + sumX);
			System.out.println("sumY : " + sumY);
			System.out.println("temp : " + temp);
			if(ansList.contains(temp)) {
				containCount++;
				if(containCount > 2) {
					break;
				}
				ansList.add(temp);
			} else 
			ansList.add(temp);
		}
		
		System.out.println(ansList.toString());
        return ansList.size();
    }
	
	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println("======================================");
		System.out.println(solution("LULLLLLLU"));
	}
}
