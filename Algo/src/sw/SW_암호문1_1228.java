package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_암호문1_1228 {

	static int T = 10, N, I,x,y,s;
	static LinkedList<String> list = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//10개의 테케
		for (int t = 1; t <= T; t++) {
			list.clear();
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//N개의 수 입력받기
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < I; i++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < y; j++) {

					list.add(x+j,st.nextToken());
				}
				
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+ " ");
			}
			System.out.println();
			
		}
	}

}
