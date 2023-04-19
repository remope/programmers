package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] before = new int[n + 1];

        dp[1] = 0;
        before[1] = -1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]){
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }

            if(i % 3 == 0 && dp[i /3] + 1 < dp[i]){
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
        }
        sb.append(dp[n]).append('\n');

        int index = n;
        while(index != -1){
            sb.append(index).append(" ");
            index = before[index];
        }

        System.out.println(sb);
    }
}
