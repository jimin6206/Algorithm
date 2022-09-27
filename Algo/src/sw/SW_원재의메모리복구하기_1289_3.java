package sw;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW_원재의메모리복구하기_1289_3 {
	
	static int T;
	static char[] input;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());


		for (int t = 1; t <= T; t++) {
			//테케 별 입력 - 풀이 - 출력
			int count = 0;
			char current = '0';
			
			// 입력 문자열 처리 - 입력 자료구조(배열.....)
			input = br.readLine().toCharArray();
			
			int cnt = input.length;
			
			for (int i = 0; i < cnt; i++) {
				if(current != input[i]) {
					count++;
					current = input[i];
				}
			}

			System.out.println("#" + t + " " + count);
			
		}
	}
}
