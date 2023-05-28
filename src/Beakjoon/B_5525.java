package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5525 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();

        int result = 0;
        int IOICount = 0;

        for(int i = 1; i < m - 1; i++){
            if(chars[i - 1] == 'I' && chars[i] == 'O' && chars[i + 1] == 'I'){
                IOICount++;
                if(IOICount == n){
                    result++;
                    IOICount--;
                }
                i++;
            }else{
                IOICount = 0;
            }
        }

        System.out.println(result);
    }
}
