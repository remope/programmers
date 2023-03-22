package Beakjoon;

import java.util.Scanner;

public class B_13301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n + 1];

        dp[0] = 4;
        dp[1] = 6;

        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[n - 1]);

    }

}
