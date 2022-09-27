package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_이항계수구하기_3238 {

	static int T, p;
	static long N, R;
	static long result;
	static long[] fac;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			R = Long.parseLong(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			fac = new long[(int)N+1];
			fac[0]=1; 
			for (int i = 1; i <= N; i++) {
				fac[i] = fac[i-1] *i; 
				fac[i] %= p;
			}
			
			long a = fac[(int)N];
			long b = (fac[(int)R]*fac[(int)(N-R)])%p;
			result = pow(b,p-2);
			
			result = (result *a)%p;
		
			//결과출력
			System.out.println("#"+t+" "+result);
		}

	}
	
	static long pow(long a, long b) {
		if( b==0 )return 1;  //지수가 0이면 1
		else if( b==1 ) return a; //지수가 1이면 a그대로 리턴
		
		//분할정복
		if(b%2==0) {  //짝수면 거듭제곱을 두개로 나눠서 제곱한 뒤 곱함 
			long temp = pow(a,b/2);
			return (temp*temp)%p;
		}
		//홀수면  지수를 1빼서 짝수로 만들어주고 a를 한번 곱해준다.
		long temp = pow(a, b-1)%p;
		return (temp*a)%p;	
	}

}
