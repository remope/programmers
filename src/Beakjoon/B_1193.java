package Beakjoon;

import java.util.Scanner;

public class B_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int seq = 0;
        int count = 1;
        while(seq < n){
            seq = count * (count + 1) / 2;
            count++;
        }
        count--;    //홀수면 반대로 짝수면 정방향
        int before = (count - 1) * count / 2;
        int numerator = 0;
        if(count % 2 == 0){
            numerator = 1 + (n - before - 1);
            count -= (n - before - 1);
        }else{
            numerator = count - (n - before - 1);//numerator = 1 + (n - before - 1);
            count = 1 + (n - before - 1);
        }
        System.out.println(numerator + "/" + count);
    }
}
