package Level1;

public class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        int idx = 0;
        String[] validBabbling = {"aya", "ye", "woo", "ma"};
        String[] unvalidBabbling = {"ayaaya", "yeye", "woowoo", "mama"};
        for(String bab: babbling){
            for(String unvalBab: unvalidBabbling){
                bab = bab.replace(unvalBab, "x");
            }

            for(String valBab: validBabbling){
                bab = bab.replace(valBab, "0");
            }
            int flag = 0;
            for(int i = 0; i < bab.length(); i++){
                if(!bab.subSequence(i, i+1).equals("0")){
                    flag++;
                    break;
                }
            }
            if(flag == 0) answer++;
        }
        return answer;
    }
}
