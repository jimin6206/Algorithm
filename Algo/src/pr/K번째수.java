package pr;

import java.util.Arrays;

public class K번째수 {

	public static void main(String[] args) {
		int[] a = {1,5,2,6,3,7,4};
		int[][] c = {{2,5,3},{4,4,1},{1,7,3}};
		int[] r = new int[3];
		
		r = solution(a,c);
		
		for (int i : r) {
			System.out.println(i);
		}

	}
	
	static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; // answer을 commands크기만큼 선언
        
        //commands크기만큼 반복
        for (int i = 0; i < commands.length; i++) {
			int[] cut = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); //i부터 j까지 자르기
        	Arrays.sort(cut);  //자른 배열을 오름차순으로 정렬     	      	
        	answer[i] = cut[commands[i][2]-1];	//정렬후 k번째 수를 answer배열에 담기
		}
            
        return answer; //결과 
    }

}
