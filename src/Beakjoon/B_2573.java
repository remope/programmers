package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2573 {
    public static int N, M, date;
    public static int[][] map;
    public static boolean[][] isVisited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] meltMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        date = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(hasIce()) {
            isVisited = new boolean[N][M];
            meltMap = new int[N][M];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] != 0 && !isVisited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            if(count >= 2) {
                break;
            }
            date++;
            melt();
        }

        System.out.println(date);


    }

    public static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = map[i][j] - meltMap[i][j] < 0 ? 0 : map[i][j] - meltMap[i][j];
            }
        }
    }

    public static boolean hasIce() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    return true;
                }
            }
        }
        date = 0;
        return false;
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        isVisited[x][y] = true;

        while(!q.isEmpty()) {
            Node poll = q.poll();
            int meltCount = 0;
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !isVisited[nx][ny]) {
                    if (map[nx][ny] != 0) {
                        isVisited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    } else {
                        meltCount++;
                    }
                }
            }
            meltMap[poll.x][poll.y] = meltCount;
        }
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
