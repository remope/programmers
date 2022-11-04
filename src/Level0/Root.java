package Level0;

public class Root {
    public int solution(int n) {
        double temp = Math.sqrt(n);
        if(n == (int) temp * temp) return 1;
        return 2;
    }
}
