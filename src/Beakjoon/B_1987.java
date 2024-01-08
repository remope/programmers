package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_1987 {
    public static int[][] map;
    public static int r, c;
    public static int maxCount;
    public static boolean[] visited = new boolean[26];
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }
        //visited[map[0][0] - 'A'] = true; //처음 풀이
        if(r == 1 && c == 1) {
            System.out.println(1);
            return;
        }
        dfs(0, 0, 0);
        System.out.println(maxCount);

    }
    public static void dfs(int x, int y, int count){
        if(visited[map[x][y]]){
            maxCount = Math.max(count, maxCount);
            return;
        } else{
            visited[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < r && ny >= 0 && ny < c){
                    dfs(nx, ny, count + 1);
                }
            }
            visited[map[x][y]] = false;
        }
    }
/*
    처음 풀이
    public static void dfs(int x, int y, int count, boolean[] visit){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= r || ny < 0 || ny >= c){
                continue;
            }
            if(!visit[map[nx][ny] - 'A']){
                boolean[] newV = visit;
                newV[map[nx][ny] - 'A'] = true;
                if(maxCount < count + 1){
                    maxCount = count + 1;
                }
                dfs(nx, ny, count + 1, newV);
            }
        }
    }
*/

    public static class Maze {
        public int x;
        public int y;
        public int count;
        public boolean[] visited;

        public Maze(int x, int y, int count, boolean[] visited) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.visited = visited;
        }
    }
}
