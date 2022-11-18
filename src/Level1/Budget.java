package Level1;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for(answer = 0; answer < d.length; answer++){
            sum += d[answer];
            if(sum > budget){
                break;
            }
        }
        return answer;
    }
}
