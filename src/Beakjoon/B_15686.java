package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_15686 {

    public static int N;
    public static int M;
    public static int[][] map;
    public static int minDist = Integer.MAX_VALUE;
    public static List<Position> homes = new ArrayList<>();
    public static List<Position> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    homes.add(new Position(i, j));
                }
            }
        }

        dfs(0, 0);

        System.out.println(minDist);

    }

    public static void dfs(int start, int depth) {
        int sumDistance = 0;
        if (depth == M) {
            for(Position home: homes) {
                int minHome = Integer.MAX_VALUE;
                for(Position chicken: chicken) {
                    int dist = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
                    minHome = Math.min(minHome, dist);
                }
                sumDistance += minHome;
            }
            minDist = Math.min(sumDistance, minDist);
            return;
        }

        for (int i = start; i < N*N; i++) {
            int x = i / N;
            int y = i % N;
            
            if(map[x][y] == 2) {
                chicken.add(new Position(x, y));
                dfs(i + 1, depth + 1);
                chicken.remove(chicken.size() - 1);
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
