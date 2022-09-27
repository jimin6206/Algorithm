package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2의보수_24389 {

	public static void main(String[] args) throws Exception {
		int N, result, cnt=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 숫자 입력받기
		
		result = N ^ (~N+1);  //N 과 N의 2의보수 의 ^연산

		for (int i = 0; i < 32; i++) {  //32비트 기준
			if((result & (1<<i)) != 0) {  //각자리가 1이면 카운트
				cnt++;
			}
		}
		//결과 출력
		System.out.println(cnt);
	}
}

