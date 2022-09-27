package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_차이를최대로_10819 {

	static int N, sum=0, result = 0;
	static int[] src, tgt;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N];  //주어진 배열
		tgt = new int[N];  // 순열(새로운 배열을 담을 배열)
		select = new boolean[N];  //이전에 사용한 값인지 확인용
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken()); //배열 입력받기
		}
		
		perm(0); //순열
		
		System.out.println(result);
	}
	
	static void perm(int tgtIdx) {
		//기저조건
		if( tgtIdx == tgt.length) {  //N개의 수가 tgt에 모두 들어갔다.
			// complete code
			sum=0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(tgt[i] - tgt[i+1]);  //이웃한 자리와의 차를 계산
			}
			result = Math.max(result, sum); //그 결과가 최대인 값을 result로 업데이트
			return;
		}
		
		//순열이니까 모든 src의 수를 고려한다.
		for (int i = 0; i < src.length; i++) {
			if(select[i]) continue;  //기존자리의 수들과 중복되는지 체크
			tgt[tgtIdx] = src[i];    //tgt 배열에 i번째 수 넣기
			select[i] = true;  //현재 i 사용
			perm( tgtIdx + 1); //다음 수 뽑으러 가기
			select[i] = false; //재귀를 다 돌고 왔기때문에 select[i] 초기화
		}
	}
}
