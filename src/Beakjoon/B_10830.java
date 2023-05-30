package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10830 {
    public static int[][] defaultMatrix;
    public final static int MOD = 1000;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        defaultMatrix = a;
        int[][] result = matPow(b);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] matPow(long pow){
        if(pow == 1){
            return defaultMatrix;
        }
        int[][] temp = matPow(pow/2);
        int[][] temp2 = matMul(temp, temp);
        if(pow % 2 == 0){
            return temp2;
        }else{
            return matMul(temp2, defaultMatrix);
        }
    }

    public static int[][] matMul(int[][] a, int[][] b){
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k]*b[k][j];
                }
                result[i][j] %= MOD;
            }
        }

        return result;
    }
}
