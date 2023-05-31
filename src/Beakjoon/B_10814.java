package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<User> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new User(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                /*
                //이름은 사전순 정렬이 아닌, 가입한 순서대로,,,
                if(a.age == b.age){
                    return b.name.compareTo(a.name);
                }
                */
                return a.age - b.age;
            }
        };

        Collections.sort(list, comparator);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            User user = list.get(i);
            sb.append(user.age).append(' ').append(user.name).append('\n');
        }

        System.out.println(sb);
    }

    public static class User{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
