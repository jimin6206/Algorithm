package pr;

import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,3,4};
		int[] reserve = {1,3,5};
		
		int result = solution(n,lost, reserve);
		
		System.out.println(result);
		

	}
	
	static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int index_l=0, index_r=0;
        
        //자기가 잃어버리고 자기가 여분이 있는 경우를 제외시켜준다.
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if(lost[i] ==reserve[j]) {  //도난당한 학생 목록과 여벌있는 학생 목록이 둘 다 있으면
					lost[i] = 0;            //학생 번호를 0으로 만들어준다.(학생번호는 1번부터 시작)
					reserve[j] = 0; 
					answer++;   //해당 학생은 체육수업을 들을수 있으므로 answer++
					index_l++;  //0번은 볼 필요가 없으므로 index_l과 index_r을 다음칸으로 
					index_r++;
					break; //찾으면 stop
				}
			}
		}
        
        //두 배열을 오름차순 정렬한다.
        Arrays.sort(lost);
        Arrays.sort(reserve);

        while(true) {
        	
        	//검색 인덱스가 범위를 넘으면 종료
        	if(index_l >= lost.length) break;
        	if(index_r >= reserve.length) break;
        	
        	//현재 잃어버린 학생 번호의 +1,-1 번호가 reserve에 있으면
        	if((reserve[index_r]  == lost[index_l] -1) || (reserve[index_r]  == lost[index_l] +1)) {
        		answer++;   //체육복 빌릴 수 있음 ( 수업참여 학생 +1)
        		index_l++;  //둘 다 다음 인덱스로
            	index_r++; 
            }else { //빌릴 수 없으면
            	if(lost[index_l] < reserve[index_r]) { //두 값을 비교해서 작은값의 인덱스를 증가하며 모두 비교
            		index_l++;
            	}else {
            		index_r++;
            	}
            }
        } 
        
        //결과 출력
        return answer;
    }
}
