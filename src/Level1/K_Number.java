package Level1;

import java.util.Arrays;

public class K_Number {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] ary: commands){
            int[] temp = Arrays.copyOfRange(array, ary[0] - 1, ary[1]);
            Arrays.sort(temp);
            answer[idx++] = temp[ary[2] - 1];
        }
        return answer;
    }
}
