package pr;

public class 타겟넘버 {
	
	static int count = 0;  //최종 값
	
	public static void main(String[] args) {
		int[] n = {4,1,2,1};
		int t = 4;
		int ans=0;
		
		ans = solution(n,t);
		System.out.println(ans);
	}
	
	static int solution(int[] numbers, int target) {
    
        dfs(numbers, 0 ,target);  //dfs 함수 호출
        
        return count;
    }
	
	static void dfs(int[] numbers, int i, int target) {
		
		if(i < numbers.length) {   //인덱스가 배열수보다 작으면 아직 다 안 더한 것
			//+
			dfs(numbers,i+1,target);  //+할때는 그냥 배열 그대로 넘겨주고 다음인덱스 i+1로
			
			//-
			numbers[i] *= -1;   //-할때는 배열에서 해당인덱스를 -로 바꿔줌
			dfs(numbers,i+1, target);  //바꾼 배열과 함께, 다음 인덱스로
		}
		else {    //배열의 인덱스를 모두 검사했음
			int sum=0;
			for (int j = 0; j < numbers.length; j++) {
				sum += numbers[j];   //최종배열이 넘어왔을테니, 배열의 모든 수를 더한다.
			}
			if(sum == target) {   //모두 더한 값이 target가 같으면 count+1
				count++;
				return;  //종료
			}
		}
	}
}
