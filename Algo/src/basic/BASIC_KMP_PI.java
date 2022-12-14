package basic;

import java.util.Arrays;

public class BASIC_KMP_PI {

	public static void main(String[] args) {
		String pattern =  "ABABACA";
		System.out.println(Arrays.toString(getPI(pattern)));
		
	}
	
	static int[] getPI(String p) {
		int[] pi = new int[p.length()];
		char[] pArray = p.toCharArray();
		
		int j = 0;  //접두사 index
		for (int i = 1; i < pArray.length; i++) {  //i 접미사 index
			
			//불일치
			//패턴이 다른 경우  - 불일치
			while( j > 0 && pArray[i] != pArray[j] ) j = pi[j-1];
			
			
			if(pArray[i] == pArray[j]) {
				j++;
				pi[i] = j;
				
			}
		}
		
		return pi;
	}
}
