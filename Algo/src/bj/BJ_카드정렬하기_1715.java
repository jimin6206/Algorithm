package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_카드정렬하기_1715 {

	static int N;
	static long result=0;
	static PriorityQueue<Integer> card = new PriorityQueue<Integer>(); //우선순위 큐사용

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			card.add(Integer.parseInt(br.readLine())); //큐에 카드 묶음개수를 전부 넣기 (우선순위 큐이므로 작은 순대로 나올것)
		}
		
		//풀이 : 묶음들 중 최소가 되려면 가장 작은 두 묶음을 합쳐야함 ! 
		//앞에서 더한 두 묶음을 결과값이 더해준 뒤 둘을 합한 카드를 다시 한 묶음으로 봐야함 ! 큐에 다시 추가
		while(card.size() != 1) { //큐에 하나가 남으면 마지막까지 다 합친 것 
			int card1 = card.poll(); //가장 작은 두 묶음을 꺼낸다
			int card2 = card.poll();
			
			result += (card1 + card2); //결과에 그 값을 더한다
			card.add(card1 + card2);  //합한 묶음을 다시 큐에 넣는다
		}
		//결과 출력
		System.out.println(result);
	}
}
