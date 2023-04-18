package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_24479 {
    static int[][] graph;
    static int[] visits;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visits = new int[n + 1];
        //2차원 배열 -> 메모리 초과
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(start);

        for(int i = 1; i <= n; i++){
            sb.append(visits[i]).append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int visit){
        visits[visit] = count++;
        for(int i = 1; i < graph[0].length; i++){
            if(graph[visit][i] == 1 && visits[i] == 0){
                dfs(i);
            }
        }
    }
}
