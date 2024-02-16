package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_5052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = br.readLine();
                trie.insert(numbers[j]);
            }
            if(trie.isEmergency(numbers[0])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static class Trie {
        private static final int PHONE_NUMBER_SIZE = 10;
        Node root;
        public Trie() {
            this.root = new Node();
            this.root.val = ' ';
        }

        public static class Node {
            Node[] child = new Node[PHONE_NUMBER_SIZE];
            boolean isTerminal = false;
            int childNum = 0;
            char val;
        }

        public void insert(String str) {
            int len = str.length();
            Node current = this.root;
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                int num = c - '0';

                if(current.child[num] == null) {
                    current.child[num] = new Node();
                    current.child[num].val = c;
                    current.childNum++;
                }

                current = current.child[num];
            }
            current.isTerminal = true;
        }

        public boolean isEmergency(String str) {
            int len = str.length();
            Node current = this.root;

            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                int num = c - '0';
                if(current.child[num] == null) {
                    return false;
                }
                current = current.child[num];
            }
            if(current != null && current.isTerminal == true && current.childNum == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

}
