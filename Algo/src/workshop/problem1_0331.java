package workshop;

//아파트 색칠하기
public class problem1_0331 {

	public static void main(String[] args) {
		int y=1, b=1;
		int[][] f = new int[9][2];
		
		f[1][0] = 1;  //노란색
		f[1][1] = 1;  //파란색
		
		for (int i = 2; i <= 8; i++) {
			f[i][0] = f[i-1][0] + f[i-1][1];
			f[i][1] = f[i-1][0];
		}
		
		System.out.println(f[8][0] + f[8][1]);

	}
}
