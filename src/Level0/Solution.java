package Level0;

import java.sql.Array;
import java.util.*;

public class Solution {
//    public int[] solution(int num, int total) {
//        int startNum = 0 - total/2;
//        int sum = 0;
//        while(startNum < total){
//            sum = startNum * num + num*(num-1)/2;
//            if(sum == total) break;
//            else if(sum < total) startNum++;
//            else if(sum > total) startNum--;
//        }
//
//        int[] answer = new int[num];
//        for(int i = 0; i < num; i++){
//            answer[i] = startNum + i;
//        }
//
//        return answer;
//    }

    public int solution(String str1, String str2) {
        if(str1.contains(str2)) return 1;
        return 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("sol.solution(\"ppprrrogrammers\", \"pppp\") = " + sol.solution("ppprrrogrammers", "pppp"));
    }


}
