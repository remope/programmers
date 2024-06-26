package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int index = i;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[index - 1];
                index--;
            }
        }

        System.out.println(dp[n]);
    }
}
