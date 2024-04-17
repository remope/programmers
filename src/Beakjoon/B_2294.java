package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_2294 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 999999);
        dp[0] = 0;

        for(Integer coin: coins) {
            for (int i = coin; i <= k; i++) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if(dp[k] >= 999999) {
            dp[k] = -1;
        }

        System.out.println(dp[k]);
    }
}
