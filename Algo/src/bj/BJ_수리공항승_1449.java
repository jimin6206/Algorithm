package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_수리공항승_1449 {

	static int N,L,cnt=0;
	static int[] pipe = new int[1001]; //파이프의 위치에 물이 새면 1 / 정상이면 0
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //물이 새는 곳의 개수
		L = Integer.parseInt(st.nextToken()); //테이브의 길이
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pipe[Integer.parseInt(st.nextToken())] = 1;  //물에 새는 곳만 1로 표시
		}		
		
		for (int i = 1; i <= 1000; i++) { //파이프 전체를 검사
			
			if(pipe[i]==1) { //구멍난 곳
				i += (L-1); //테이프의 길이만큼 넘어감
				cnt++; //count
			}
		}
		//결과 출력
		System.out.println(cnt);
	}
}
