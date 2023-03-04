package Beakjoon;

import java.util.HashSet;
import java.util.Scanner;

public class B_2941 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("c=");  set.add("c-");  set.add("dz="); set.add("d-");
        set.add("lj");  set.add("nj");  set.add("s=");  set.add("z=");

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int length = str.length();
        int start = 0;
        int end = 1;
        int count = 0;
        while(end <= length){
            if(end - start > 3){
                start++;
                end = start + 1;
                count++;
                continue;
            }
            String temp = str.substring(start, end);
            if(set.contains(temp)){
                start = end;
                end = start + 1;
                count++;
            }else{
                end++;
            }
        }
        if(start != length){
            count += (length - start);
        }
        System.out.println(count);
    }
}
