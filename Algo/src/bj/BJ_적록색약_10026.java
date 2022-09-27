package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_적록색약_10026 {

	static int N;
	static char[][] map;
	static boolean[][] visit;
	static Queue<Node> queue = new LinkedList<>();
	
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	// 상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //크기 입력받기
		map = new char[N][N];        //map을 NxN으로 할당
		visit = new boolean[N][N];  //visit도 NxN으로 할당 
		
		//map입력받기
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int cnt1=0;   //적록색약이 아닌사람의 구역 count
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {   //visit이 false인 구역만 확인
					cnt1++;          //count+1
					bfs(i,j);        //bfs를 호출하면 상하좌우로 같은 구역은 모두 visit=true 로 바뀜
				}
				if(map[i][j]=='G') map[i][j] = 'R';  //적록색약은 R과 G를 같은 색으로 보니때문에 검사 후 모든 G를 R로 바꿔줌
			}
		} 
		//visit배열 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i],false );
		}
		
		int cnt2=0;   //적록색약인 사람의 구역 count
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {  //위와 똑같이 동작
					cnt2++;
					bfs(i,j);
				}
			}
		}
		
		//결과 출력
		System.out.println(cnt1 + " " + cnt2);	
	}
	
	static void bfs(int i, int j) {
		//큐에 Node(i,j)를 저장
		queue.add(new Node(i,j));
		visit[i][j] = true;  
		char c = map[i][j]; //현재 자리의 색을 받아옴
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				//범위 확인 / 방문했던 노드인지 확인 / map의 색이 현재 색과 같은지 확인
				if(ny<0 || ny>=N || nx<0 || nx>=N || visit[ny][nx] || map[ny][nx]!=c) continue; 
				queue.add(new Node(ny,nx));  //조건 통과하면 큐에 해당노드 추가
				visit[ny][nx] = true;	
			}
		}
	}
}
