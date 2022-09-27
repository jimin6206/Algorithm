package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_보물_1026 {

	static int N, result=0;
	static Integer[] A,B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new Integer[N];  //A배열
		B = new Integer[N];  //B배열
		
		//각각의 배열 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		//결과가 가장 작으려면 가장 큰값과 가장 작은 값을 곱해야한다. 
		//즉, 하나의 배열은 오름차순, 하나의 배열은 내림차순으로 두고 계산해야 최소값
		Arrays.sort(A, Collections.reverseOrder());  //A배열을 내림차순
		Arrays.sort(B); //B배열을 오름차순
		
		for (int i = 0; i < N; i++) {
			result += A[i]*B[i];  //각 자리의 곱을 더한다
		}
		
		//결과 출력
		System.out.println(result);
	}
}
