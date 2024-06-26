package Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSelect {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                if(!list.contains(sum)){
                    list.add(sum);
                }
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
