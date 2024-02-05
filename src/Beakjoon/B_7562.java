package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7562 {
    public static StringBuffer sb = new StringBuffer();
    public static boolean[][] visited;
    public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    public static int x;
    public static int y;
    public static int targetX;
    public static int targetY;
    public static int range;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            range = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Node node = new Node(x, y, 0);

            st = new StringTokenizer(br.readLine(), " ");
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());
            if(x == targetX && y == targetY) {
                sb.append(0).append("\n");
                continue;
            }

            bfs(node);
        }

        System.out.println(sb);
    }

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited = new boolean[range][range];
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int count = now.count + 1;

                if(nx < 0 || nx >= range || ny < 0 || ny >= range || visited[nx][ny]) {
                    continue;
                }

                if(nx == targetX && ny == targetY) {
                    sb.append(count).append("\n");
                    return;
                }

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, count));
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
