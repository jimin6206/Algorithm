package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_K번쨰수_11004 {

	static int N,K;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //수의 개수
		K = Integer.parseInt(st.nextToken()); //K번째 수를 찾아야함
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] =Integer.parseInt(st.nextToken()); //배열에 N개의 수 담기
		}
		
		//오름차순으로 정렬
		Arrays.sort(num);
		
		//K번째 수를 출력
		System.out.println(num[K-1]);
	}
}
