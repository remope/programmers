package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1245 {
    public static int n, m;
    public static int min = Integer.MAX_VALUE;
    public static int answer = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] < min) min = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                bfs(i, j, map[i][j]);
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int x, int y, int height){
        Queue<int[]> queue = new LinkedList<>();
        boolean isTop = true;
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = poll[0] + dx[i];
                int newY = poll[1] + dy[i];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m){
                    continue;
                }
                if(map[newX][newY] > height){
                    isTop = false;
                }else if(!visited[newX][newY] && map[newX][newY] == height){
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        if(isTop && height > min) {
            answer++;
        }
    }
}
