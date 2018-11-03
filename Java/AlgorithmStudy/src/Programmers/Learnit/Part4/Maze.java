/*
 * 2018-10-11 Thu
 * 하반기 코딩테스트 실전 대비 오프라인 수업 - 미로탐색
 * BFS
 * 
 * - 문제정의 -  
 * N x M 크기의 배열로 표현되는 미로가 있다.
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 
 * 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
 * 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 *  
 * - 입력 - 
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
 * 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 
 * 각각의 수들은 붙어서 입력으로 주어진다.
 * 
 * - 출력 - 
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 
 * 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * 
 * ex1) 
 * 입력 : 4 6
 *		 101111
 *		 101010
 *		 101011
 *		 111011
 * 출력 : 15
 * 
 * 
 * 
 */

package Programmers.Learnit.Part4;

import java.util.LinkedList;
import java.util.Scanner;

public class Maze {
	// 2중 배열을 프린트할 함수
	public static void print(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("========================================================");
	}
	
	public static void main(String[] args) {
		// 1. 입력부 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 행
		int M = sc.nextInt();	// 열
		int maze[][] = new int[N][M];
		// 한줄 단위로 입력이 되기 때문에 next()를 이용해 스트링으로 입력을 받은 후
		// char 배열로 변환하여 하나씩 다시 저장
		for(int i = 0; i < N; i++) {
			String temp = sc.next();
			char tempChar[] = temp.toCharArray();
			for(int j = 0; j < M; j++) {
				maze[i][j] = tempChar[j] - '0';
			}
		}
		
		// 2. 변수생성
		int startX = 0;	// x좌표의 초기값
		int startY = 0;	// y좌표의 초기값
		
		LinkedList<Integer> queX = new LinkedList<Integer>();
		LinkedList<Integer> queY = new LinkedList<Integer>();
		
		// 3. 초기값 넣기
		queX.add(startX);
		queY.add(startY);
		
		// 4. 반복문 수행
		while(!queX.isEmpty()) {
			print(maze);
			System.out.println("queX: " + queX.toString());
			System.out.println("queY: " + queY.toString());
			int x = queX.pop();
			int y = queY.pop();
			
			// 아래로 확인
			if(x + 1 < N && maze[x+1][y] == 1) {
				maze[x+1][y] = maze[x][y] + 1;
				queX.add(x+1);
				queY.add(y);
			}
			
			// 위로 확인
			if(x - 1 >= 0 && maze[x-1][y] == 1) {
				maze[x-1][y] = maze[x][y] + 1;
				queX.add(x-1);
				queY.add(y);
			}
			
			// 오른쪽 확인
			if(y + 1 < M && maze[x][y+1] == 1) {
				maze[x][y+1] = maze[x][y] + 1;
				queX.add(x);
				queY.add(y+1);
			}
			
			// 왼쪽 확인
			if(y - 1 >= 0 && maze[x][y-1] == 1) {
				maze[x][y-1] = maze[x][y] + 1;
				queX.add(x);
				queY.add(y-1);
			}
		}
		
		System.out.println("Answer : " + maze[N-1][M-1]);
		
		
	}

}
