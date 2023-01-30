package Level2;

import java.util.ArrayList;
import java.util.List;

public class EnglishWordRelay {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for(int i = 1; i < words.length; i++){
            String before = list.get(list.size() - 1);
            String now = words[i];
            if(!list.contains(now) && before.charAt(before.length() - 1) == now.charAt(0)){
                list.add(now);
            }else{
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
}
