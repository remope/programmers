package Level1;

public class StringToInt {
    public int solution(String s) {
        int answer = 0;
        int flag = 1;
        int index = 0;
        if(s.charAt(0) == '-'){
            flag = -1;
            index++;
        }else if (s.charAt(0) == '+'){
            flag = 1;
            index++;
        }
        answer = flag * Integer.parseInt(s.substring(index, s.length()));
        return answer;
    }
}
