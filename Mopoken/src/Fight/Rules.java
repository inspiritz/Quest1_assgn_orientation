package Fight;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Rules {
    private Map<String, List<String>> advantages = new HashMap<>();

    public Map<String, List<String>> getAdvantages() {
        return advantages;
    }

    public void advantageRules(){
        addRules("Fire", "Grass");
        addRules("Fire","Ghost");
        addRules("Water","Fire");
        addRules("Grass","Electric");
        addRules("Grass","Fighting");
        addRules("Electric","Water");
        addRules("Pyschic","Ghost");
        addRules("Ghost","Fighting");
        addRules("Ghost","Fire");
        addRules("Ghost","Electric");
        addRules("Fighting","Electric");
    }
    public void addRules(String wins, String lose){
        if(!advantages.containsKey(wins)){
            advantages.put(wins,new ArrayList<>());
        }
        else{
            advantages.get(wins).add(lose);
        }
    }

    public boolean chkWinner (String chkwins, String chklose){
        if (advantages.containsKey(chkwins)){
            if((advantages.get(chkwins).contains(chklose))) {
                return true;
            }
        }
        return false;
    }
}
