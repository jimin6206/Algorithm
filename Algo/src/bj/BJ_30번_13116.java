package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_30번_13116 {

	static int T,A,B, A_p, B_p;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); //테케 수 입력받기
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());  //A와 B 입력받기
			B = Integer.parseInt(st.nextToken());
			
			//A_p : A의 부모 ,  B_p : B의 부모
			A_p = A;
			B_p = B;
			while(A_p != B_p) {  //두 수의 부모를 비교해가며  부모가 같아지면 stop
				if(A_p > B_p) {  //더 큰수를  나누기 2해서 부모를 거슬러 올라감
					A_p = A_p/2;
				}else {
					B_p = B_p/2;
				}
			}
			
			System.out.println(A_p*10);  //결과에 10을 곱하면 정답
		}
	}
}
