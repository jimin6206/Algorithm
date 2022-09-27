package basic;

//피보나치
//1,1,2,3,5,8,13,21......
public class BASIC_DP_Fibonacci {

	public static void main(String[] args) {
//		long result = fibo_rc(40);
		long result = fibo_dp(50);
		System.out.println(result);

	}
	
	static long fibo_rc(long n) {
		//기저조건
		if( n <= 1) return n;
		
		return fibo_rc(n-1) + fibo_rc(n-2);
	}
	
	static long fibo_dp(int n) {
		//memoization
		long[] memoi = new long[n+1];
		
		//initialization
		memoi[0] = 0;
		memoi[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			memoi[i] = memoi[i-1]+ memoi[i-2];
		}
		
		return memoi[n];
	}

}
