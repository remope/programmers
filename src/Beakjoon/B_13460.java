package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13460 {

    /*  //틀린 코드
    public static int N, M, exitX, exitY;
    public static char[][] map;
    public static boolean[][] isRedVisited;
    public static boolean[][] isBlueVisited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int rx = 0, ry = 0, bx = 0, by = 0;
        map = new char[N][M];
        isRedVisited = new boolean[N][M];
        isBlueVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if(map[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if(map[i][j] == 'O') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        System.out.println(bfs(new RedBlue(rx, ry, bx, by, 0, -1)));
    }

    public static int bfs(RedBlue node) {
        Queue<RedBlue> q = new LinkedList<>();
        mapCopy(node.moveMap, map);
        q.add(node);
        while(!q.isEmpty()) {
            RedBlue poll = q.poll();
            if(poll.depth > 10) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                if(poll.beforeMove == i) {
                    continue;
                }
                char[][] moveMap = new char[N][M];
                mapCopy(moveMap, poll.moveMap);
                Node redMove;
                Node blueMove;
                boolean whoFirstMove = checkFirst(poll, i);
                if(whoFirstMove) {   //Red 먼저 움직임
                    redMove = move(poll.rx, poll.ry, i, moveMap);
                    blueMove = move(poll.bx, poll.by, i, moveMap);
                } else {
                    blueMove = move(poll.bx, poll.by, i, moveMap);
                    redMove = move(poll.rx, poll.ry, i, moveMap);
                }
                if(redMove.x == exitX && redMove.y == exitY) {
                    if(redMove.x - dx[i] == blueMove.x && redMove.y - dy[i] == blueMove.y) {
                        continue;
                    }
                    return poll.depth + 1;
                } else if(blueMove.x == exitX && blueMove.y == exitY) {
                    continue;
                } else if(redMove.x == poll.rx && redMove.y == poll.ry && blueMove.x == poll.bx && blueMove.y == poll.by) {
                    continue;
                }
                RedBlue redBlue = new RedBlue(redMove.x, redMove.y, blueMove.x, blueMove.y, poll.depth + 1, i);
                redBlue.moveMap = moveMap;
                q.add(redBlue);
            }
        }
        return -1;
    }
    public static Node move(int x, int y, int dir, char[][] moveMap) {
        int nx = x;
        int ny = y;
        while(moveMap[nx + dx[dir]][ny + dy[dir]] == '.') {
            nx += dx[dir];
            ny += dy[dir];
        }
        if(nx + dx[dir] == exitX && ny + dy[dir] == exitY) {
            moveMap[nx][ny] = moveMap[x][y];
            moveMap[x][y] = 'O';
            return new Node(nx + dx[dir], ny + dy[dir]);
        }
        if(nx == x && ny == y) {
            return new Node(nx, ny);
        }
        moveMap[nx][ny] = moveMap[x][y];
        moveMap[x][y] = '.';
        return new Node(nx, ny);
    }

    public static void mapCopy(char[][] copyMap, char[][] targetMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = targetMap[i][j];
            }
        }
    }

    public static boolean checkFirst(RedBlue node, int dir) { // true -> Red first, false -> Blue first
        if(node.rx == node.bx && node.ry > node.by && dir == 1) {
            return true;
        } else if(node.rx == node.bx && node.by > node.ry && dir == 1) {
            return false;
        } else if(node.rx == node.bx && node.ry > node.by && dir == 3) {
            return false;
        } else if(node.rx == node.bx && node.by > node.ry && dir == 3) {
            return true;
        } else if(node.ry == node.by && node.rx > node.bx && dir == 0) {
            return true;
        } else if(node.ry == node.by && node.bx > node.rx && dir == 0) {
            return false;
        } else if(node.ry == node.by && node.rx > node.bx && dir == 2) {
            return false;
        } else if(node.ry == node.by && node.bx > node.rx && dir == 2) {
            return true;
        } else {    // 겹친 경우가 아니라면 Red 먼저
            return true;
        }
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class RedBlue {
        int rx;
        int ry;
        int bx;
        int by;
        int depth;
        int beforeMove;
        char[][] moveMap;
        public RedBlue(int rx, int ry, int bx, int by, int depth, int beforeMove) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
            this.beforeMove = beforeMove;
            this.moveMap = new char[N][M];
        }
    }
    */
}
