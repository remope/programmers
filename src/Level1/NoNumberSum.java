package Level1;

import java.util.Arrays;

public class NoNumberSum {
    public int solution(int[] numbers) {
        int sum0To9 = 45;
        return sum0To9 - Arrays.stream(numbers).sum();
    }
}
