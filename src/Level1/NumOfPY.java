package Level1;

public class NumOfPY {
    boolean solution(String s) {
        s = s.toLowerCase();
        return s.chars().filter(c -> c == 'p').count() == s.chars().filter(c -> c == 'y').count();
    }
}
