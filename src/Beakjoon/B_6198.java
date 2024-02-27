package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_6198 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = 0;

        Stack<Integer> building = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            while(!building.isEmpty()) {
                if(building.peek() <= height) {
                    building.pop();
                } else {
                    break;
                }
            }

            res += building.size();

            building.push(height);
        }

        System.out.println(res);

    }
}
