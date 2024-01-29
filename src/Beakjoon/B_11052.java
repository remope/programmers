package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11052 {
    public static int N;
    public static int[] card;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < N + 1; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[1] = card[1];

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
