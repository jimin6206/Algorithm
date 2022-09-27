package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_토마토_7576 {
	
	static int M, N, ans=0;
	static int [][] map;
	static Queue<Node> queue = new LinkedList<>(); //익은 토마토들 탐색하기 위한 큐
	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static ArrayList<Node> list = new ArrayList<>(); //초기에 익은 토마토가 있는 위치
	
	//좌표값 받을 노드
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		//map배열 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1 ) list.add(new Node(i,j));  //1은 익은 토마토의 위치 (list에 담아놓기)
			}
		}
		
		bfs();  //bfs함수호출 -> 익은 토마토부터 4방 탐색하며 map에 익는 순서를 저장할거임. 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans = Math.max(ans, map[i][j]);
				if(map[i][j] == 0) {
					ans = 0;
					i = N;
					j = M;
				}
			}
		}
		System.out.println(ans-1);
		
	}
	
	static void bfs() {
		
		//익은 토마토 위치를 큐에 담기
		for (int k = 0; k < list.size(); k++) {
			queue.add(list.get(k));
		}
		
		//큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			Node node = queue.remove();  //큐에서 첫 노드 빼오기
			
			//4방 탐색
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				//범위 확인 / map이 -1이면 토마토가 없는 곳이므로 패스
				if( ny<0 || ny>=N || nx<0 || nx>=M || map[ny][nx]==-1) continue;
				
				//탐색하려는 곳이 0이면 안익은 토마토니까 현재 map에서 +1 한 값을 저장
				//map에는 토마토가 익는 순서가 들어가게 됨. 
				if(map[ny][nx]==0) {
					map[ny][nx] = map[node.y][node.x]+1;
					queue.add(new Node(ny,nx));   //큐에 추가
				} //탐색하려는 곳이 0이 아니고, 현재 노드에서 +1 한 값보다 큰값이 저장되어있으면 현재노드에서 가는게 더 바른 값이므로 
				  //작은값으로 업데이트
				else if(map[ny][nx] > map[node.y][node.x]+1) {
					map[ny][nx] = map[node.y][node.x]+1;
					queue.add(new Node(ny,nx));  //큐에 추가
				}
			}
		}
	}
}
