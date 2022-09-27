package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
//import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_탑_2493_ArrayDeque {
	
	static int N;
//	static Stack<int[]> stack = new Stack<>(); // int[0]:번호, int[1]:높이
	static ArrayDeque<int[]> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//탑 1개씩 처리
		//index 1부터
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());	
			
			//탑 1개 기준 이전에 담긴 탑들을 고려
			//현재 탑보다 이전의 탑이 더 크다=> 그 탑의 번호 출력
						
			while(!stack.isEmpty() ) {
				
				// 스택의 최근 탑이 나보다 크거나 같다.
				if( height < stack.peek()[1]) {	
					System.out.print( stack.peek()[0] + " ");
					break;
				}
				
				//나보다 작은경우는 제거 !!
				stack.pop();			
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
				

			stack.push(new int[] {i, height});
		}
	}
}
