package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_퍼펙트셔플_3499 {

	static int T,N;
	static String[] cardA,cardB;
	static String[] result;
	static int A_size, B_size;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			result = new String[N];
			//카드 사이즈 처리
			if(N%2 ==1) {
				A_size = (N/2)+1;
				cardA = new String[A_size];
			}else {
				A_size = N/2;
				cardA = new String[A_size];
			}
			B_size = N/2;
			cardB = new String[B_size];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				if(i<A_size) cardA[i] = st.nextToken();
				else cardB[i-A_size] = st.nextToken();
			}
			int j=0;
			for (int i = 0; i < B_size; i++) {
				result[j++] = cardA[i];
				result[j++] = cardB[i];				
			}
			
			if(A_size > B_size) {
				result[j] = cardA[A_size-1];
			}
			
			//출력
			System.out.print("#"+t+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
		
	}

}
