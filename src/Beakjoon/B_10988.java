package Beakjoon;

import java.util.Scanner;

public class B_10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        if(isPel(s)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static boolean isPel(String s){
        int length = s.length();
        for(int i = 0; i < length / 2; i++){
            if(s.charAt(i) != s.charAt(length - i - 1)){
                return false;
            }
        }
        return true;
    }
}
