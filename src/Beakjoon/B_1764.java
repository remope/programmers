package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> listen = new HashSet<>();
        Set<String> watch = new HashSet<>();

        for (int i = 0; i < n; i++) {
            listen.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            watch.add(br.readLine());
        }

        List<String> listenAndWatch = new ArrayList<>();

        for (String s : listen) {
            if(watch.contains(s)){
                listenAndWatch.add(s);
            }
        }
        Collections.sort(listenAndWatch);
        StringBuffer sb = new StringBuffer();
        sb.append(listenAndWatch.size()).append('\n');
        for(String s: listenAndWatch){
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
