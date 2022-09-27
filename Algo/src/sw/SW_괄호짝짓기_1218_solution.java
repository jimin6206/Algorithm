package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_괄호짝짓기_1218_solution {

	static int N, ans;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//10개의 테케
		for (int t = 1; t <= 10; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			//초기화
			ans = 0;
			stack.clear();
				
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				char token = str.charAt(i);
				
				//시작 문자
				if(token == '<' || token == '{' || token == '(' || token == '[') {
					stack.push(token);
				} else {
					if(stack.isEmpty()) break;
					
					char prev = stack.peek();
					if( token == '>' && prev != '<') break;
					else if( token == '}' && prev != '{') break;
					else if( token == ')' && prev != '(') break;
					else if( token == ']' && prev != '[') break;
					else stack.pop();
					
				}
			}
			
			if(stack.isEmpty()) ans = 1;
			
			System.out.println("#" + t + " " + ans);
	
		}
	}
}
