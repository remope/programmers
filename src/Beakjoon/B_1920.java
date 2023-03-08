package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int[] ary = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for(int i: ary){
            if(binarySearch(a, i)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(int[] ary, int target){
        int left = 0;
        int right = ary.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(ary[mid] == target){
                return true;
            }else if(ary[mid] < target){
                left = mid + 1;
            }else if(ary[mid] > target){
                right = mid - 1;
            }
        }
        return false;
    }
}
