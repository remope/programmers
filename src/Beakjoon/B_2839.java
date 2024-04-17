package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n < 5) {
            if(n == 3) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
            return;
        }

        int[] dp = new int[n + 1];
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            int dp3 = dp[i - 3] == 0 ? Integer.MAX_VALUE : dp[i - 3];
            int dp5 = dp[i - 5] == 0 ? Integer.MAX_VALUE : dp[i - 5];
            if(dp3 != Integer.MAX_VALUE || dp5 != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp3, dp5) + 1;
            }
        }

        System.out.println(dp[n] != 0 ? dp[n] : -1);
    }
}
