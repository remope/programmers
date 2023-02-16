package Beakjoon;

import java.util.Scanner;

public class B_1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] ary = new int[1001];
        int count = 1;

        for(int i = 1; i < 1001; i++){
            for(int j = 0; j < i; j++){
                if(count == 1001){
                    break;
                }
                ary[count] = i;
                count++;
            }
        }

        int sum = 0;

        for(int i = a; i <= b; i++){
            sum += ary[i];
        }

        System.out.println(sum);

    }
}
