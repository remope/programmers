package Level1;

import java.util.*;

public class NewId {
    public String solution(String new_id) {
        String answer = "";
        int index = 0;
        //1단계
        new_id = new_id.toLowerCase(Locale.ROOT);

        //2단계
        while(index < new_id.length()){
            if(!((new_id.charAt(index) >= '0' && new_id.charAt(index) <= '9') ||
                    (new_id.charAt(index) >= 'a' && new_id.charAt(index) <= 'z') || new_id.charAt(index) == '-' ||
                    new_id.charAt(index) == '_' || new_id.charAt(index) == '.')){
                new_id = new_id.substring(0,index) + new_id.substring(index+1);
            }else {
                index++;
            }
        }

        //3단계
        while(new_id.contains("..")){
            new_id = new_id.replaceAll("\\.\\.", "\\.");
        }

        //4단계
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }

        //5단계
        if(new_id.equals("")){
            new_id = "a";
        }

        //6단계
        if(new_id.length() > 15){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }

        //7단계
        if(new_id.length() <= 2){
            int length = new_id.length();
            do{
                new_id += new_id.charAt(length-1);
            }while(new_id.length() < 3);
        }

        return new_id;
    }
}
