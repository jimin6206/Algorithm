package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_부분수열의합_1182 {

	static int N,S, sum, cnt=0;
	static int[] src;
	static boolean[] select; //선택된 수를 boolean으로 확인
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //수의 개수
		S = Integer.parseInt(st.nextToken());  
		
		src = new int[N];  //기존 배열
		select = new boolean[N];  //부분집합을 표현할 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());  //src 담기
		}
		
		subset(0); //부분집합 구하기
		
		if(S==0) {  //S가 0이면 공집합도 포함이 되므로 1 빼준다.
			cnt--;
		}
		System.out.println(cnt); //결과 출력
	}
	
	static void subset(int srcIdx) {
		//기저조건
		if( srcIdx == src.length) { //원소 N개를 모두 돌았으면 부분집합 완성
			// complete code
			sum = 0;
			for (int i = 0; i < N; i++) {
				if(select[i]) { //선택된 원소만
					sum += src[i];  //sum 변수에 더해준다.
				}
			}
			if(sum == S) { //원소들의 합이 S가 되면 카운트
				cnt++;
			}
			return;
		}
		
		//현재 srcIdx 를 선택하고 간다.
		select[srcIdx] = true;
		subset(srcIdx +1);	
		//현재 srcIdx 를 선택안하고 간다.
		select[srcIdx] = false;
		subset(srcIdx +1);	
	}
}
