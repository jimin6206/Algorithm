package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BJ_로프_2217 {

	static int N, max=0;
	static Integer[] rope; //로프 정보를 담은 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //로프의 수
		rope = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());  //배열에 로프를 담는다
		}
		
		Arrays.sort(rope, Collections.reverseOrder()); //로프를 내림차순 정렬
		
		for (int i = 0; i < N; i++) {  
			if(max < rope[i]*(i+1) ) {
				max = rope[i]*(i+1);  // 최대값 업데이트
			}
		}
		
		// 20 16 12 5 3  -> 밧줄의 정보가 이렇게 있을때
		// 1개사용 => 20
		// 2개 사용 => 16*2=32
		// 3개 사용 => 12*3=36   ===> 얘가 정답
		// 4개 사용 => 5*4=20
		// 5개 사용 => 3*5=15
		
		System.out.println(max);  //결과 출력
	}
}
