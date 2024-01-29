package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2583 {
    public static int M, N, K;
    public static int[][] map;
    public static int count;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int y = leftY; y < rightY; y++) {
                for (int x = leftX; x < rightX; x++) {
                    map[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> numArea = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    numArea.add(count);
                }
            }
        }

        Collections.sort(numArea);
        sb.append(numArea.size()).append("\n");
        for(int i: numArea) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int y, int x) {
        map[y][x] = 1;
        count++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= M || nx < 0 || nx >= N) {
                continue;
            }

            if(map[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    }
}
