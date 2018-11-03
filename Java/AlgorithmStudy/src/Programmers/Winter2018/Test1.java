/*
 * 2018-10-27 Sat
 * 코딩테스트 - 선행스킬
 * 
 * - 문제정의 -  
 * 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
 * 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
 * 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
 * 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
 * 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
 * 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 
 * 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 *
 *  
 * - 제한사항 - 
 * 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 스킬 순서와 스킬트리는 문자열로 표기합니다.
 * 예를 들어, C → B → D 라면 CBD로 표기합니다
 * 선행 스킬 순서 skill의 길이는 2 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 * 
 * ex1) 
 * 입력 skill : "CBD"
 * 입력 skill_trees : {"BACDE", "CBADF", "AECB", "BDA"};
 * 출력 : 2;
 * 
 */

package Programmers.Winter2018;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 스킬트리에서 스킬에 해당하는 알파벳과 위치를 맵으로 만들어서 저장(자바에서는 위치에 따라 오름차순으로 저장됨)
// 그대로 알파벳만 리스트에 저장후 스킬도 리스트로 만들어서 비교
// 다음 스킬을 배우기 위해서는 이전 스킬을 필수로 배워야 하기 때문에 처음부터 맞지 않으면 종료 
// 맞을 경우 카운트
public class Test1 {
	public static int solution(String skill, String[] skill_trees) {
		// 변수 생성
		int answer = 0;
		
		for(String skill_tree : skill_trees) {
			List<String> arrList = new ArrayList<String>();
			List<String> compList = new ArrayList<String>();
			Map<Integer, String> arrMap = new HashMap<Integer, String>();
			
			
			for(int i = 0; i < skill.length(); i++) {
				for(int j = 0; j < skill_tree.length(); j++) {
					if(String.valueOf(skill.charAt(i)).equals(String.valueOf(skill_tree.charAt(j)))) {
						arrMap.put(j, String.valueOf(skill.charAt(i)));
					}
				}
			}
			
			for(Integer key : arrMap.keySet()) {
//				System.out.println(key + " : " + arrMap.get(key));
				arrList.add(arrMap.get(key));
			}
			
			for(int i = 0; i < skill.length(); i++) {
				compList.add(String.valueOf(skill.charAt(i)));
			}
			
//			System.out.println(arrList.toString());
//			System.out.println(compList.toString());
			
			int count = 0;
			for(int i = 0; i < arrList.size(); i++) {
				if(!arrList.get(i).equals(compList.get(i))) {
					break;
				} else {
					count++;
				}
			}
			if(count == arrList.size()) {
				answer++;
			}
			
//			System.out.println("==============================");
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}

}
