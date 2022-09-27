import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class kakao_5 {

	
	public static void main(String[] args) {
		String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", 
				"UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", 
				"MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
			
		String[] result = solution(commands);
		for (String string : result) {
			System.out.println(string);
		}
	}
	
	//좌표
	static class Node{
		int y; //r
		int x; //c
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
			
	}
	static public String[] solution(String[] commands) {
        String[] answer = {};
        String[][] map = new String[51][51];
        StringTokenizer st;
        ArrayList<HashSet<Node>> list= new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        
        for (String command : commands) {
			st = new StringTokenizer(command);
			
			switch(st.nextToken()) {
			
			case "UPDATE" :
				//UPDATE r c value 의경우
				int update_index = -1;
				boolean check = false;
				
				if(st.countTokens() == 3) {
					int r = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					String update_value = st.nextToken();
					
					for (int i = 0; i < list.size(); i++) {
						
						for (Node node : list.get(i)) {
							if(node.y == r && node.x == c) {
								update_index=i;
								check = true;
								break;
							}
						}
						if(check) {
							break;
						}
					}
					
					if(check) {
						for (Node node : list.get(update_index)) {
							map[node.y][node.x] = update_value;
						}
					}else {
						map[r][c] = update_value;
					}
					
					
				}else { //UPDATE value1 value2 의 경우
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					
					for (int i = 0; i < 50; i++) {
						for (int j = 0; j < 50; j++) {
							if(map[i][j] == value1) {
								map[i][j] = value2;
							}
						}
					}
				}
						
				break;
			case "MERGE" :
				int r1 = Integer.parseInt(st.nextToken());
				int c1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				
				boolean check_1 = false; // (r1,c1)이 이미 병합된 셀에 포함일 경우
				boolean check_2 = false; // (r2,c2)이 이미 병합된 셀에 포함일 경우
				
				int remove_index= -1;
				int remove_index2 = -1;
				
				//새로운 hashset 만들기 (병합되면 무조건 새로 생성) -> 이전의 병합되어있는 hashset 삭제
				HashSet<Node> new_hashset = new HashSet<>();
				
				//리스트를 돌면서  (r1, c1), (r2, c2) 가 있는 지 확인
				//있으면 그 안에 있는 node 들을 모두 새로운 node로 옮김
				//없으면 (r1,c1) 또는 (r2, c2) 만 추가
				
				
				//리스트 삭제부분 다시보기

//				for (HashSet<Node> hashset : list) { //list는 병합된 hashset들이 저장되어있음
//						
//					for (Node node : hashset) {
//						if(node.y == r1 && node.x == c1) {
//							new_hashset.addAll(hashset);
//							check_1 = true;
//							list.remove(hashset);
//							break;
//						}
//						if(node.y == r2 && node.x == c2) {
//							new_hashset.addAll(hashset);
//							check_2 = true;
//							list.remove(hashset);
//							break;
//						}
//					}
//				}
				
				for (int i = 0; i < list.size(); i++) {
					
					for (Node node : list.get(i)) {
						if(!check_1 && node.y == r1 && node.x == c1) {
							new_hashset.addAll(list.get(i));
							check_1 = true;
							remove_index = i;
							break;
						}
						if(!check_2 && node.y == r2 && node.x == c2) {
							new_hashset.addAll(list.get(i));
							check_2 = true;
							remove_index2 = i;
							break;
						}
					}
				}
				
				
				if(!check_1) {
					new_hashset.add(new Node(r1, c1));
				}
				if(!check_2) {
					new_hashset.add(new Node(r2, c2));
				}
				
				list.add(new_hashset);
				
				if(map[r1][c1]=="") {
					for (Node node : new_hashset) {
						map[node.y][node.x] = map[r2][c2];
					}
				}else {
					for (Node node : new_hashset) {
						map[node.y][node.x] = map[r1][c1];
					}
				}
				
				//원래 있던 hashset 삭제
				if(remove_index != -1) {
					list.remove(remove_index);
				}
				if(remove_index2 != -1) {
					list.remove(remove_index2);
				}
				
				break;
			case "UNMERGE" :
				
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				String value = "";
				boolean update_check = false;
				
				for (HashSet<Node> hashset : list) { //list는 병합된 hashset들이 저장되어있음
					
					for (Node node : hashset) {
						if(node.y == r && node.x == c) {
							value = map[node.y][node.x]; //r c 에 값 먼저 세팅
							update_check = true;
							break;
						}
					}
					
					if(update_check) {
						for (Node node : hashset) {
							map[node.y][node.x] = "";
						}
						break;
					}
				}
				map[r][c] = value;
				
				break;
			case "PRINT" :
				int r_1 = Integer.parseInt(st.nextToken());
				int c_1 = Integer.parseInt(st.nextToken());
				
				if(map[r_1][c_1]=="") {
					result.add("EMPTY");
				}else {
					result.add(map[r_1][c_1]);
				}
				
				break;
			}
		}
        
        answer = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
        
        return answer;
    }

}
