package Beakjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        for(int i: list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
