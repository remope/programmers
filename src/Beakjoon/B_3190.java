package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_3190 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int N = Integer.parseInt(br.readLine());    // 보드의 크기
        int K = Integer.parseInt(br.readLine());    // 사과의 개수

        StringTokenizer st;
        int[][] board = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1] = 2;
        }

        HashMap<Integer, String> moves = new HashMap<>();
        int L = Integer.parseInt(br.readLine());    //뱀의 방향 전환 횟수
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int second = Integer.parseInt(st.nextToken());
            String move = st.nextToken();

            moves.put(second, move);
        }

        Queue<Node> position = new LinkedList<>();
        int moveDir = 0;
        int nowX = 0;
        int nowY = 0;
        position.add(new Node(nowX, nowY));
        board[nowX][nowY] = 1;
        int second = 0;

        while (true) {
            second++;
            nowX = nowX + dx[moveDir];
            nowY = nowY + dy[moveDir];
            if(nowX < 0 || nowX >= N || nowY < 0 || nowY >= N || board[nowX][nowY] == 1) {
                break;
            }

            if(board[nowX][nowY] == 2) {    // 이동한 자리에 사과가 있을 경우
                position.add(new Node(nowX, nowY));
                board[nowX][nowY] = 1;
            } else if(board[nowX][nowY] == 0) { // 이동한 자리에 아무것도 없는 경우
                position.add(new Node(nowX, nowY));
                Node delete = position.poll();
                board[delete.x][delete.y] = 0;
                board[nowX][nowY] = 1;
            }

            if(moves.containsKey(second)) {
                if(moves.get(second).equals("D")) {  // 다음 진행방향이 오른쪽 90도 방향으로 회전한다면
                    moveDir = (moveDir + 1) % 4;
                } else {    // 다음 진행방향이 왼쪽 90도 방향으로 회전한다면
                    moveDir = (moveDir + 3) % 4; // 음수가 나올 경우를 대비해 (moveDir - 1 + 4) % 4 를 한번에 작성
                }
            }
        }

        System.out.println(second);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
