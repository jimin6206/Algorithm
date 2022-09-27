package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_단어뒤집기2_17413 {

	static String S;
	static boolean tag;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			
			//태그일때의 처리방법
			if(c=='<') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				tag=true;
			}else if(c=='>') {
				tag= false;
				System.out.print(c);
				continue;
			}
			
			if(tag) {
				System.out.print(c);
				continue;
			}
			
			//단어일 경우 뒤집기
			if(c==' ') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(" ");
			}else {
				stack.add(c);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
