package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11724 {
    public static int N;
    public static int M;
    public static int[][] graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if(graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
