package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2606 {
    static int[][] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int computers = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        for(int i = 0; i < computers; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        visit = new boolean[n + 1];
        bfs(1);

    }
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visit[start] = true;

        queue.offer(start);
        int cnt = 0;

        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int i = 1; i < graph.length; i++){
                if(graph[x][i] == 1 && visit[i] != true){
                    queue.offer(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
