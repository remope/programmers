package Level2;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < length; i++){
            if(citations[i] >= length - i) return length - i;
        }
        return answer;
    }
}
