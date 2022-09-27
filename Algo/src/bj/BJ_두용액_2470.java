package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_두용액_2470 {

	static int N, min_gap=Integer.MAX_VALUE, left, right, sum=0, gap, result_1, result_2;
	static int[] sol; //용액들을 담을 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //용액의 수
		sol = new int[N]; //배열을 N만큼 할당
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sol[i] = Integer.parseInt(st.nextToken()); //배열에 용액 담기
		}
		
		Arrays.sort(sol); //용액들을 크기순으로 정렬
		
		//양쪽에서 인덱스를 하나씩 옮겨가며 더할것
		left = 0; //left는 가장 작은 값
		right= N-1;  //right는 가장 큰 값
		
		while(left < right) { //left는 오른족으로 가고, right는 왼쪽으로 가면서 두개가 교차하면 그만
			sum = sol[left] + sol[right]; //두 용액의 합을 구하고
			gap = Math.abs(sum);  //절댓값을 씌워서 0에 얼마나 가까운지를 구한다
			
			if(gap < min_gap) { //현재의 gap이 min_gap보다 작으면 업데이트
				min_gap = gap;
				result_1 = sol[left]; //그때의 두 용액 값도 저장
				result_2 = sol[right];
			}
			//더한 값이 양수면 더 작아져야하기때문에 오른쪽 인덱스를 옮김
			if(sum > 0) right--;
			else left++;  //더한 값이 음수면 더 커져야하기때문에 왼쪽 인덱스를 옮김
		}
		//결과 출력
		System.out.println(result_1 + " " + result_2);

	}
}
