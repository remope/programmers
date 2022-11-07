package Level1;

import java.util.HashMap;

public class MBTI_KAKAO {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[][] indicators = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0); map.put("T", 1); map.put("C", 0); map.put("F", 1);
        map.put("J", 0); map.put("M", 1); map.put("A", 0); map.put("N", 1);
        int[][] sum = new int[4][2];
        int indicatorsIdx = 0;
        int[] score = {3,2,1,0,1,2,3};
        for(int i = 0; i < survey.length; i++){
            switch(survey[i]){
                case "RT":  case "TR":
                    indicatorsIdx = 0;
                    break;
                case "CF":  case "FC":
                    indicatorsIdx = 1;
                    break;
                case "JM":  case "MJ":
                    indicatorsIdx = 2;
                    break;
                case "AN":  case "NA":
                    indicatorsIdx = 3;
                    break;
                default:
                    indicatorsIdx = -1;
                    break;
            }
            if(choices[i] < 4){
                sum[indicatorsIdx][map.get(survey[i].substring(0,1))] += score[choices[i] - 1];
            }else{
                sum[indicatorsIdx][map.get(survey[i].substring(1))] += score[choices[i] - 1];
            }
        }
        for(int i = 0; i < 4; i++){
            if(sum[i][0] >= sum[i][1]){
                answer += indicators[i][0];
            }else{
                answer += indicators[i][1];
            }
        }
        return answer;
    }
}
