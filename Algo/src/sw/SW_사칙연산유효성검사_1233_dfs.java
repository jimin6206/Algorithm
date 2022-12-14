package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_사칙연산유효성검사_1233_dfs {
	
	static int N, ans;
	static char[] node;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];
			
			//두번째만 처리
			for (int i = 1; i <= N; i++) {
				
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}
			
			//유효성 검사
			
			ans = dfs(1) ? 1: 0;
			
			System.out.println("#" + t +" " + ans);
			
		}
	}
	
	static boolean dfs(int x) {
		//기저 조건
		if( x > N) return false;
		
		if( Character.isDigit(node[x])) { //숫자 노드 (맨 끝이어야한다.)
			if( x*2 > N ) return true;
			return false;
		} else {  //연산자 노드 <= 자식의 유효성을 검사한 후에 판단 <= 재귀호출을 이어가라
			return (dfs(x*2) && dfs(x*2+1)) ;
		}
	}

}
