package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class B_11055 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i];
            for (int j = 1; j < i; j++) {
                if(cost[i] > cost[j]){
                    dp[i] = Math.max(dp[j] + cost[i], dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if(dp[i] > max){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
