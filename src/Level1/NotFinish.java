package Level1;

import java.util.Arrays;

public class NotFinish {
    public StrDeal solution(StrDeal[] participant, StrDeal[] completion) {
        int i = 0;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                break;
            }
        }
        return participant[i];
    }
}
