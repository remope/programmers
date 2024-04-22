package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            minHeap.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K - 1; i++) {
            minHeap.poll();
        }

        System.out.println(minHeap.poll());

    }
}
