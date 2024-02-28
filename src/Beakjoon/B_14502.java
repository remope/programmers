package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_14502 {

    public static int N;
    public static int M;
    public static int[][] map;
    public static int[][] copyMap;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int maxArea = Integer.MIN_VALUE;
    public static List<Position> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    virus.add(new Position(i, j));
                }
            }
        }

        makeWall(0, 0);
        System.out.println(maxArea);

    }

    public static void makeWall(int start, int depth) {
        if(depth == 3) {
            // 바이러스 확산을 위한 맵 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            for(Position pos: virus) {
                bfs(pos.x, pos.y);
            }
            int size = getSafeArea();
            maxArea = Math.max(maxArea, size);
            return;
        }

        for (int i = 0; i < N*M; i++) {
            int x = i / M;
            int y = i % M;

            if(map[x][y] == 0) {
                map[x][y] = 1;
                makeWall(i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    public static int getSafeArea() {
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) {
                    size++;
                }
            }
        }
        return size;
    }

    public static void bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y));

        while(!q.isEmpty()) {
            Position before = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = before.x + dx[i];
                int ny = before.y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    q.add(new Position(nx, ny));
                }
            }
        }
    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
