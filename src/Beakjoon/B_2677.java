package Beakjoon;

import java.util.HashMap;
import java.util.Scanner;

public class B_2677 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 1;
        for(int i = 0; i < 3; i++){
            int temp = sc.nextInt();
            num *= temp;
        }
        while(num > 0){
            int digit = num % 10;
            num /= 10;
            if(map.containsKey(digit) != true){
                map.put(digit, 1);
            } else{
                map.replace(digit, map.get(digit) + 1);
            }
        }
        for(int i = 0; i < 10; i++){
            if(map.containsKey(i) != true){
                System.out.println(0);
            } else{
                System.out.println(map.get(i));
            }
        }

    }
}
