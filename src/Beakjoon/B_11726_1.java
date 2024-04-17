package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11726_1 {
    public static int[] tile;
    public static int[] dp;
    public static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tile = new int[n + 1];
        dp = new int[n + 1];

        System.out.println(dp());
    }

    public static int dp() {
        if(n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        return dp[n];

    }
}
