package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {
    public static int N, M;
    public static int[][] map;
    public static int[][][] isVisited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int cost = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        map = new int[N][M];
        isVisited = new int[2][N][M];
        for (int i = 0; i < N; i++) {
            String subMaps = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = subMaps.charAt(j) - '0';
            }
        }

        if(N == 1 && M == 1) {
            if(map[0][0] == 0) {
                System.out.println(1);
            }else {
                System.out.println(-1);
            }
            return;
        }

        bfs();

        System.out.println(cost == Integer.MAX_VALUE ? -1 : cost);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, false));
        isVisited[0][0][0] = 1;
        isVisited[1][0][0] = 1;

        while(!q.isEmpty()) {
            Node poll = q.poll();



            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if(nx == N - 1 && ny == M - 1) {
                    cost = Math.min(poll.depth + 1, cost);
                    continue;
                }

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if(map[nx][ny] == 0) {
                    if(!poll.flag && isVisited[0][nx][ny] == 0) {
                        q.add(new Node(nx, ny, poll.depth + 1, false));
                        isVisited[0][nx][ny] = poll.depth + 1;
                    } else if (poll.flag && isVisited[1][nx][ny] == 0) {
                        q.add(new Node(nx, ny, poll.depth + 1, true));
                        isVisited[1][nx][ny] = poll.depth + 1;
                    }
                } else if (map[nx][ny] == 1) {
                    if(!poll.flag) {
                        q.add(new Node(nx, ny, poll.depth + 1, true));
                        isVisited[1][nx][ny] = poll.depth + 1;
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int depth;
        boolean flag;

        public Node(int x, int y, int depth, boolean flag) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.flag = flag;
        }
    }
}

