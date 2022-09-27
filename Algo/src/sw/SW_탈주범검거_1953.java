package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_탈주범검거_1953 {

	static int T,N,M,R,C,L,cnt=0;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Node> queue = new LinkedList<>();
	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static class Node{
		int y;
		int x;
		int hour;
		public Node(int y, int x, int hour) {
			this.y = y;
			this.x = x;
			this.hour = hour;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			queue.clear();
			queue.add(new Node(R,C,1));
			visit[R][C] = true;
			cnt=0;
			
			int ny=0, nx=0;
			
			while(!queue.isEmpty()) {
				
				Node node = queue.poll();
				if(node.hour>L) break;
				cnt++;
				
				switch(map[node.y][node.x]){
					case 1:
						//상
						ny = node.y + dy[0];
						nx = node.x + dx[0];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==5 || map[ny][nx]==6)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//하
						ny = node.y + dy[1];
						nx = node.x + dx[1];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==4 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//좌
						ny = node.y + dy[2];
						nx = node.x + dx[2];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==4 || map[ny][nx]==5)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//우
						ny = node.y + dy[3];
						nx = node.x + dx[3];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==6 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						break;
					case 2:
						//상
						ny = node.y + dy[0];
						nx = node.x + dx[0];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==5 || map[ny][nx]==6)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//하
						ny = node.y + dy[1];
						nx = node.x + dx[1];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==4 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						break;
					case 3:
						//좌
						ny = node.y + dy[2];
						nx = node.x + dx[2];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==4 || map[ny][nx]==5)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
	
						//우
						ny = node.y + dy[3];
						nx = node.x + dx[3];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==6 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						break;
					case 4:
						//상 
						ny = node.y + dy[0];
						nx = node.x + dx[0];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==5 || map[ny][nx]==6)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//우
						ny = node.y + dy[3];
						nx = node.x + dx[3];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==6 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						break;
					case 5:
						//하
						ny = node.y + dy[1];
						nx = node.x + dx[1];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==4 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//우
						ny = node.y + dy[3];
						nx = node.x + dx[3];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==6 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						break;
					case 6:
						//하
						ny = node.y + dy[1];
						nx = node.x + dx[1];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==4 || map[ny][nx]==7)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//좌
						ny = node.y + dy[2];
						nx = node.x + dx[2];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==4 || map[ny][nx]==5)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						break;
					case 7:
						//상
						ny = node.y + dy[0];
						nx = node.x + dx[0];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==5 || map[ny][nx]==6)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						
						//좌
						ny = node.y + dy[2];
						nx = node.x + dx[2];
						if(ny>=0 && ny<N && nx>=0 && nx<M && !visit[ny][nx]
								&& (map[ny][nx]==1 || map[ny][nx]==3 || map[ny][nx]==4 || map[ny][nx]==5)) {
							queue.add(new Node(ny,nx,node.hour+1));
							visit[ny][nx] = true;
						}
						break;
				}
			}			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
