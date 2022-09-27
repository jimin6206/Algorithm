package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class SW_정사각형방_1861 {
	
	static int T,N,cnt=0, result_num, result_cnt=0;
	static int[][] map;
	static boolean[][] check ;
	
	static Queue<Node> queue = new ArrayDeque<>();

	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static class Node{
		int y,x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			result_num=0;
			result_cnt=0;
			queue.clear();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!check[i][j]) {
						check[i][j] = true;
						bfs(i,j);
					}
				}
			}
			
			System.out.println("#" + t + " " + result_num + " " + result_cnt );
			
		}
	}
	
	static void bfs(int y, int x) {
		
		queue.add(new Node(y,x));
		cnt=1;
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N)  continue;
				if(map[ny][nx] == map[node.y][node.x] + 1) {
					queue.add(new Node(ny,nx));
					check[ny][nx] = true;
					cnt++;
					break;
				}
			}
		}
		
		if(result_cnt < cnt) {
			result_num = map[y][x];
			result_cnt = cnt;
		}else if(result_cnt == cnt) {
			if(result_num > map[y][x]) {
				result_num = map[y][x];
			}
		}
		
	}

}
