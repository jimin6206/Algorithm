package pr;

import java.util.HashSet;

public class 포켓몬 {

	public static void main(String[] args) {
		
		//테스트 케이스
		int[] nums = {3,3,3,2,2,2};
		
		int result;
		
		result = solution(nums);
		System.out.println(result);

	}
	
	static public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hashset = new HashSet<>();
        int N = nums.length;
        int select_num = N/2;
        
        //HashSet 에는 중복이 포함되지않기 때문에 종류가 몇가지인지 알수있다.
        for (int num : nums) {
			hashset.add(num);
		}
        
        //포켓몬종류가 뽑아야할 포켓몬 수보다 많으면 뽑아야할 포켓몬 수를 다 다른 종류로 뽑을 수 있으므로 N/2 개
        if(hashset.size() >= select_num) {
        	answer = select_num;
        }else {  //포켓몬종류가 뽑아야할 포켓몬 수보다 작으면 아무리 많이 뽑아도 포켓몬의 종류수는 커지지않을 것
        	answer = hashset.size();
        }
        
        return answer;
    }

}
