package Beakjoon;

import java.util.Scanner;

public class B_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        int mult = 1;
        while(b > 0){
            int mod = b % 10;
            int mul = mod * a;
            System.out.println(mul);
            sum += mult * mul;
            mult *= 10;
            b /= 10;
        }
        System.out.println(sum);
    }
}
