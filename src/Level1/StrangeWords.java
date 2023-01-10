package Level1;

public class StrangeWords {
    public String solution(String s) {
        String answer = "";
        String[] strAry = s.split("");
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            if(strAry[i].equals(" ")){
                idx = 0;
            }else if(idx % 2 == 0){
                strAry[i] = strAry[i].toUpperCase();
                idx++;
            }else if(idx % 2 == 1){
                strAry[i] = strAry[i].toLowerCase();
                idx++;
            }
            answer += strAry[i];
        }
        return answer;
    }
}
