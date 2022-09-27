package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_로또_6603_solution2 {
	
	static int N;
	static int[] src, tgt; 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while( true ) {
			
			String input = br.readLine();
			if( input.charAt(0) == '0') break;
			
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());   
			src = new int[N];    
			tgt = new int[6];

			for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());  //S배열 입력받기
			}
			
			comb(0,0);
			
			sb.append("\n");
			
		}
		
		sb.setLength(sb.length()-2);
		System.out.println(sb);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		
		if(tgtIdx == 6) {
			//기저조건
			for (int i = 0; i < tgtIdx; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");		
			return;
		}
		
		if(srcIdx == N) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx+1,tgtIdx+1);  //나 자신 선택 
		comb(srcIdx+1,tgtIdx);
	}

}
