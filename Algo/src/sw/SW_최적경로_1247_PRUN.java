package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_최적경로_1247_PRUN {

	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] cust;  //src
	static int[] tgt;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			min = Integer.parseInt(br.readLine());
			cust = new int[N][2];
			select = new boolean[N];
			tgt = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			
			perm(0, 0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void perm(int tgtIdx, int sum) {
		//기저조건
		if(tgtIdx == N) {
			//complete code
			
			sum += distance(homeY,homeX, cust[ tgt[N-1] ][0], cust[ tgt[N-1] ][1]);
			
			min = Math.min(min, sum);
			
			return;
			
		}
		
		for (int i = 0; i < N; i++) {
			if( select[i] ) continue;
			select[i] = true;
			tgt[tgtIdx] = i;
			int dis = 0;
			
			if(tgtIdx == 0) {
				dis = distance(comY, comX, cust[ tgt[0] ][0], cust[ tgt[0] ][1]);
			}else {
				dis = distance(
						cust[ tgt[tgtIdx-1] ][0], cust[ tgt[tgtIdx-1] ][1], 
						cust[ tgt[tgtIdx] ][0], cust[ tgt[tgtIdx] ][1]
					);
			}
			if(sum+dis < min) {
				perm(tgtIdx+1, sum + dis);				
			}
			select[i] = false;
		}
	}

	//맨하탄 거리
	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2); 
	}
}
