package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class JO_회전초밥_2577 {
	
	static int N,d,k,c,max=0;
	static int[] sushi;
	static HashMap<Integer,Integer> map = new HashMap<>();  //HashMap에  <초밥, 초밥개수> 로 데이터 저장

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력값
		N = Integer.parseInt(st.nextToken());  //접시의 수
		d = Integer.parseInt(st.nextToken());  //초밥의 가짓수
		k = Integer.parseInt(st.nextToken());  //연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken());  //쿠폰 번호
		
		//회전초밥을 sushi배열에  저장할것
		sushi = new int[N];  
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		//쿠폰초밥을 먼저 map에 넣기 
		map.put(c, map.getOrDefault(c, 0)+1);
		
		//0번접시부터 k개 만큼 map에 담아놓기  -> 중복되면 sushi[i]키값의 value가 1증가할것
		for (int i = 0; i < k; i++) {
			map.put(sushi[i], map.getOrDefault(sushi[i], 0)+1);
		}
		//키값의 개수=초밥의 개수
		max = map.size();  //0번부터 k개까지 다른 초밥의 수를 세어 max값에 저장

		//1번 접시부터는 현재 map에 전에 접시를 빼고 다음 접시를 추가함 ( map에는 k개의 초밥이 유지된다)
		for (int i = 1; i < N; i++) {
			//ex) 초기 map에는 0,1,2,3 접시가 들어가 있고 
			//    i가 1일때는 1,2,3,4 번 접시를 먹어야하므로 map에 0번을 빼고, 4번을 넣는다. => 이작업을 반복
			
			int end = i+k-1;  //추가할 접시의 인덱스  
			if(end>=N) end= end-N; //N을 넘기면 다시 0번부터 돌게 처리
			map.put(sushi[i-1], map.getOrDefault(sushi[i-1], 0)-1); //i-1번째 접시 를 뺌 (map 에서 value값을 -1)
			if(map.get(sushi[i-1])== 0) {  //이때 제거된 초밥의 개수가 0이라면 map에서 아예 키값을 삭제
				map.remove(sushi[i-1]);
			}
			map.put(sushi[end], map.getOrDefault(sushi[end], 0)+1);  //다음초밥 추가

			max = Math.max(max, map.size());// 키값의 개수를 비교해 가장 큰 값을 max에 저장
			//여기서 키값의 개수는 먹은 초밥의 개수
		}
		
		System.out.println(max); //결과 출력
	}
}
