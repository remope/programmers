package Level1;

public class Dart {
    public int solution(String dartResult) {
        int answer = 0;
        String strNum = "";
        int num = 0;
        int first = 0;
        int second = 0;
        for(int i = 0; i < dartResult.length(); i++){
            if(dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9'){
                strNum += dartResult.charAt(i);
            }else{
                if(dartResult.charAt(i) == 'S'){
                    num = Integer.parseInt(strNum);
                    strNum = "";
                    second = first;
                    first = num;
                    answer += first;
                } else if(dartResult.charAt(i) == 'D'){
                    num = Integer.parseInt(strNum);
                    strNum = "";
                    second = first;
                    first = num * num;
                    answer += first;
                } else if(dartResult.charAt(i) == 'T'){
                    num = Integer.parseInt(strNum);
                    strNum = "";
                    second = first;
                    first = num * num * num;
                    answer += first;
                } else if(dartResult.charAt(i) == '*'){
                    answer += first + second;
                    second *= 2;
                    first *= 2;
                } else if(dartResult.charAt(i) == '#'){
                    answer -= first * 2;
                    first *= -1;
                }

            }
        }
        return answer;
    }
}
