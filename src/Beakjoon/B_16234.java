package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16234 {
    public static int N, L, R;
    public static int[][] nations;
    public static boolean[][] isVisited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        nations = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                nations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 1;
        int day = 0;
        while(count != 0) {
            count = 0;
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!isVisited[i][j]) {
                        isVisited[i][j] = true;
                        count += bfs(i, j);
                    }
                }
            }
            if(count > 0) {
                day++;
            }
        }


        System.out.println(day);


    }

    public static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        Queue<Node> change = new LinkedList<>();
        int sumPopulation = 0;

        q.add(new Node(r, c));
        change.add(new Node(r, c));
        sumPopulation += nations[r][c];

        while(!q.isEmpty()) {
            Node before = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = before.x + dx[i];
                int ny = before.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || isVisited[nx][ny]) {
                    continue;
                }

                int population = Math.abs(nations[before.x][before.y] - nations[nx][ny]);
                if(population >= L && population <= R) {
                    isVisited[nx][ny] = true;
                    sumPopulation += nations[nx][ny];
                    q.add(new Node(nx, ny));
                    change.add(new Node(nx, ny));
                }
            }
        }
        if(change.size() > 1) {
            int avgPopulation = sumPopulation / change.size();
            while(!change.isEmpty()) {
                Node changeNation = change.poll();
                nations[changeNation.x][changeNation.y] = avgPopulation;
            }
            return 1;
        }
        return 0;
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
