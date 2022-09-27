package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_좌표압축_18870 {
	
	static class X implements Comparable<X>{
		int index; //초기인덱스
		int value;
		
		public X(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(X o) {		
			return this.value - o.value;  //value 를 기준으로 정렬
		}

	}
	
	public static void main(String[] args) throws Exception{
		
		PriorityQueue<X> pqueue = new PriorityQueue<>(); //우선순위 큐
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pqueue.add(new X(i, Integer.parseInt(st.nextToken()))); //큐에 현재 순서랑 value랑 함께 넣기
		}
		
		int order = -1;
		int pre=Integer.MAX_VALUE;
		
		while(!pqueue.isEmpty()) {  //빼면서 정렬
			
			X x = pqueue.poll();
			
			if(x.value == pre) {
				result[x.index] = order; //이전이랑 같으면 order을 그대로
			}else {
				result[x.index] = ++order; //다르면 order을 +1
			}
			pre = x.value;  //이전값 저장
		}
		
		//stringBuilder 안쓰면 시간초과
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");  //결과 출력
		}
		
		System.out.println(sb);
	}
}
