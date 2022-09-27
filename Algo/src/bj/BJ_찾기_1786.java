package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_찾기_1786 {
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		String P = br.readLine();
		
		kmp(T, P);
		
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void kmp(String text, String pattern) {
		int[] pi = getPI(pattern);
		
		int tLength = text.length();
		int pLength = pattern.length();
		
		char[] tArray = text.toCharArray();
		char[] pArray = pattern.toCharArray();
		
		int j=0;
		
		for (int i = 0; i < tLength; i++) {
			while( j>0 && tArray[i] != pArray[j]) j = pi[j-1];
			
			if(tArray[i] == pArray[j]) {
				//모두 일치했나? 그렇지 않은가?
				if( j == pLength - 1) { //일치
					cnt++;
					// 0123456789.....
					//  CAABAABAB.....  i : 8
					//    ABAABAB :  j = 7-1 = 6
					sb.append(i - pLength + 2).append(" ");		
					j = pi[j];
				}else {
					j++;
				}
				
			}
		}
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
