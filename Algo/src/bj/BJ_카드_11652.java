package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_카드_11652 {

	static int N, max=0;
	static long result;
	static HashMap<Long, Integer> map = new HashMap<>(); //<카드숫자, 개수> 로 맵핑
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //카드 수 입력받기
		
		for (int i = 0; i < N; i++) {
			long card = Long.parseLong(br.readLine());
				
			map.put(card, map.getOrDefault(card, 0)+1); // card가 존재하면 value+1, 존재하지않으면 1 저장(개수)
		}
		
		//map에 저장되어있는 key 값들 불러오기
		for (long card : map.keySet()) {
			if(map.get(card) > max) { //카드개수가 max보다 크면 업데이트
				max = map.get(card);
				result = card;
			}
			if(map.get(card) == max) { //max랑 같은 경우 더 작은 값을 업데이트
				result = Math.min(result, card);
			}
		}
		//결과출력
		System.out.println(result);
	}
}
