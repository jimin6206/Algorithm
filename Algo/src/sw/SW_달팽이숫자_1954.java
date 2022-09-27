package sw;

import java.util.Scanner;

public class SW_달팽이숫자_1954 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//테케수 입력받기
		int T = sc.nextInt();
		sc.nextLine();
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) { 
			int N = sc.nextInt();    //N입력받기
			int [][]result = new int[N][N];   //N*N 배열 만들기
			int i=0;      //i,j는 배열의 인덱스
			int j=-1;
			int num=0;    // 각 배열에 저장될 숫자 (1~N)
			int a = N;    // a는 매턴마다 움직이는 횟수 (오른쪽으로 움직이는횟수, 아래로 움직이는 횟수 ...)

			while(a > 0) { //a로 움직이는 횟수를 조절해며 오른쪽, 아래, 왼쪽, 위 순으로 반복
				//오른쪽으로 
				for (int k = 0; k < a; k++) {
					result[i][++j] = ++num;   
				} 
				a--;   
				//아래로
				for (int k = 0; k < a; k++) {
					result[++i][j] = ++num;
				}
				//왼쪽으로
				for (int k = 0; k < a; k++) {
					result[i][--j] = ++num;
				}
				
				a--;		
				//위로
				for (int k = 0; k < a; k++) {
					result[--i][j] = ++num;
				}			
			}
			
			//결과 출력
			System.out.println("#" + t);
			for (int k = 0; k < N; k++) {
				for (int l = 0; l< N; l++) {
					System.out.print(result[k][l] +" ");
				}
				System.out.println();
			}
		}
		sc.close();

	}
}
