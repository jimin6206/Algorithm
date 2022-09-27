package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_괄호짝짓기_1218 {

	static int T=10 , N;
	static char[] src;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//10개의 테케
		for (int t = 1; t <= T; t++) {
			int result = -1;
			Stack<String> stack = new Stack<>();

			N = Integer.parseInt(br.readLine());
			
			src = new char[N];
			
			String empty = br.readLine();
			src = empty.toCharArray();
			
			for (int i = 0; i < N; i++) {
				switch(src[i]) {
				case '(' : stack.add("("); break;
				case '[' : stack.add("["); break;
				case '{' : stack.add("{"); break;
				case '<' : stack.add("<"); break;
				
				case ')' : if( stack.peek()=="(" ) {
								stack.pop();
							} else  {
								result = 0;
							}; break;
				case ']' : if( stack.peek()=="[" ) {
								stack.pop();
							} else  {
								result = 0;
							}; break;
					
				case '}' : if( stack.peek()=="{" ) {
								stack.pop();
							} else  {
								result = 0;
							}; break;
							
				case '>' : if( stack.peek()=="<" ) {
								stack.pop();
							} else  {
								result = 0;
							}; break;
				}
				
				if(result == 0) {
					break;
				}
			}
			
			if(stack.isEmpty() ) {
				result = 1;
			}

			System.out.println("#" + t + " " + result);
	
		}
	}
}
