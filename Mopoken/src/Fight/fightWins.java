package Fight;
import models.Mopoken;
public class fightWins {
    private Rules rules;

    public fightWins(Rules rules){
        this.rules = rules;
    }

    public int fightoutcome(Mopoken player, Mopoken defense){

        boolean playeradv = rules.chkWinner(player.getType(), defense.getType());

        if(playeradv && defense.getLevel()<2*player.getLevel()){
            return 1;
        }
        if(!playeradv && player.getLevel()<2*defense.getLevel()){
            return -1;
        }

        if (player.getLevel() > defense.getLevel()){
            return 1;
        }

        if (player.getLevel() < defense.getLevel()){
            return -1;
        }

        return 0;
    }
}
