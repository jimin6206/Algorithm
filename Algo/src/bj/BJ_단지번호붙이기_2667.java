package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_단지번호붙이기_2667 {
	static int N;
	static int[][] map;
	static boolean[][] check ;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<Integer> result = new LinkedList<>();
	static int cnt;
	static int Count=0;
	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		check = new boolean[N][N];
		
		//입력받기
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(check[i][j]==true) continue;
				
				check[i][j] = true;
				
				if( map[i][j] == 1) {	
					cnt=0;
					Count++;
					queue.add(new int[] {i,j}); //큐에 현재 인덱스를 추가
					
					while(!queue.isEmpty()) {
						
						int c_y = queue.peek()[0];
						int c_x = queue.peek()[1];
						queue.remove();
						cnt++;
						
						for (int d = 0; d < 4; d++) {
							int n_y = c_y+dy[d];
							int n_x = c_x+dx[d];
							
							if((n_y >=0 && n_y <N && n_x >= 0 && n_x<N) && !check[n_y][n_x] && map[n_y][n_x]==1) {
								queue.add(new int[] {n_y,n_x});
								check[n_y][n_x] = true;
							}
							

						}
					}
					
					result.add(cnt);
					
				}
			}
		}
		
		System.out.println(Count);
		for (int i = 0; i < Count; i++) {
			System.out.println(result.remove());
		}
		
	}

}
