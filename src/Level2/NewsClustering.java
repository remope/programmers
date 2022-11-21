package Level2;


import java.util.ArrayList;

public class NewsClustering {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> str1List = new ArrayList<>();
        ArrayList<String> str2List = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String>intersection = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++){
            char char1 = str1.charAt(i);
            char char2 = str1.charAt(i + 1);

            if(Character.isLetter(char1) && Character.isLetter(char2)) {
                str1List.add(Character.toString(char1) + char2);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++){
            char char1 = str2.charAt(i);
            char char2 = str2.charAt(i + 1);

            if(Character.isLetter(char1) && Character.isLetter(char2)) {
                str2List.add(Character.toString(char1) + char2);
            }
        }

        for(String str: str1List) {
            if(str2List.remove(str)) {
                intersection.add(str);
            }
            union.add(str);
        }
        for(String s : str2List) {
            union.add(s);
        }

        double answer = 0;

        if(union.size() == 0)
            answer = 1;	// 공집합일 경우 1
        else
            answer = (double) intersection.size() / (double) union.size();

        return (int) (answer * 65536);
    }
}
