package workshop;

public class problem2_0331 {

	public static void main(String[] args) {
		int[] dp = new int[7];
		dp[1] = 2;
		dp[2] = 5;
		for (int i = 3; i <= 6; i++) {
			dp[i] = (dp[i-1]*2) + (dp[i-2]);
		}
		
		System.out.println(dp[6]);
	}
}
