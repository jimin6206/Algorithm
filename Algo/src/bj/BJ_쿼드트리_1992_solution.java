package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_쿼드트리_1992_solution {
	
	static int N;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		divide(0, 0, N);

	}
	
	static boolean check(int y, int x, int n) {
		char ch = map[y][x];  //0 or 1
		
		for(int i = y; i < y + n; i++) {
			for(int j = x; j < x+n; j++) {
				if(ch != map[i][j]) return false;
			}
		}
		
		System.out.print(ch);
		return true;
	}
	
	static void divide(int y, int x, int n) {
		
		//y,x로 시작하는 n크기의 정 사각형의 모든 문자가 동일한가?
		if(!check(y,x,n)) {
			System.out.print("(");
			
			int half = n/2;
			divide(y,x,half);
			divide(y, x+half, half);
			divide(y+half, x, half);
			divide(y+half, x+half, half);
			
			System.out.print(")");
		}
	}
	
}
