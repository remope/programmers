package Beakjoon;

import java.util.Scanner;

public class B_2903 {
    public static void main(String[] args) {
        int start = 2;
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int i = 0; i < loop; i++){
            start = start + (start - 1);
        }
        System.out.println(start * start);
    }
}
