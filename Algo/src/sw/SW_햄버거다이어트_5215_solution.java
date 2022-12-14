package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_햄버거다이어트_5215_solution {
	
	static int T,N,L,max;
	static Item[] src, tgt;
	
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
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			//tgt (선택한 재료의 수가 고정X <== 가능한 조합을 모두 고려)
			for (int i = 1; i <= N; i++) {
				tgt = new Item[i];
				comb(0,0);
			}
			
			System.out.println("#" + t +" " + max);
		}
	}
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if( tgtIdx == tgt.length) {
			//complete code
			
			int cal = 0;
			int point = 0;
			
			//칼로리의 합
			for (int i = 0; i < tgtIdx; i++) {
				cal += tgt[i].c;
			}
			
			if(cal <= L) {
				for (int i = 0; i < tgtIdx; i++) {
					point += tgt[i].p;
				}
				max = Math.max(max, point);
			}	
			return;
		}
		
		
		if( srcIdx == N) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);  //현재 선택을 받아들인다.
		comb(srcIdx + 1, tgtIdx);      //현재 선택을 받아들이지 않는다.
		
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
