package pr;

import java.util.HashMap;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String result = solution(participant,completion);
		System.out.println(result);

	}
	
	static String solution(String[] participant, String[] completion) {
        String answer = "aa";
        HashMap<String,Integer> map = new HashMap<>();
        
        for (String par : participant) {
			map.put(par, map.getOrDefault(par, 0)+ 1);
		}
        
        for (String com : completion) {
        	if(map.containsKey(com)) {
        		map.replace(com, map.get(com)-1);
        	}
		}
        
        
        for (String s : map.keySet()) {
			if(map.get(s)==1) answer = s;
		}
    
        return answer;
    }
}
