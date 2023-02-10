package Beakjoon;

import java.util.Scanner;

public class B_1769 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        long sum = 0;
        int count = 0;
        while(true){
            sum = 0;
            if(n.length() == 1){
                break;
            }
            for(int i = 0; i < n.length(); i++){
                sum += Long.parseLong(String.valueOf(n.charAt(i)));
            }
            n = String.valueOf(sum);
            count++;
        }
        System.out.println(count);
        if(Integer.valueOf(n) % 3 == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
