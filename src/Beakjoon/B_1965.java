package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1965 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] box = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(box[j] < box[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
