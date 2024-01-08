package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1806 {
    public static int N;
    public static int S;
    public static int[] ary;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        ary = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                sum -= ary[left++];
            } else if (right == N) {
                break;
            }else{
                sum += ary[right++];
            }
            if (sum >= S) {
                min = Math.min(min, right - left);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        N = Integer.parseInt(st.nextToken());
//        S = Integer.parseInt(st.nextToken());
//
//        ary = new int[N];
//
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < N; i++) {
//            ary[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int left = 0;
//        int right = 0;
//        int sum = 0;
//        int res = Integer.MAX_VALUE;
//        int length = 0;
//
//        while(right < N) {
//            if(sum >= S) {
//                sum -= ary[left++];
//                length = right - left + 1;
//                if(res > length) {
//                    res = length;
//                }
//
//            }else if(sum < S) {
//                sum += ary[right++];
//            }
//        }
//
//        System.out.println((res) == Integer.MAX_VALUE ? 0 : res);
//    }
}
