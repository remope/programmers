package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16928 {
    public static int n, m, result = 0;
    public static boolean[] visited = new boolean[101];
    public static int[] count = new int[101];
    public static Map<Integer, Integer> ladAndSnake = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladAndSnake.put(x, y);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            ladAndSnake.put(u, v);
        }
        bfs();
        System.out.println(result);

    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()){
            result++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                for (int j = 1; j < 7; j++) {
                    int nx = now + j;
                    if(nx == 100){
                        return;
                    }
                    if(nx > 100 || visited[nx]) continue;

                    visited[nx] = true;

                    if(ladAndSnake.containsKey(nx)){
                        nx = ladAndSnake.get(nx);
                    }
                    q.add(nx);

                }
            }
        }

    }
}
