package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14940 {
    public static int n, m;
    public static int[][] map;
    public static int[][] depth;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static final int INF = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        depth = new int[n][m];
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    x = i;
                    y = j;
                }else if(map[i][j] == 0){
                    map[i][j] = INF;
                    depth[i][j] = INF;
                }
            }
        }
        bfs(x, y);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == x && j == y){
                    depth[i][j] = 0;
                } else if(depth[i][j] == 0){
                    depth[i][j] = -1;
                }else if(depth[i][j] == INF){
                    depth[i][j] = 0;
                }
                sb.append(depth[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);



    }

    public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        depth[x][y] = 0;
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if((nx >= 0 && nx < n && ny >= 0 && ny < m) && map[nx][ny] != INF && !visited[nx][ny]){
                    queue.add(new Node(nx, ny, poll.depth + 1));
                    depth[nx][ny] = poll.depth + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
