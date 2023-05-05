package Beakjoon;


import java.util.Scanner;

public class B_5639 {
    public static Node root;
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            insert(sc.nextInt());
        }

        traverse(root);
        System.out.println(sb);
    }

    public static void traverse(Node node){
        if(node == null){
            return;
        }
        traverse(node.left);
        traverse(node.right);
        sb.append(node.val).append('\n');
    }

    public static void insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        Node node = root;
        while(true){
            if(node.val > value){
                if(node.left == null){
                    node.left = new Node(value);
                    break;
                }else{
                    node = node.left;
                }
            }else{
                if(node.right == null){
                    node.right = new Node(value);
                    break;
                }else{
                    node = node.right;
                }
            }
        }
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }
}
