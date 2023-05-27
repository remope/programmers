package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_11723 {
    public static Set<Integer> set = new HashSet<>();
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String command;
        int num;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            if(command.equals("all")){
                all();
            }else if(command.equals("empty")){
                empty();
            }else{
                num = Integer.parseInt(st.nextToken());
                if(command.equals("add")){
                    add(num);
                }else if(command.equals("remove")){
                    remove(num);
                }else if(command.equals("check")){
                    check(num);
                }else if(command.equals("toggle")){
                    toggle(num);
                }
            }


        }
        System.out.println(sb);

    }

    public static void add(int num){
        //add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
        set.add(num);
    }
    public static void remove(int num) {
        //remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
        set.remove(num);
    }
    public static void check(int num){
        //check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
        if(set.contains(num)){
            sb.append(1).append('\n');
        }else{
            sb.append(0).append('\n');
        }
    }
    public static void toggle(int num){
        //toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
        if(set.contains(num)){
            set.remove(num);
        }else{
            set.add(num);
        }
    }
    public static void all(){
        //all: S를 {1, 2, ..., 20} 으로 바꾼다.
        set.clear();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }
    public static void empty(){
        //empty: S를 공집합으로 바꾼다.
        set.clear();
    }
}
