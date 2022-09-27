package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_다음순열_10972 {

	static int N,index=0;
	static int[] current, tgt;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //N입력받기
		
		current = new int[N+1];  //현재 순열  
		check = new boolean[N+1];  //사용한 숫자 체크하기위한 배열
		tgt = new int[N+1];  //현재 순열 다음 순열 (결과)
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			current[i] = Integer.parseInt(st.nextToken());  //현재 순열 입력받기
		}
		
		//순열을 뒤에서 부터 오름차순인 곳까지 그 곳을 index로 받기 -> index자리부터 수정하면됨
		for (int i = N; i > 1; i--) {
			if(current[i] > current[i-1]) {
				index = i-1;
				break;
			}
		}
		//전부 오름차순이면 index는 초기값인 0 
		
		//index전까지는 그대로니까 tgt배열에 담고, 사용한 숫자는 check해준다.
		for (int i = 1; i < index; i++) {
			check[current[i]] = true;
			tgt[i]= current[i];
		}
		
		//index 자리에 숫자 정하기 (currrent[index] 보다 큰 수 중에 사용가능한 가장 작은 수)
		for (int i = current[index]+1; i <= N; i++) {
			if(!check[i]) {  //사용가능하면 index 자리에 수를 넣고, break
				tgt[index] = i;
				check[i] = true;
				break;
			}
		} 

		//index뒤 부터는 사용가능한 수를 오름차순으로 나열하면된다.
		for (int i = index+1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(check[j]) continue;
				else if(!check[j]) {  //사용가능한 수 tgt에 담고 다음 tgt수 결정하러 가기
					tgt[i] = j;
					check[j] = true;
					break;
				}
			}
		}
		
		//index가 0이면 더이상 다음 나열이 없기 때문에 -1 출력
		if(index==0) System.out.println(-1);
		else {  
			for (int i = 1; i <= N; i++) {
				System.out.print(tgt[i] + " ");  //결과 출력
			}
		}
	}
}


 
 
		 





