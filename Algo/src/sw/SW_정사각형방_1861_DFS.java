package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class SW_정사각형방_1861_DFS {
	
	static int[][] map;
	static int T, N, NO, COUNT; //방 번호, 이동횟수

	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static class Node{
		int y;  //방의 y
		int x;  //방의 x
		int no; //방 번호 (시작 방번호)
		int cnt;  //방문 횟수(계속 증가)
		
		public Node(int y, int x, int no, int cnt) {
			this.y = y;
			this.x = x;
			this.no = no;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			NO = 0;
			COUNT=1;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//bfs
			//모든 방에서 1번씩 출발해본다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(new Node(i,j,map[i][j],1));
				}
			}
			
			System.out.println("#" + t + " " + NO + " " + COUNT );
			
		}
	}
	
	static void dfs(Node node) {
		
		if(node.cnt > COUNT) {
			COUNT = node.cnt;
			NO = node.no;
		}else if(node.cnt == COUNT) {
			NO = (node.no < NO) ? node.no : NO;
		}
		
		for (int d = 0; d < 4; d++) {
			int ny = node.y + dy[d];
			int nx = node.x + dx[d];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] != map[node.y][node.x] + 1)  continue;
			
			dfs(new Node(ny,nx,node.no,node.cnt+1));
		}
			
			
		
			
	}
}
