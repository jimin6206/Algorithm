package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_사칙연산유효성검사_1233 {
	static int T = 10, N;
	static char[] tree;
	static int end;
	static int result = 1;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1];
			result = 1;
			
			for (int i = 1; i <= N; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			
			if(N%2==0) end = N/2;
			else end=N/2+1;
			
			for (int i = N; i > 0; i--) {
				
				if(i > N-end ) {
					if(!isNum(i)) {
						result = 0;
						break;
					}
				}else {
					if(isNum(i)) {
						result = 0;
						break;
					}
				}
			}			
			System.out.println("#" + t +" " + result);
		
		}
	}
	
	static boolean isNum(int idx) {
		return Character.isDigit(tree[idx]);
	}
}
