package Beakjoon;

import java.util.Scanner;

public class B_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] ary = new long[100];     //overflow 조심하기, int로 선언했다가 틀림
        ary[0] = 1;
        ary[1] = 1;
        ary[2] = 1;
        ary[3] = 2;
        ary[4] = 2;
        for(int i = 5; i < 100; i++){
            ary[i] = ary[i - 1] + ary[i - 5];
        }
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            System.out.println(ary[a - 1]);
        }
    }
}
