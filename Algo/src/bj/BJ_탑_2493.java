package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_탑_2493 {
	
	static int N;
	static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) throws Exception{
		int num=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());	
			
			while(!stack.isEmpty() && num > stack.peek()[1]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}else {
				System.out.print( stack.peek()[0] + " ");
				
			}
			
			stack.push(new int[] {i, num});
		}
	}
}
