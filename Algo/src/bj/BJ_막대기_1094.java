package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_막대기_1094 {

	public static void main(String[] args) throws Exception {
		int X=0,cnt=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine()); //막대의 길이 입력받기
		
		//X를 2진수로 표현해서 비트가 1인 개수를 찾는 것과 같다
		for (int i = 0; i <= 6; i++) { //2의 6승까지므로 총 비트가 7개
			if((X & (1<<i)) != 0) {  //해당자리가 0이면  (1<<i)와 & 연산을 하면 무조건 0이나온다.
				cnt++;  //즉, 0이 아닐때만 count
			}
		}
		
		System.out.println(cnt); //결과 출력
	}
}
