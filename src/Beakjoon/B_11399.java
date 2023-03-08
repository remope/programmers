package Beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ary = new int[n];
        int wait = 0;

        for(int i = 0; i < n; i++){
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                wait += ary[j];
            }
        }

        System.out.println(wait);
    }
}
