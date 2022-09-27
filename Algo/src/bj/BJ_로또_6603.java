package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_로또_6603 {
	
	static int k;
	static int[] tgt= new int[6];
	static int[] S;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫번째 숫자가 0이 들어올때까지 무한반복
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());   //k입력받기
			if(k == 0) break;  //k가 0이면 while문 종료 
			
			S = new int[k];    //S 배열에 k만큼 선언

			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());  //S배열 입력받기
			}
			
			comb(0,0);  //조합함수
			
			System.out.println();
			
		}
	}
	
	static void comb(int sIdx, int tgtIdx) {
		//tgt에 6개가 모두들어갔다는 의미
		if(tgtIdx == 6) {
			//기저조건
			for (int i = 0; i < tgtIdx; i++) {
				System.out.print(tgt[i] + " ");  //선택된 6개 출력
			}
			System.out.println();
			
			return;
		}
		
		if(sIdx == k) return; //S배열을 모두 돌면 return
		
		tgt[tgtIdx] = S[sIdx];
		
		comb(sIdx+1,tgtIdx+1);  //나 자신 선택 
		comb(sIdx+1,tgtIdx);    //나 자신 선택 X 		
	}
}
