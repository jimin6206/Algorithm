package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_안테나_18310 {

	static int N, result;
	static int[] home;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		home = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(st.nextToken());  //집 입력받기
		}
		
		Arrays.sort(home); //집들을 정렬
		
		//결론부터 말하면 무조건 중간집이 답이 된다.
		//홀수일 경우 => 중간값
		//짝수일 경우 => 두개의 중간 값 중 더 앞에 있는 값
		// 즉, (N-1)/2 
		result = home[(N-1)/2];
		
		//결과 출력
		System.out.println(result);
	}
}
