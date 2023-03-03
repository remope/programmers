package Beakjoon;

import java.util.Scanner;

public class B_1316 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for(int i = 0; i < n; i++){
            boolean[] alpha = new boolean[26];
            String s = sc.next();
            result++;
            for(int j = 1; j < s.length(); j++){
                char now = s.charAt(j);
                char before = s.charAt(j - 1);
                if(now == before) {
                    alpha[now - 'a'] = true;
                }else {
                    if(alpha[now - 'a'] == false){
                        alpha[now - 'a'] = true;
                        alpha[before - 'a'] = true;
                    } else if(alpha[now - 'a'] == true){
                        result--;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
