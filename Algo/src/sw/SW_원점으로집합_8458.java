package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_원점으로집합_8458 {

	static int T, N, max;  //max는 거리가 가장 먼 수를 저장
	static int[] point;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			point = new int[N];
			
			//먼저 맨 앞의 점을 계산
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[0] = Math.abs(x) + Math.abs(y);
			
			max = point[0];
			//모든 수가 똑같이 홀수이거나, 작수이면 원점으로 간다
			//홀수, 짝수가 섞여있다. => 원점으로 모두 이동할 수 없다.
			boolean stop = false;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				point[i] = Math.abs(x) + Math.abs(y);
				
				max = Math.max(max, point[i]);
				
				if(point[i]%2 != point[i-1]%2) stop = true;
			}
			
			if(stop) {
				System.out.println("#" + t + " -1" );
				continue;
			}
			int sum = 0; //움직이는 누적 거리
			int cnt = 0; //움직이는 횟수 1->2->3
			
			while(true) {
				if( sum == max || (sum > max && (sum - max)%2 == 0)) break;
				sum += ++cnt;
				
			}
			
			System.out.println("#" + t+ " " + cnt);
		}
	}
}
