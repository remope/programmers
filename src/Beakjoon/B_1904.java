package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        dp[1] = 1;
        if(n > 1){
            dp[2] = 2;
        }
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }
        System.out.println(dp[n]);
    }
}
