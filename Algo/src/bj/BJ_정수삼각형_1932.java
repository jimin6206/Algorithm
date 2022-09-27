package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_정수삼각형_1932 {
	
	static int N, max_value=0;
	static int[][] tree, result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //삼각형의 크기 입력받기
		tree = new int[N][N];  //input 삼각형
		result = new int[N][N];  //최대합을 저장할 배열
		
		//삼각형 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result[0][0] = tree[0][0];  //꼭대기는 무조건 고정
		
		for (int i = 1; i < N; i++) { 
			for (int j = 0; j <= i; j++) {//NxN배열인데 삼각형이니까 반만 사용
				if(j==0) result[i][j] = result[i-1][j]+ tree[i][j];  //가장 왼쪽 은 무조건 위의 값을 받아와서 자신의 값 더함.
				else if(j==i) result[i][j] = result[i-1][j-1] + tree[i][j]; //가장 오른쪽은 왼쪽위의 값을 받아와서 자신의 값과 더함
				else {
					result[i][j] = Math.max(result[i-1][j-1] + tree[i][j], result[i-1][j]+ tree[i][j]);
					//중간에 있는 값들은 자신의 부모들중 더 큰 값을 골라서 자신의 값을 더한다.
				}				
			}
		}
		
		//마지막 N-1번째 배열에 있는 수 중 가장 큰 값
		for (int i = 0; i < N; i++) {
			max_value = Math.max(max_value, result[N-1][i]);
		}
		
		System.out.println(max_value);  //결과 출
	}
}
