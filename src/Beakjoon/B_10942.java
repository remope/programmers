package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10942 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] check = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            check[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            if (ary[i] == ary[i + 1]) {
                check[i][i + 1] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; i + j <= n; j++) {
                if(check[j + 1][j + i - 1] && ary[j] == ary[j + i])
                    check[j][j+i] = true;
            }
        }

        StringBuffer sb = new StringBuffer();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(check[start][end] ? 1:0).append('\n');
        }
        System.out.println(sb);

    }


}
