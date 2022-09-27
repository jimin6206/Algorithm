package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_순열의순서_1722 {

	static int N, Q;
	static long K;  
	static int[] src, tgt, input;
	static long[] factorial;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //N입력받기 (N<=20)
		
		src = new int[N];     //1~N이 담겨있는 배열
		tgt = new int[N];     //Q1에서 K번째 순열을 담을 배열
		input = new int[N];   //Q2에서 현재 순열을 담을 배열
		check = new boolean[N+1];   //값을 사용했는지 확인을 위한 배열
		factorial = new long[N+1];  //팩토리얼을 N!까지 미리 계산 -> 최대 20!까지 나올수 있으므로 long으로 선언
		
		//팩토리얼 미리 계산해두기(N만큼)
		factorial[0] = 1;
		for (int i = 1; i <= N; i++) {
			factorial[i] = factorial[i-1]*i;
		}
		//src배열 만들기 ( 1~N까지 담는다)
		for (int i = 0; i < N; i++) {
			src[i] = i+1;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken());  //문제번호 입력받기
		if(Q==1) {  //1일경우 K입력받기
			K = Long.parseLong(st.nextToken());
			Q1();
		}else if(Q==2){  //2일경우 배열을 입력받기(input)
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			Q2();
		}
	}

	//문제1 : K번째 순열 찾기
	static void Q1() {
		int n=N;  
		//각 자리수 정하기
		for (int i = 0; i < N; i++) {  //i번째 자리에 올 수는 j
			for (int j = 1; j <= N; j++) {
				if(check[j]) continue;   //이미 이전에 사용된 값은 패스
				if(K<=factorial[n-1]) {   //N이 4라고 했을때, 첫번째자리값이 1인 경우 => 3!   두번째자리값이 2인경우 => 2!
					tgt[i] = j;						   //첫번째자리값이 2인경우 => 3!
					check[j] = true;
					n--;
					break;
				}else {
					K-=factorial[n-1];
					
				}
			}
			//결과 출력
			System.out.print(tgt[i] + " ");
		}
	}
	
	//문제2 : 해당 순열이 몇번째인지 구하기
	static void Q2() {
		long result = 1;
		int n = N;
		for (int i = 0; i < N; i++) {  //i번째 자리 수 j
			for (int j = 1; j <= N; j++) {
				if(check[j]) continue;
				if(input[i]!=j) {    //위랑 똑같이 현재 순열의 번호에 따라 (n-1)!씩 더해주면 된다.
					result += factorial[n-1];
				}else {
					check[j]= true;
					n--;
					break;
				}
			}
		}
		//결과 출력
		System.out.println(result);
	}	
}
