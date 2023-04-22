package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12865 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] item = new int[n + 1][2];   //itme[n][0] == n번째 물품의 무게, item[n][1] == n번째 물품의 가치
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= k; j++){
                if(j >= item[i][0]) {
                    dp[i][j] = Math.max(dp[i - 1][j], item[i][1] + dp[i - 1][j - item[i][0]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
