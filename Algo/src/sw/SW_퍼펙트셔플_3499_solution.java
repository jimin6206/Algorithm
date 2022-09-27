package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_퍼펙트셔플_3499_solution {

	static int T,N;
	static String[] card;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			sb.setLength(0);
			
			
			N = Integer.parseInt(br.readLine());
			card = new String[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				card[i] = st.nextToken();
			}
			
			//출력
			sb.append("#").append(t).append(" ");
			
			// 2 집단 나누어서 index 하나씩 각각 꺼내서 sb에 담는다.
			boolean isOdd = N % 2 == 0 ? false : true;
			int divideIdx = isOdd ? N/2 + 1 : N/2;
			
			int size = N/2;
			
			for (int i = 0; i < size; i++) {
				sb.append(card[i]).append(" ");
				sb.append(card[divideIdx+i]).append(" ");
				
			}
			
			if( isOdd ) {
				sb.append(card[size]).append(" ");
			}
			
			System.out.println(sb);
		}		
	}
}
