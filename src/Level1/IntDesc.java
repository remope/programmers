package Level1;

import java.util.Arrays;
import java.util.Collections;

public class IntDesc {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] strs = str.split("");
        Arrays.sort(strs, Collections.reverseOrder());
        return Long.parseLong(String.join("", strs));
    }
}
