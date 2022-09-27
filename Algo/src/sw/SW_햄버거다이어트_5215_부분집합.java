package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_햄버거다이어트_5215_부분집합 {
	
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
			subset(0);
			
			System.out.println("#" + t +" " + max);
		}
	}
	static void subset(int srcIdx) {
		//기저조건
		if( srcIdx == N) {
			//complete code
			
			int cal = 0;
			int point = 0;
			
			//칼로리의 합
			for (int i = 0; i < N; i++) {
				if(select[i]) {
					cal += src[i].c;
					point += src[i].p;
				}
			}
			
			if(cal <= L)  max = Math.max(max, point);
			
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);  //현재 선택을 받아들인다.
		select[srcIdx] = false;
		subset(srcIdx + 1);      //현재 선택을 받아들이지 않는다.
		
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
