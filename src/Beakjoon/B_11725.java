package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        boolean[] visit = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        int[] result = new int[n + 1];
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for(int i: lists[poll]){
                if(!visit[i]){
                    visit[i] = true;
                    result[i] = poll;
                    queue.add(i);
                }
            }
        }

        for(int i = 2; i <= n; i++){
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }
    /*
    //오답. 시간초과
    public static Node root = new Node(1);
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            add(parent, child);
        }

        for (int i = 2; i <= n; i++) {
            sb.append(searchParent(root, i).val).append('\n');
        }

        System.out.println(sb);
    }

    public static Node searchParent(Node node, int val){
        List<Node> childNode = node.childNode;
        Node target = null;
        for(Node child: childNode){
            if(child.val == val){
                target = node;
            }else{
                target = searchParent(child, val);
            }
            if(target != null){
                break;
            }
        }
        return target;
    }


    public static void add(int parent, int child){
        if(parent == 1){
            root.childNode.add(new Node(child));
            return;
        }else if(child == 1){
            root.childNode.add(new Node(parent));
            return;
        }
        if(hasParent(child)){
            Node searchNode = search(root, child);
            searchNode.childNode.add(new Node(parent));
        }else{
            Node searchNode = search(root, parent);
            searchNode.childNode.add(new Node(child));
        }

    }

    public static boolean hasParent(int child){
        return search(root, child) != null;
    }

    public static Node search(Node node, int val){
        List<Node> childNode = node.childNode;
        Node target = null;
        for(Node child: childNode){
            if(child.val == val){
                target = child;
            }else{
                target = search(child, val);
            }
            if(target != null){
                break;
            }
        }
        return target;
    }

    public static class Node{
        public int val;
        public List<Node> childNode;

        public Node(int val) {
            this.val = val;
            this.childNode = new ArrayList<>();
        }
    }
    */
}
