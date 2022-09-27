package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_비트가넘쳐흘러_17419 {
	
	static int N, cnt=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //이진수의 크기?
		String bit = br.readLine();  //이진수를 string으로 받아옴
		
		for (int i = 0; i < N; i++) {
			if(bit.charAt(i) == '1') {  //string을 한글자씩 가져와서 1인 개수를 카운트
				cnt++;
			}
		}
		
		System.out.println(cnt);  //결과 출력
	}
}
