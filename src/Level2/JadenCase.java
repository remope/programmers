package Level2;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        int flag = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                answer += s.charAt(i);
                flag = 0;
            }else if(flag == 0){
                answer += s.substring(i, i+1).toUpperCase();
                flag = 1;
            }else if(flag == 1){
                answer += s.substring(i, i+1).toLowerCase();
            }
        }
        return answer;
    }
}
