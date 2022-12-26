package Level1;

public class StrDeal {
    public boolean solution(String s) {
        int length = s.length();
        if(length != 4 && length != 6){
            return false;
        }
        for(int i = 0; i < length; i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StrDeal strDeal = new StrDeal();
        System.out.println(strDeal.solution("1234"));
    }
}
