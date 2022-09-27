package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_요리사_4012 {
	static int T, N, min; 
	static int[][] food;
	static int[] arrA, arrB;
	static boolean[] select;  //tgt 역할, 반만 선택한 상태를 관리
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			food = new int[N][N];
			select = new boolean[N];
			arrA = new int[N/2];
			arrB = new int[N/2];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			
			comb(0,0);
			
			System.out.println("#" + t + " " + min );
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		//반반 나누었다. <= select 배열에 표기
		if(tgtIdx == N/2) {
			//complete
			check();
			return;
		}
		
		if(srcIdx == N) return;
		
		select[srcIdx] = true;
		comb(srcIdx + 1, tgtIdx + 1);  //현재 srcIdx를 tgtIdx에 받아 들이겠다. 그러니 다음으로 간다.
		
		select[srcIdx] = false;
		comb(srcIdx + 1, tgtIdx);      //현재 srcIdx를 tgtIdx에 받지 않겠다. 그러니 tgtIdx 를 그대로 다시	
	}
	
	static void check() {
		// arrA, arrB 구성
		// 문제에 맞게 처리
		
		//음식 맛
		int sumA = 0;
		int sumB = 0;
		
		int idxA = 0;
		int idxB = 0;
		
		// 8개   f f t f t t t f
		// arrA [2, 4, 5, 6]  N/2
		// arrB [0, 1, 3, 7]
		for (int i = 0; i < N; i++) {
			if( select[i] ) arrA[idxA++] = i;
			else arrB[idxB++] = i;
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if( i==j ) continue;
				
				sumA += food[arrA[i]][arrA[j]];
				sumB += food[arrB[i]][arrB[j]];
			}
		}
		
		min = Math.min(min, Math.abs(sumA - sumB));
	}

}
