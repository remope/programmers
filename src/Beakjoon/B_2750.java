package Beakjoon;

import java.util.Scanner;

public class B_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ary = new int[n];

        for(int i = 0; i < n; i++){
            ary[i] = sc.nextInt();
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(ary[j] > ary[j + 1]){
                    int temp = ary[j];
                    ary[j] = ary[j+1];
                    ary[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(ary[i]);
        }
    }
}
