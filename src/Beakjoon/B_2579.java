package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2579 {
    static int[] dp;
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        val = new int[n];
        dp = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            val[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if(n == 1){
            return val[0];
        }else if(n == 2){
            return Math.max(val[0] + val[1], val[1]);
        }else if(n == 3){
            return Math.max(val[0] + val[2], val[1] + val[2]);
        }

        dp[0] = val[0];
        dp[1] = Math.max(val[0] + val[1], val[1]);
        dp[2] = Math.max(val[0] + val[2], val[1] + val[2]);

        for(int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i - 2] + val[i], dp[i - 3] + val[i - 1] + val[i]);
        }
        return dp[n - 1];
    }
}
