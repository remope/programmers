package Level2;

public class MinMax {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < str.length; i++){
            int parseIntValue = Integer.parseInt(str[i]);
            if(parseIntValue > max){
                max = parseIntValue;
            }
            if(parseIntValue < min){
                min = parseIntValue;
            }
        }
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}
