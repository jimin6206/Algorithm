package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_햄버거다이어트_5215_가지치기 {
	
	static int T,N,L,max;
	static Item[] src;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//초기화
			max=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  //재료 수
			L = Integer.parseInt(st.nextToken());  //제한 칼로리
			
			src = new Item[N];
			select = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			//부분집합
			dfs(0,0,0);
			
			System.out.println("#" + t +" " + max);
		}
	}
	static void dfs(int srcIdx, int point, int cal) {  //point 누적, cal 누적
		//칼로리 기저조건 - 가지치기
		if(cal > L) return;		
		//기저조건
		if( srcIdx == N) {
			//complete code		
			max = Math.max(max, point);
			
			return;
		}
		
		//현재 srcIdx 선택
		dfs(srcIdx+1, point + src[srcIdx].p, cal + src[srcIdx].c);
		
		//현재 srcIdx 선택X
		dfs(srcIdx+1, point, cal);
	}
	
	static class Item {
		int p; //점수
		int c; //칼로리
		
		public Item(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
	
}
