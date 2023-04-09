package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1912 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int[] ary = new int[n + 1];
        int[] dp = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n ; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = ary[1];

        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(ary[i], dp[i - 1] + ary[i]);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        System.out.println(max);

    }
}
