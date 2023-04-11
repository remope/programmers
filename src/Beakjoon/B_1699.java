package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];


        dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = i;  // 최초 1의 제곱의 합으로만 초기화
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                // i에서 가장 가까운 제곱수를 뺀 값의 + 1
            }
        }
        System.out.println(dp[n]);
        /*
        처음에 생각했던 코드
        if(n > 1){
            dp[2] = 2;
        }
        if(n > 2){
            dp[3] = 3;
        }
        for(int i = 4; i <= n; i++){
            int sqrt = (int) Math.sqrt(i);
            dp[i] = 1 + dp[i - sqrt*sqrt];
        }

        System.out.println(dp[n]);
        */

    }
}
