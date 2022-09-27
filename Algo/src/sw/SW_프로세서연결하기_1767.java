package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_프로세서연결하기_1767 {
	static int T,N,dir;
	static int[][] map;
	static PriorityQueue<Core> pqueue = new PriorityQueue<>();
	
	static class Core implements Comparable<Core>{
		int y;
		int x;
		int d;  //갈수있는 방향의 개수
		
		public Core(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}

		@Override
		public int compareTo(Core o) {	
			return this.d - o.d;
		}
	}
	
	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			//map 입력받기
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//우선순위 큐에 집어넣기
			for (int i = 0; i < N; i++) {				
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						//제일 외곽은 제외
						if(i==0 || i==N-1 || j==0 || j==N-1) continue;
						dir = direction(i,j);
						pqueue.add(new Core(i,j,dir));			
					}					
				}
			}	
			
			while(!pqueue.isEmpty()) {
				
				Core core = pqueue.poll();
				
				//상하좌우 검사 -> 갈수있는 가장 경로가 짧은 거리
				for (int d = 0; d < 4; d++) {
					int line=0;
					int ny = core.y + dy[d];
					int nx = core.x + dx[d];
					
					while(true) {
						if(map[ny][nx]!=0) break;
						if(ny==0 || ny == N-1 || nx==0 || nx==N-1) {

							break;
						}
						ny += dy[d];
						nx += dx[d];
						line++;
					}
					
				}
			}	
		}	
	}
	
	//갈수있는 방향 수
	static int direction(int y, int x) {
		int cnt=0;

		//상하좌우 검사
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			while(true) {
				if(map[ny][nx]!=0) break;
				if(ny==0 || ny == N-1 || nx==0 || nx==N-1) {
					cnt++;
					break;
				}
				ny += dy[d];
				nx += dx[d];
			}
		}
		
		return cnt;
	}
}
