package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_준환이의양팔저울_3234_2 {

	static int T, N, ans;
	static int[] choo;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			choo = new int[N];
			select = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			
			perm(choo, select, 0,0,0);
			
			System.out.println("#" + t +" " +ans);
		}
	}
	
	// 파라미터 <= leftSum, rightSum
	static void perm(int[] choo, boolean select[], int tgtIdx, int leftSum, int rightSum) {
		
		if(rightSum > leftSum) return;
		
		if( tgtIdx == choo.length) {
			//complete code
			ans++;
			return;
		}
		
		for (int i = 0; i < choo.length; i++) {
			if( select[i] ) continue;
			
			select[i] = true;
			perm( choo, select, tgtIdx +1, leftSum + choo[i], rightSum); //i 번째 추를 왼쪽에
			perm( choo, select, tgtIdx +1, leftSum, rightSum + choo[i]); //i 번째 추를 오른쪽에
			select[i] = false;	
		}
	}
}
