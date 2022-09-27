package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_기차가어둠을헤치고은하수를_15787 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //기차의 수
		int M = Integer.parseInt(st.nextToken()); //명령의 수
		int cnt = 1;  //은하수를 건널수 있는 기차의 수 (1번 기차는 무조건 지날수있으므로 초기값 1)
		
		long[] train = new long[N]; //N개의 기차를 배열로 표현  
									//각 기차의 좌석은 비트로 표현  ex) 0111100...
		//M개의 명령어 수행
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int operation = Integer.parseInt(st.nextToken()); //명령번호
			int i,x;
			
			switch(operation) {
				case 1: //i번째기차에 x좌석에 사람을 태워라
					i = Integer.parseInt(st.nextToken())-1;  //초기인덱스가 1이므로 1씩 빼준다
					x = Integer.parseInt(st.nextToken())-1;  //문제에서의 1번 = 코드에서의 0번
					train[i] |= (1<<x);  //i번째 기차의 x자리를 1로 만든다
					break;
				case 2: //i번째 기차에 x좌석에 사람을 하차
					i = Integer.parseInt(st.nextToken())-1;
					x = Integer.parseInt(st.nextToken())-1;
					train[i] &= ~(1<<x);  //i번째 기차의 x자리를 0으로 만든다
					break;
				case 3: //i기차의 승객을 모두 뒤로 한칸씩
					i = Integer.parseInt(st.nextToken())-1;
					train[i] = (train[i]<<1);  //i번째 기차 자체를 왼쪽으로 쉬프트 시켜준 후
					train[i] &= ~(1<<20);  //좌석이 20좌석밖에 없으므로(코드에서는 0~19) 20번째는 0으로 만들어준다.
					break;
				case 4: //i기차의 승객을 모두 앞으로 한칸씩
					i = Integer.parseInt(st.nextToken())-1;
					train[i] = (train[i]>>1);  //i번째 기차 자체를 오른쪽으로 쉬프트 시켜준다 (0번째는 알아서 사라짐)
					break;
			}
		}
		//연산이 모두 끝나면 몇개의 기차가 은하수를 건널수 있는 지 검사
		for (int i = 1; i < N; i++) {  //0번째 기차는 무조건 지날수 있으므로 1번째부터 시작
			boolean same=false;  //i번째 기차 이전에 자신과 같은 패턴이 있는 지 확인하는 변수
			for (int j = 0; j < i; j++) { //0번부터 자기 앞기차까지 확인
				if(train[i] == train[j]) { //만약 같은 패턴기차가 있다면
					same = true;  //same 을 true로 업데이트 시키고 
					break;   //더이상 찾을 필요 없으므로 break
				}
			}
			if(!same) cnt++;  //자신보다 앞에 있는 기차들을 모두 검사한 후에도 same이 false 라면 같은패턴이 없다는 의미 (cnt증가)
		}
		
		//결과 출력
		System.out.println(cnt);
	}
}
