package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2579_1 {
    public static int n;
    public static int[] stairs;
    public static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stairs = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp());

    }

    public static int dp() {
        if(n == 1) {
            return stairs[1];
        } else if(n == 2) {
            return stairs[1] + stairs[2];
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        for(int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        return dp[n];
    }
}
