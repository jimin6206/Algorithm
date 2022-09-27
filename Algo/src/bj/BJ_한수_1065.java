package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_한수_1065 {

	static int N, cnt=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //N입력받기
		
		if(N < 100) { //N이 두자리 수면 모두 등차수열 (비교대상이 없기때문) --> 1~99는 모두 한수이다.
			cnt = N; //cnt에 바로 N을 대입
		}else { 
			cnt = 99; //N이 세자리 수면 99개는 한수이므로 초기 cnt를 99로 업데이트
			for(int i = 100; i <= N; i++) { //100부터 N까지 검사
				int num = i;  
				int hundred = num/100;  //백의 자리 수
				num = num%100;  
				int ten = num/10;  //십의 자리 수
				num = num%10;  
				int one = num; //일의 자리 수
				
				if((hundred - ten) == (ten - one)) {  //각 자리의 차가 같으면 == 한수
					cnt++; //cnt 증가
				}
			}
		}
		System.out.println(cnt); //결과 출력
	}
}
