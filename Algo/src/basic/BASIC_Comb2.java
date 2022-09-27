package basic;

import java.util.Arrays;

public class BASIC_Comb2 {

	static int COUNT = 0;
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3];
	
	
	public static void main(String[] args) {
		comb(0, 0);
		System.out.println(COUNT);
		
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if( tgtIdx == tgt.length) {
			// complete code
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		if(srcIdx == src.length ) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx+1, tgtIdx+1);  //src 증가, tgt 증가 => 현재 srcIdx를 tgt 가 받아들이고 다음으로 간다.
		comb(srcIdx+1, tgtIdx);    //src 증가, tgt 증가X (그대로) => 현재 srcIdx 를 tgr가 안받겠다. 난 그대로 있을거니 넌 다음 것을 달라
		
		
		
		//조합이므로 이전에 src에서 사용한 것은 고려하지 않는다.
//		for (int i = srcIdx; i < src.length; i++) {
//			tgt[tgtIdx] = src[i];
//			comb(i+1, tgtIdx+1);
//		}
	}

}
