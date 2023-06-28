package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_14495 {

    public static long[] dp = new long[117];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }

        System.out.print(dp[n]);



    }



}
