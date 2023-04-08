package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1932 {
    static int n;
    static int[][] ary;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());

        ary = new int[n][];

        for(int i = 0; i < n; i++){
            ary[i] = new int[i + 1];
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <= i; j++){
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dp());
    }

    public static int dp(){ //top-down
        if(n == 1){
            return ary[0][0];
        }else if(n == 2){
            return Math.max(ary[0][0] + ary[1][0], ary[0][0] + ary[1][1]);
        }

        ary[1][0] += ary[0][0];
        ary[1][1] += ary[0][0];

        for(int i = 2; i < n; i++){
            for (int j = 0; j <= i; j++) {
                if(j == 0){
                    ary[i][j] += ary[i - 1][j];
                }else if(j == i){
                    ary[i][j] += ary[i - 1][j - 1];
                }else{
                    ary[i][j] += Math.max(ary[i - 1][j - 1], ary[i - 1][j]);
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(ary[n - 1][i], max);
        }
        return max;
    }
}
