package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_집합_11723 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); //연산의 수
		int S=0;  //집합  (비트마스킹으로 집합을 표현)
		
		//StringBuilder 안쓰면 시간초과 주의 !!
		StringBuilder sb = new StringBuilder();

		//연산수만큼 반복
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String operation = st.nextToken();  //연산자 입력받기
			int x=0;
			
			//스위치로 연산자별로 처리를 따로 해줌
			switch(operation) {
				case "add" : //집합에 추가
					x = Integer.parseInt(st.nextToken()) - 1; //x를 입력받고 (문제에 시작인덱스가 1이므로 -1해줌)
					S |= (1<<x);  // x자리만 1이되어서 | 연산하면 x자리가 무조건 1로 바뀜
					break;
				case "remove" : //집합에서 삭제
					x = Integer.parseInt(st.nextToken()) - 1;
					S &= ~(1<<x);  //x자리만0이므로 & 연산하면 x자리는 무조건 0이된다.
					break;
				case "check" : //집합에 x가 포함되어있는 지 확인
					x = Integer.parseInt(st.nextToken()) - 1;
					if((S & (1<<x)) != 0) { //x자리만 1이므로 & 연산하면 해당자리가 0이면 연산결과가 0 / 1이면 해당자리만 1
						sb.append("1\n"); //0이 아니면  x를 포함하고 있다는 의미이므로 
					}else {
						sb.append("0\n"); //x가 포함되어있지않으면 결과가 0이 나옴
					}
					break;
				case "toggle" : //집합에 x를 반전
					x = Integer.parseInt(st.nextToken()) -1;
					S ^= (1<<x); // ^연산으로 x자리의 비트를 반전시켜준다 
					break;
				case "all" : //집합이 1~20모두 포함해야하므로 
					S = (1<<20)-1;  //집합을 1111111111 1111111111 으로 만들어준다는 의미
					break;
				case "empty" : //집합을 공집합으로
					S = 0;  //S를 0으로 0000000000 0000000000 으로 만들어준다는 의미
					break;
			}
			
		}
		System.out.println(sb); //결과 출력
	}
}
