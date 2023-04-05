package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1260 {
    static int n, m, start;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visit;
    static int[][] ary;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        ary = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ary[x][y] = ary[y][x] = 1;
        }

        dfs(start);
        sb.append("\n");
        visit = new boolean[n + 1];
        bfs(start);

        System.out.println(sb);
    }
    public static void dfs(int start){
        visit[start] = true;
        sb.append(start).append(" ");
        for(int i = 1; i <= n; i++){
            if(ary[start][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        queue.add(start);
        visit[start] = true;
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            sb.append(now).append(" ");

            for(int i = 1; i <= n; i++){
                if(ary[now][i] == 1 && visit[i] == false){
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
