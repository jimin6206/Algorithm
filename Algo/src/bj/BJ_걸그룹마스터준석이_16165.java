package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_걸그룹마스터준석이_16165 {

	static int N, M;
	static HashMap<String, String> map = new HashMap<>();  //HashMap으로 <멤버, 그룹> 매핑
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //걸그룹의 수
		M = Integer.parseInt(st.nextToken());  //문제 수
		
		//걸그룹 입력받기
		for (int i = 0; i < N; i++) {
			String group = br.readLine();
			int num = Integer.parseInt(br.readLine()); //멤버들 수
			
			for (int j = 0; j < num; j++) { //멤버만큼 반복
				String name = br.readLine();
				map.put(name, group);  //map에 <멤버이름, 그룹> 으로 저장
			}
		}
		
		//문제
		for (int i = 0; i < M; i++) {
			String question = br.readLine();  //멤버이름 or 그룹이름
			int question_num = Integer.parseInt(br.readLine()); //문제 넘버
			//팀의 이름 -> 멤버들 출력
			if(question_num == 0 ) {
				ArrayList<String> list = new ArrayList<>(); //리스트에 멤버들을 담을거임
				for (String string : map.keySet()) { //map의 키값들을 검사하며
					if(question.equals(map.get(string))){  //해당 키의 그룹이름이 question이랑 같으면
						list.add(string);  //list에 해당 멤버 넣기
					}
				}
				
				list.sort(Comparator.naturalOrder());  //list 정렬(오름차순)
				
				for (String s : list) {
					System.out.println(s); //멤버들 출력
				}
				
			}else if(question_num==1) {  //멤버 이름 -> 그룹 출력
				System.out.println(map.get(question));  //map의 키값을 이용해서 바로 그룹출력
			}
		}
		
	}
}
