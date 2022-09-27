import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kakao_1 {

	public static void main(String[] args) {
		
		int[] result;
		String today = "2022.05.19"; 
		String[] terms = {"A 6", "B 12","C 3"};
		String[] privacies = {"2021.05.02 A","2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		
		result = solution(today, terms, privacies);
		
		for (int i : result) {
			System.out.println(i+ " ");
		}

	}
	
	static public int[] solution(String today, String[] terms, String[] privacies) {
		int[] answer = {};
		
		StringTokenizer st;
		HashMap<String,Integer> hashmap = new HashMap<>();
		String[] end = new String[privacies.length];
		ArrayList<Integer> answer_list = new ArrayList<>();
		
		//약관을 Hashmap으로 구분
		for (String term : terms) {
			st = new StringTokenizer(term);
			String type = st.nextToken();
			int period = Integer.parseInt(st.nextToken());
			
			hashmap.put(type, period);
		}
		
		for (int i = 0; i < privacies.length; i++) {
			st = new StringTokenizer(privacies[i]);
			String date = st.nextToken();
			String term = st.nextToken();
			
			//파기해야할 날짜를 end배열에 담기
			end[i] = expiration(date, hashmap.get(term));
		}
		
		//end배열에서 today보다 같거나 크면 answer에 추가
		for (int i = 0; i < end.length; i++) {
			if(compare_date(today, end[i])) {
				answer_list.add(i+1);
			}
		}
		
		answer = new int[answer_list.size()];
		for (int i = 0; i < answer_list.size(); i++) {
			answer[i] = answer_list.get(i);
		}
		
		return answer;
	}
	
	//파기해야할 날짜 계산
	static public String expiration(String date, int plus_month) {
		
		StringTokenizer st = new StringTokenizer(date,".");
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		if(month + plus_month <= 12) {
			month += plus_month;
		}else {
			year += (month+plus_month) / 12;
			month = (month+plus_month) % 12;
		}
		
		return Integer.toString(year)+"."+Integer.toString(month)+"."+Integer.toString(day);
	}
	
	static public boolean compare_date(String today, String date) {
		
		StringTokenizer st = new StringTokenizer(today,".");
		int today_year = Integer.parseInt(st.nextToken());
		int today_month = Integer.parseInt(st.nextToken());
		int today_day = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(date,".");
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		if(today_year > year) {
			return true;
		}else if(today_year == year) {
			//달 비교
			if(today_month > month) {
				return true;
			}else if(today_month == month) {
				if(today_day >= day) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	

	}
		
	

}
