package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];
        int[] dp = new int[n];
        dp[0] = 1;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(ary[j] < ary[i] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i: dp){
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
