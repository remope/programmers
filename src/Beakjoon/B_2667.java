package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2667 {
    static int total;
    static int n;
    static int houseNum;
    static int[][] house;
    static StringBuffer sb = new StringBuffer();
    static List<Integer> list = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        house = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < n; j++){
                house[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(house[i][j] == 1){
                    houseNum = 0;
                    queue.add(new int[] {i, j});
                    house[i][j] = 0;
                    total++;
                    bfs();
                    list.add(houseNum);
                }
            }
        }
        sb.append(total).append("\n");
        Collections.sort(list);
        list.forEach(i -> sb.append(i).append("\n"));

        System.out.println(sb);
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] before = queue.poll();
            int x = before[0];
            int y = before[1];
            houseNum++;
            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 || newX >= n || newY < 0 || newY >= n){
                    continue;
                }
                if(house[newX][newY] == 1){
                    house[newX][newY] = 0;
                    queue.add(new int[] {newX, newY});
                }
            }
        }
    }
}
