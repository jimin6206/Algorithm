package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_냉장고_1828 {
	static int N, ref, cnt;  //N:화학물질 수, ref:냉장고 온도, cnt:냉장고 수
	static C[] c;  //화학물질들을 담은 배열

	static class C implements Comparable<C>{
		int x;  //최저온도
		int y;  //최고온도
		
		public C(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(C o) {  //최고온도 순으로 정렬
			return this.y != o.y ? this.y - o.y : this.x - o.x;
		}	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //화학물질 수 입력받기
		c = new C[N];  //화학물질들을 담을 배열을 N크기만큼 할당
		
		//배열에 화학물질들 담기(최저온도, 최고온도)
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c[i] = new C(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
		}
		
		//최고온도순으로 정렬(오름차순)
		Arrays.sort(c);
		
		ref = c[0].y;  //냉장고온도를 화학물질들 중 최고온도가 가장 낮은 온도로 설정
		cnt = 1;  //냉장고 수 초기값: 1 (최소 1대)
		for (int i = 1; i < N; i++) {  //0번째 물질의 온도 설정했으니 1번째 물질부터 N-1번째까지 반복
			if(ref < c[i].x) {  //냉장고의 온도가 i번째 물질의 최저온도보다 크다면
				cnt++;   //냉장고를 하나 더 추가
				ref = c[i].y; //새로운 냉장고 온도 설정 ( i번째 최고온도)
			}
		}
		
		//결과 값 출력
		System.out.println(cnt);
		
	}

}
