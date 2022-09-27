package basic;

import java.util.Arrays;

//////////////////순열/////////////////////
public class BASIC_Perm {

	static int COUNT = 0;
	static int[] src = {1,2,3,4,5};   //5개중에
	static int[] tgt = new int[3];    //3개를 뽑아서 줄세움
	static boolean[] select = new boolean[src.length];  //선택된 수 확인용

	public static void main(String[] args) {
		perm(0);
		System.out.println(COUNT);
	}
	
	
	static void perm(int tgtIdx) {
		//기저조건
		if( tgtIdx == tgt.length) {
			// complete code
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		//순열이니까 모든 src의 수를 고려한다.
		for (int i = 0; i < src.length; i++) {
			if(select[i]) continue;  //기존자리의 수들과 중복되는지 체크
			tgt[tgtIdx] = src[i];    
			select[i] = true;  //현재 i 사용
			perm( tgtIdx + 1); //다음 수 뽑으러 가기
			select[i] = false; //재귀를 다 돌고 왔기때문에 select[i] 초기화
		}
	}
}
