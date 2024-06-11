package Method;

public class makeIntegerToBinaryFiveBit {
    public static int N = 10;
    public static void main(String[] args) {
        System.out.println(intToBinaryFiveBit(16));
    }

    public static String intToBinaryFiveBit (int n) {
        String temp = "";
        while(n > 0) {
            temp += String.valueOf(n % 2);
            n /= 2;
        }

        int len = temp.length();
        String rtnStr = "";
        for (int i = 0; i < N - len; i++) {
            rtnStr += "0";
        }
        for (int i = len - 1; i >= 0; i--) {
            rtnStr += temp.charAt(i);
        }
        return rtnStr;
    }
}
