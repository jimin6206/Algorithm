package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_다리놓기_1010 {
	
	static int T,N,M;
	static BigInteger result;
	static BigInteger[] factorial = new BigInteger[30];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		//팩토리얼 구하기 ( M의 범위 : 1~29)
		factorial[0] = BigInteger.ONE;
		for (int i = 1; i < 30; i++) {
			factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));
		}
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//공식 사용
			BigInteger empty = factorial[M-N].multiply(factorial[N]);
			result = factorial[M].divide(empty);
			
			System.out.println(result); //결과 출력
		}
	}
}
