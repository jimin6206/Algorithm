package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_피보나치함수_1003 {
	static int T, N;
	static int[][] cnt = new int[41][2];

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        T = Integer.parseInt(br.readLine());  //테케 입력받기
        cnt[0][0] = 1;   //피보나치 수열에서 f[0]은 0이 한번 호출
        cnt[0][1] = 0;   //f[0]은 1은 호출 X
        cnt[1][0] = 0;   //f[1]은 0은 호출 X
        cnt[1][1] = 1;   //f[1]은 1이 한번 호출
        //테케만큼 반복
        for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());  //N 입력받기
			for (int i = 2; i <= N; i++) { //2부터 N까지 반복
				cnt[i][0] = cnt[i-1][0] + cnt[i-2][0];  //i번째 0이 호출되는 수 는 i-1번째의 0호출수와 i-2번쨰의 0호출수의 합이다.
				cnt[i][1] = cnt[i-1][1] + cnt[i-2][1];  //i번째 1이 호출되는 수 는 i-1번째의 1호출수와 i-2번쨰의 1호출수의 합이다.
			}
			System.out.println(cnt[N][0] + " " + cnt[N][1]);  //결과 출력
		}
	}
}
