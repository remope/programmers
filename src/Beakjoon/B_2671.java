package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2671 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pattern = "(100+1+|01)+";
        String input = br.readLine();

        System.out.println(input.matches(pattern) ? "SUBMARINE" : "NOISE");
    }
}
