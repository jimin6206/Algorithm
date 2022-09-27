package bj;

import java.io.*;
import java.util.*;

public class BJ_전쟁전투_1303 {

	static int N,M;
	static char[][] map;
	static boolean[][] check;
	static Queue<int[]> queue = new LinkedList<>();
	static int result_W, result_B;
	
	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		check = new boolean[M][N];
		
		//입력받기
		for (int i = 0; i < M; i++) {
			String empty = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = empty.charAt(j);
			}
		}	
		
		//map 을 전부 돌면서 확인
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				
				if(check[i][j]) continue;  //이미 체크된 곳은 continue
				
				if(map[i][j] == 'W') {  
					result_W += bfs(i,j,map[i][j]);  //W면 bfs로 인접한 W를 count 해서 count*count 만큼을 누적 저장
				}else {
					result_B += bfs(i,j,map[i][j]);  //B면 bfs로 인접한 B를 count 해서 count*count 만큼을 누적 저장
				}
			}
		}
		//결과출력
		System.out.println(result_W + " " + result_B);
	}
	
	//BFS
	static int bfs(int y, int x, char color) {
		
		queue.add(new int[] {y,x});
		check[y][x] = true;
		int count = 1;
		
		//큐가 빌때까지 검사
		while(!queue.isEmpty()) {
			int[] empty = queue.poll();
			int cy = empty[0];
			int cx = empty[1];
			
			//4방탐색
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				
				if(ny < 0 || ny >=M || nx <0 ||nx >=N ) continue;  //범위확인
				if(check[ny][nx] || map[ny][nx]!=color) continue;  //전에 체크되지않았고 같은 컬러만 
				
				queue.add(new int[] {ny,nx});  
				check[ny][nx] = true;
				count++;
				
			}
		}
		return count*count;  //N*N 을 반환
	}
}
