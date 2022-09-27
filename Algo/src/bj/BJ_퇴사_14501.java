package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_퇴사_14501 {
	
	 static int [] t, p, d;
	 static int n, result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        t = new int[n + 2];
        p = new int[n + 2];
        d = new int[n + 2];

        for(int i=1; i<=n; i++){
            String[] s = br.readLine().split(" ");
            t[i] = Integer.parseInt(s[0]);
            p[i] = Integer.parseInt(s[1]);
        }

        for(int i=1; i<=n + 1; i++){
            for(int j=1; j<i; j++){
                d[i] = max(d[i], d[j]);

                if(j + t[j] == i){
                    d[i] = max(d[i], d[j] + p[j]);
                }
            }

            result = max(result, d[i]);
        }

        System.out.println(result);
	}
	
	public static int max(int a, int b){
        return a > b ? a : b;
    }
}
