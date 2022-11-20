package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tuple {
    public int[] solution(String s) {
        /*
        ArrayList<Integer> answer = new ArrayList<>();

        s = s.substring(2,s.length());
        s = s.substring(0,s.length() - 2);

        s = s.replace("},{", "/");

        String[] strs = s.split("/");

        Arrays.sort(strs, (String s1, String s2) -> s1.length() - s2.length());

        for(String str: strs){
            String[] temp = str.split(",");
            for(int i = 0; i < temp.length; i++){
                int num = Integer.parseInt(temp[i]);
                if(!answer.contains(num)){
                    answer.add(num);
                }
            }
        }
        return answer;
        */
/*
        String[] ary = s.replaceAll("\\{", " ").replaceAll("\\}", " ").trim().split(" , ");
        Arrays.sort(ary, (String s1, String s2) -> s1.length() - s2.length());

        String[] answerAry = ary[ary.length - 1].split(",");

        int[] answer = new int[answerAry.length];
        int index = 0;

        for(String str: answerAry){
            answer[index++] = Integer.parseInt(str);
        }
        return answer;
        */
        Set<String> set = new HashSet<>();
        String[] ary = s.replaceAll("\\{", " ").replaceAll("\\}", " ").trim().split(" , ");
        Arrays.sort(ary, (String s1, String s2) -> s1.length() - s2.length());

        int[] answer = new int[ary.length];
        int index = 0;

        for(String str: ary){
            for(String str2: str.split(",")){
                if(set.add(str2)){
                    answer[index++] = Integer.parseInt(str2);
                }
            }
        }
        return answer;
    }
}
