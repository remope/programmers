package Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSort {
    public String[] solution(String[] strings, int n) {
        int length = strings.length;
        String[] answer = new String[length];
        List<String> newStrings = new ArrayList<>();

        for(int i = 0; i < length; i++){
            newStrings.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(newStrings);

        for(int i = 0; i < newStrings.size(); i++) {
            answer[i] = newStrings.get(i).substring(1);
        }

        return answer;
    }
}
