package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_설탕배달_2839 {
	static int N,five,three, empty,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		
		five = N/5;  //5로 나눠서 5kg가 최대가 되는 값을 찾는다.
		empty = N%5;  //empty에는 그 나머지를 저장한다.
		
		while(five>=0) { //5kg가 0봉지 미만이 되면 종료
			if(empty%3==0) {  //5kg봉지를 제외한 나머지가 3의 배수이면 종료
				three = empty/3;  //3kg가 몇봉지 필요한지 계산
				break;
			}
			else {  //남은 설탕량이 3의 배수가 아니면 
				five--;   //5kg 봉지수를 줄인다.
				empty = N - 5*five;  //5kg를 줄이고 난 후의 남은량 계산
			}
		}
		
		if(five<0) ans=-1;  //반복문을 다 돌았는데 five가 0보다 작으면 방법x이므로 -1
		else ans = five + three;  //그게 아나라면 five와 three의 합을 계산
		 
		System.out.println(ans);  //결과출력
	}
}
