package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

//visit안쓰고 하는 방법 => 체크한 곳은 0으로 바꿔가면서 진행
public class BJ_단지번호붙이기_2667_DFS2 {
	
	static char[][] map;
	static int N, cnt;
//	static boolean[][] visit ;
	
//	static Queue<Node> queue = new ArrayDeque<>();
	static ArrayList<Integer> al = new ArrayList<>();

	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
//		visit = new boolean[N][N];
		
		//입력받기
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != '1' ) continue;
				cnt=0;
				dfs(i,j);
				
				al.add(cnt);
			}
		}
		
		Collections.sort(al);
		
		System.out.println(al.size());
		for (int n : al) {
			System.out.println(n);
		}
		
		
	}
	
	static void dfs(int y, int x) {
		cnt++;
//		visit[y][x] = true;
		map[y][x] = '0';
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || nx <0 || ny>=N || nx>= N ) continue;
			if(map[ny][nx] != '1') continue;
			
			dfs(ny,nx);

		}
	}

}
