package Level1;

public class Watermelon {
    public String solution(int n) {
        return n % 2 == 0 ? "수박".repeat(n / 2) : "수박".repeat ((n - 1) / 2) + "수";
    }
}
