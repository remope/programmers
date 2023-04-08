package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int[] ary = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ary[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = ary[1];
        if(n > 1){
            dp[2] = ary[1] + ary[2];
        }
        for(int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + ary[i - 1] + ary[i], dp[i - 2] + ary[i]));
        }

        System.out.println(dp[n]);


    }


}
