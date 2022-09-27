package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_스도쿠_2239_BM {

	static int[][] map;
	static ArrayList<Node> zero;
	static boolean complete = false; //dfs() 완선되면 종료 조건
	static int size;
	
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zero = new ArrayList<Node>();
		map = new int[9][9];
		char[] line;
		
		for (int i = 0; i < 9; i++) {
			line = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line[j]-'0';
				if(map[i][j] == 0) zero.add(new Node(i,j));
			}
		}
			
		size = zero.size();
		
		dfs(0);
	}
	
	static void dfs(int idx) {
		if( complete ) return;
		//기저조건
		if(idx==size) {
			//complete code
			complete = true;
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		
		int y = zero.get(idx).y;
		int x = zero.get(idx).x; 
		
//		boolean[] visit = new boolean[10];  //0 dummy
		//1 0 0 0 0 0 0 0 0 0 0
		//  9 8 7 6 5 4 3 2 1 dummy
		int visit = 1 << 10;
		
		//옆으로 이미 사용한 수 체크
		for (int i = 0; i < 9; i++) {
//			if(map[y][i] != 0) visit[map[y][i]] = true;
			if(map[y][i] != 0) visit |= 1 << map[y][i];
		}
		//옆으로 이미 사용한 수 체크
		for (int i = 0; i < 9; i++) {
//			if(map[i][x] != 0) visit[map[i][x]] = true;
			if(map[i][x] != 0) visit |= 1 << map[i][x];
		}		
		
		int ny = (y/3)*3;
		int nx = (x/3)*3;
		
		for (int i = ny; i < ny+3; i++) {
			for (int j = nx; j < nx+3; j++) {
//				if(map[i][j] != 0) visit[map[i][j]] = true;
				if(map[i][j] != 0) visit |= 1 << map[i][j];
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if( (visit & 1 << i) == 0 ) { //아직 사용되지 않은 수라면
				map[y][x] = i;
				dfs(idx+1);
				map[y][x] = 0;
			}
		}
		
	}
}
