package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_한빈이와SpotMart_9229_solution {

	static int T, N, M, ans;
	static int[] src, tgt;
	   
	   public static void main(String[] args) throws Exception {
	      
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      T = Integer.parseInt(br.readLine());
	      
	      for (int test_case = 1; test_case <= T; test_case++) {
	         
	         ans = -1;   // 방법이 없을 경우
	         
	         StringTokenizer st = new StringTokenizer(br.readLine());
	         
	         N = Integer.parseInt(st.nextToken());   // 과자 봉지 수
	         M = Integer.parseInt(st.nextToken());   // 무게 제한
	         
	         src = new int[N];
	         tgt = new int[2];
	         
	         st = new StringTokenizer(br.readLine());
	         
	         for (int i = 0; i < N; i++) {
	            src[i] = Integer.parseInt(st.nextToken());
	         }
	         
	         comb(0, 0);
	         System.out.println("#" + test_case + " " + ans);
	      }

	   }
	   
	   static void comb(int srcIdx, int tgtIdx) {
	      // 기저 조건
	      if ( tgtIdx == 2 ) {
	         // complete code
	         int sum = tgt[0] + tgt[1];
	         if ( sum > M ) return;
	         ans = Math.max(ans, sum);
	         return;
	      }
	      
	      for (int i = srcIdx; i < src.length; i++) {
	         tgt[tgtIdx] = src[i];
	         comb( i + 1, tgtIdx + 1 );
	      }
	   }

}
