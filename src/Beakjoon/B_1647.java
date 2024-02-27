package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1647 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        ArrayList<Node>[] houses = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            houses[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            houses[a].add(new Node(b, c));
            houses[b].add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node target = pq.poll();

            if(visited[target.next]) {
                continue;
            }

            visited[target.next] = true;
            sum += target.weight;
            max = target.weight > max ? target.weight : max;

            for(Node nextHouse: houses[target.next]) {
                if(!visited[nextHouse.next]) {
                    pq.offer(nextHouse);
                }
            }
        }

        System.out.println(sum - max);
    }

    public static class Node implements Comparable<Node>{
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
}
