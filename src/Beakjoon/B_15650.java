package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15650 {
    public static StringBuffer sb = new StringBuffer();
    public static int[] ary;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ary = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int current, int depth){
        if (depth == m) {
            for (int val : ary) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = current; i <= n; i++) {
            ary[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
