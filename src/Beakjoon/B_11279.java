package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B_11279 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        for(int i = 0; i < N; i++) {
            int command = Integer.parseInt(br.readLine());
            if(command == 0) {
                Integer num = maxHeap.poll();
                System.out.println(num == null ? 0 : num);
            } else {
                maxHeap.add(command);
            }
        }

    }
}
