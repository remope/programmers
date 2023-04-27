package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13549 {
    static int n, k;
    static int[] visited = new int[100001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 1});
        visited[n] = 1;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int time = poll[1];
            if(x - 1 >= 0 && x - 1 <= 100000){
                if(visited[x - 1] == 0 || visited[x - 1] > time + 1){
                    queue.add(new int[] {x - 1, time + 1});
                    visited[x - 1] = time + 1;
                }
            }
            if(x + 1 >= 0 && x + 1 <= 100000){
                if(visited[x + 1] == 0 || visited[x + 1] > time + 1){
                    queue.add(new int[] {x + 1, time + 1});
                    visited[x + 1] = time + 1;
                }
            }
            if(x * 2 >= 0 && x * 2 <= 100000){
                if(visited[x * 2] == 0 || visited[x * 2] > time){
                    queue.add(new int[] {x * 2, time});
                    visited[x * 2] = time;
                }
            }
        }
        System.out.println(visited[k] - 1);

    }

}
