package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4963 {
    static int[][] map;
    static StringBuffer sb = new StringBuffer();
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int w;
    static int h;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int count = 0;
            if(w == 0 && h == 0){
                break;
            }

            map =  new int[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1){
                        map[i][j] = 0;
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    public static void bfs(int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        while(!q.isEmpty()){
            int[] before = q.poll();
            int x = before[0];
            int y = before[1];
            for(int i = 0; i < 8; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >= 0 && newX < h && newY >= 0 && newY < w && map[newX][newY] == 1){
                    map[newX][newY] = 0;
                    q.add(new int[] {newX, newY});
                }
            }
        }


    }
}
