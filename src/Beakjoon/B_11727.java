package Beakjoon;

import java.util.Scanner;

public class B_11727 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(dp(n));
    }
    public static int dp(int n){
        if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 3;
        }
        int[] ary = new int[n];
        ary[0] = 1;
        ary[1] = 3;
        for(int i = 2; i < n; i++){
            ary[i] = (ary[i-1] + 2 * ary[i-2]) % 10007;
        }
        return ary[n - 1];
    }
}
