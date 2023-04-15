package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1991 {
    static Node head = new Node('A');
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(head, root, left, right);
        }

        preOrder(head);
        sb.append('\n');
        inOrder(head);
        sb.append('\n');
        postOrder(head);
        sb.append('\n');
        System.out.println(sb);


    }
    
    public static class Node{

        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static void insert(Node node, char root, char left, char right){
            if(node.value == root){
                node.left = left == '.' ? null : new Node(left);
                node.right = right == '.' ? null : new Node(right);
            }else{
                if(node.left != null){
                    insert(node.left, root, left, right);
                }
                if(node.right != null){
                    insert(node.right, root, left, right);
                }
            }
    }
    public static void preOrder(Node node){
        if(node == null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }
    public static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}
