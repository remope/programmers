package Beakjoon;

import java.util.Scanner;

public class B_1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for(int i = 0; i < 8; i++){
            String row = sc.next();
            for(int j = 0; j < 8; j++){
                if(row.charAt(j) == 'F'){
                    if((i + j) % 2 == 0){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
