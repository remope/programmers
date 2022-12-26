package Level2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int cacheContain = 0;
        ArrayList<String> cache = new ArrayList<>();
        LinkedList<String> lru = new LinkedList<>();
        for(String city: cities){
            city = city.toLowerCase();
            if(!cache.contains(city) || cacheSize == 0){      //cache miss
                if(cacheContain < cacheSize){
                    cacheContain++;
                    cache.add(city);
                }else{
                    String ca = lru.poll();
                    cache.remove(ca);
                    cache.add(city);
                }
                lru.add(city);
                answer+=5;
            }else{  //cache hit
                lru.remove(city);
                lru.add(city);
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        System.out.println(cache.solution(0, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
    }
}
