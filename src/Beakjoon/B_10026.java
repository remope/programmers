package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_10026 {
    public static int n;
    public static char[][] picture;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int count = 0;
        n = Integer.parseInt(br.readLine());

        picture = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                picture[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    bfs1(i, j, picture[i][j]);
                    count++;
                }
            }
        }
        sb.append(count).append(" ");
        count = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    bfs2(i, j, picture[i][j]);
                    count++;
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
    public static class Pixel{
        public int x;
        public int y;

        public Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs1(int x, int y, char color){
        Queue<Pixel> queue = new LinkedList<>();
        queue.add(new Pixel(x, y));
        while(!queue.isEmpty()){
            Pixel poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }
                if(visited[nx][ny] == false && color == picture[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new Pixel(nx, ny));
                }
            }
        }
    }

    public static void bfs2(int x, int y, char color){
        Queue<Pixel> queue = new LinkedList<>();
        queue.add(new Pixel(x, y));
        while(!queue.isEmpty()){
            Pixel poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }
                if(visited[nx][ny] == false && getColor(color) == getColor(picture[nx][ny])){
                    visited[nx][ny] = true;
                    queue.add(new Pixel(nx, ny));
                }
            }
        }
    }

    public static int getColor(char color){
        if(color == 'R' || color == 'G'){
            return 0;
        }else {
            return 1;
        }
    }
}
