package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_규영이와인영이의카드게임_6808 {

	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9];
	static int[] inCard = new int[9];
	static int[] tgt = new int[9];
	static boolean[] select = new boolean[N];
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//초기화
			win=0;
			lose=0;
			Arrays.fill(input, 0);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 규영이의 카드
			int num=0;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				guCard[i] = num;
				input[num] = 1;
			}
			
			//인영이의 카드
			num=0;
			for (int i = 1; i <= 18; i++) {
				if(input[i] == 0) {
					inCard[num++] = i;
				}
			}
			
			perm(0);
			System.out.println("#" + t + " " +win + " " + lose);
		}
	}
	
	static void perm(int tgtIdx) {
		if(tgtIdx == N) {
			check();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(select[i]) continue;
			
			tgt[tgtIdx] = inCard[i];
			select[i] = true;
			perm (tgtIdx + 1);
			select[i] = false;
		}
	}
	
	static void check() {
		int guSum = 0;
		int inSum = 0;
		for (int i = 0; i < N; i++) {
			if(guCard[i] > tgt[i]) guSum += guCard[i] + tgt[i];
			else inSum += guCard[i] + tgt[i];
		}
		if(guSum > inSum) win++;
		else if(guSum < inSum) lose++;
	}
}
