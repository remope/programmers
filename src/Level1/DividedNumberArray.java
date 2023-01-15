package Level1;

import java.util.Arrays;

public class DividedNumberArray {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                count++;
            }
        }
        if(count == 0){
            return new int[] {-1};
        }
        int[] answer = new int[count];
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer[idx++] = arr[i];
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}
