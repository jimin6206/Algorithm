package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_아기상어_16236 {
	
	static int N, sy, sx, sSize, sEatCnt, ans;
	static int[][] map;
	static boolean[][] visit;
	
	static Queue<Node> queue = new ArrayDeque<Node>();
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static class Node{
		int y, x, d;
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 9) {
					sy = i;
					sx = j;
				}
				map[i][j] = n;
			}
		}
		
		//풀이
		sSize = 2;
		
		//시물레이션 - 반복 ( 횟수가 정해지지 않음)
		while(true) {
			//상어가 먹이를 찾으러 간다. 찾으면 먹음, 못찾으면 ? 종료
			int cnt = bfs();  //먹었으면 먹은 고기까지의 거리
			if(cnt==0) break;
			ans += cnt;
		}
		
		System.out.println(ans);	
	}
	
	static int bfs() {
		//먹이 후보
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minDis = Integer.MAX_VALUE;
		
		//visit 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}
		
		visit[sy][sx] = true;
		queue.offer(new Node(sy,sx, 0));
		
		while( !queue.isEmpty()) {
			Node node = queue.poll();
			// 먹을 수 있는 물고기를 발견하면
			if( map[node.y][node.x] < sSize && map[node.y][node.x] != 0) {
				if(node.d < minDis) {
					minDis = node.d;
					minY = node.y;
					minX = node.x;
				}else if(node.d == minDis) {
					if(node.y < minY) {
						minDis = node.d;
						minY = node.y;
						minX = node.x;
					}else if(node.y == minY) {
						if(node.x < minX) {
							minDis = node.d;
							minY = node.y;
							minX = node.x;
						}
					}
				}
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if( ny<0 || nx<0 || ny>=N || nx>=N || visit[ny][nx] || map[ny][nx]>sSize) continue;
				visit[ny][nx] = true;
				queue.offer(new Node(ny,nx, node.d +1));
			}	
		}
		
		if(minDis == Integer.MAX_VALUE) return 0;  //물고기 못먹었음.
		else { //물고기 먹었음.
			sEatCnt++;
			if(sEatCnt == sSize) {
				sSize++;
				sEatCnt = 0;
			}
			
			map[minY][minX] = 0;
			map[sy][sx] = 0;
			
			sy = minY;
			sx = minX;
		}
		return minDis;
	}
}
