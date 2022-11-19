package Level2;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int unvalid = 0;
        Map<Character, Integer> skillTree = new HashMap<>();
        for(int i = 0; i < skill.length(); i++){
            skillTree.put(skill.charAt(i), i);
        }
        for(String skill_tree: skill_trees){
            int index = 0;
            for(int i = 0; i < skill_tree.length(); i++){
                if(skillTree.get(skill_tree.charAt(i)) != null){
                   if(skillTree.get(skill_tree.charAt(i)) > index){
                       unvalid++;
                       break;
                   }else if(skillTree.get(skill_tree.charAt(i)) == index){
                       index++;
                   }
                }
            }
        }
        return skill_trees.length - unvalid;
    }
}
