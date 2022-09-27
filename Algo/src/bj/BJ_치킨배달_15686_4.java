package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_치킨배달_15686_4 {

	static int N, M, min;
	static List<int[]> house, src; // 0001111 => 0010110 => 1111000
	
	// src = {1, 2, 3, 4, 5, …, 7}
	// tgt {} M개 완성 -> house 거리 계산
	
	static int[] index; // index는 src와 길이가 같다.
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		house = new ArrayList<int[]>(); // 집들
		src = new ArrayList<int[]>(); // 치킨집 전체 (src)
//		tgt = new ArrayList<int[]>(); // M 개의 치킨 집 (tgt) (조합의 결과)
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if( a == 1 ) house.add(new int[] {i, j});
				else if( a == 2 ) src.add(new int[] {i, j});
			}
		}
		
		index = new int[src.size()];
		for (int i = 0; i < M; i++) { // 뒤에 M 개의 1을 채운다. <= 가장 작은 수를 표현
			index[ (index.length - i) - 1] = 1;
		}
		
		min = Integer.MAX_VALUE;
		
		while(true) {
			// complete code
			int sum = 0; // 치킨 거리의 총합
			
			for (int i = 0; i < house.size(); i++) { // 각각의 집에 대해서 최소값
				int dist = Integer.MAX_VALUE;		// 치킨 거리		
				for (int j = 0; j < index.length; j++) { // 00100110
					
					if(index[j] == 1) {
						// i 집 - 치킨집 거리
						dist = Math.min(
								dist,
								Math.abs( house.get(i)[0] - src.get(j)[0]) + Math.abs( house.get(i)[1] - src.get(j)[1])
						);
					}
				}
				sum += dist;
			}
			
			// sum : 현재 조합( 치킨 집 ) 에서 치킨 거리의 합
			min = Math.min(min, sum);
			

			if( !np()) break;
		}
		System.out.println(min);
	}
	
	static boolean np() { 
		int[] src = index;
		int i = src.length - 1;
		while( i > 0 && src[i-1] >= src[i] ) --i;
		
		if( i == 0 ) return false; // 더 이상의 큰 수는 없다.
		
		int j = src.length - 1;
		while( src[i-1] >= src[j] ) --j;
		swap( src, i-1, j );
		
		int k = src.length - 1;
		while( i < k) {
			swap( src, i++, k--);
		}
		
		return true;
	}
	
	static void swap( int num[], int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;		
	}
}