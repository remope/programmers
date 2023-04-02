package Beakjoon;

import java.util.Scanner;

public class B_1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        for(int i = 2; i < 41; i++){
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int fibo = sc.nextInt();
            sb.append(zero[fibo]).append(" ").append(one[fibo]).append("\n");
            //일일히 출력하는거보다 StringBuffer에 담아서 출력하는게 빠르다. 일일히 출력하면 시간초과, sb에 담아서 하면 통과
        }
        System.out.println(sb);

    }
}
