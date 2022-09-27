package sw;


import java.util.Scanner;

public class SW_원재의메모리복구하기_1289 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		//테케 입력 처리
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			//테케 별 입력 - 풀이 - 출력
			int count = 0;
			
			// 입력 문자열 처리 - 입력 자료구조(배열.....)
			String input = sc.nextLine();
			int length = input.length();
			int[] arr = new int[length];
			
			for (int i = 0; i <length ; i++) {
				arr[i] = input.charAt(i) - '0';
			}
			
			int current = 0;
			for (int i = 0; i < length; i++) {
				if(current != arr[i]) {
					count++;
					current = arr[i];
				}
			}

			System.out.println("#" + t + " " + count);
			
		}
	}
}
