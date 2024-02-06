package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1916 {
    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int getStart = Integer.parseInt(st.nextToken());
        int getEnd = Integer.parseInt(st.nextToken());

        dijkstra(V, getStart);

        System.out.println(dist[getEnd]);
    }

    public static void dijkstra(int n, int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            int now = pq.poll().index;

            if(visited[now]) {
                continue;
            }
            visited[now] = true;

            for(Node next: graph[now]) {
                if(dist[next.index] > dist[now] + next.cost) {
                    dist[next.index] = dist[now] + next.cost;

                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
