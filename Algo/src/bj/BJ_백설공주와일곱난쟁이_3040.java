package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_백설공주와일곱난쟁이_3040 {
	static int[] src = new int[9];
	static int[] tgt = new int[7];
	static int sum=0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//난쟁이 아홉명의 모자숫자 입력받기
		for (int i = 0; i < 9; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		
		//조합함수 호출
		comb(0,0);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if( tgtIdx == tgt.length) {  //7개의 조합을 찾으면
			// complete code
			sum=0;
			for (int i = 0; i < tgtIdx; i++) {  
				sum += tgt[i];   //7개의 합을 계산
			}
			if(sum==100) {  //합이 100이면 결과출력
				for (int i = 0; i < tgtIdx; i++) {
					System.out.println(tgt[i]);
				}
			}
			return;
		}	
		//9개의 수를 모두 확인했으면 return
		if(srcIdx == src.length ) return;
		
		tgt[tgtIdx] = src[srcIdx];  //tgt에 src의 srcIdx를 담음
		
		comb(srcIdx+1, tgtIdx+1);  //현재 srcIdx의 수를 담고, 다음호출
		comb(srcIdx+1, tgtIdx);    //현재 srcIdx의 수를 담지않고, 다음 호출
	}
}
