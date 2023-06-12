package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11404 {
    public static int[][] graph;
    public static int[][] result;
    public static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = 987654321;
                if(i == j){
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == 987654321){
                    graph[i][j] = 0;
                }
                sb.append(graph[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
