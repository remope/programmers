package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_18405 {
    public static int n, k, s, x, y;
    public static int[][] map;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static Queue<Virus> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    virusList.add(new Virus(i, j, 0, map[i][j]));
                }
            }
        }

        Collections.sort(virusList, new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                return o1.priority - o2.priority;
            }
        });

        st = new StringTokenizer(br.readLine(), " ");

        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        for(Virus v : virusList){
            queue.add(v);
        }

        bfs();

        System.out.println(map[x - 1][y - 1]);



    }

    public static void bfs(){

        while(!queue.isEmpty()){
            Virus poll = queue.poll();
            int mapX = poll.x;
            int mapY = poll.y;
            int second = poll.second;
            int priority = poll.priority;

            if(second >= s){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = mapX + dx[i];
                int ny = mapY + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if(map[nx][ny] == 0){
                    map[nx][ny] = priority;
                    queue.add(new Virus(nx, ny, second + 1, priority));
                }
            }
        }
    }

    public static class Virus {
        public int x;
        public int y;
        public int second;
        public int priority;

        public Virus(int x, int y, int second, int priority) {
            this.x = x;
            this.y = y;
            this.second = second;
            this.priority = priority;
        }
    }
}
