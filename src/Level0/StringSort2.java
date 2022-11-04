package Level0;

import java.util.Arrays;

public class StringSort2 {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] temp = my_string.toCharArray();
        Arrays.sort(temp);
        String answer = new String(temp);
        return answer;
    }
}
