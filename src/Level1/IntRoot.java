package Level1;

public class IntRoot {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt == (int) sqrt ? (long) ((sqrt+1) * (sqrt+1)) : -1;
    }
}
