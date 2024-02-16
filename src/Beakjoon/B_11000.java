package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Class> classes = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes.add(new Class(start, end));
        }

        Collections.sort(classes);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int endTime = 0;
        for(Class m: classes) {
            endTime = m.end;
            if(!pq.isEmpty() && pq.peek() <= m.start) {
                pq.poll();
            }
            pq.add(endTime);
        }
        System.out.println(pq.size());
    }

    public static class Class implements Comparable<Class> {
        public int start;
        public int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
