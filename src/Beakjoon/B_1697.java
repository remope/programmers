package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean[] visited = new boolean[100001];
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k){
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[n] = true;
        int count = 0;
        queue.add(n);
        while(true){
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int before = queue.poll();
                visited[before] = true;

                if(before - 1 == k || before + 1 == k || before * 2 == k){
                    System.out.println(count);
                    return;
                }

                if(before - 1 >= 0 && !visited[before - 1]){
                    visited[before - 1] = true;
                    queue.add(before - 1);
                }
                if(before + 1 <= 100000 && !visited[before + 1]){
                    visited[before + 1] = true;
                    queue.add(before + 1);
                }
                if(before * 2 <= 100000 && !visited[before * 2]){
                    visited[before * 2] = true;
                    queue.add(before * 2);
                }
            }
        }
    }
}
