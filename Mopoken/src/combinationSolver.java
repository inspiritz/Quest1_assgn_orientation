import models.Breeder;
import models.Mopoken;
import Fight.fightWins;
import Fight.Rules;
import java.util.*;
public class combinationSolver {

    private final fightWins fighter;

    public combinationSolver(fightWins fighter) {
        this.fighter = fighter;
    }

    public List<Mopoken> findOptimalSequence(Breeder myBreeder, Breeder opponent) {
        List<Mopoken> myList = myBreeder.getMopokens();
        List<Mopoken> oppList = opponent.getMopokens();

        List<List<Mopoken>> allPermutations = permute(myList);

        for (List<Mopoken> perm : allPermutations) {
            int wins = 0;
            for (int i = 0; i < 5; i++) {
                int result = fighter.fightoutcome(perm.get(i), oppList.get(i));
                if (result == 1) wins++;
            }
            if (wins >= 3) return perm;
        }

        return Collections.emptyList();
    }


    private List<List<Mopoken>> permute(List<Mopoken> mopokens) {
        List<List<Mopoken>> result = new ArrayList<>();
        if (mopokens.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }

        for (int i = 0; i < mopokens.size(); i++) {
            Mopoken current = mopokens.get(i);

            List<Mopoken> remaining = new ArrayList<>(mopokens);
            remaining.remove(i);

            for (List<Mopoken> perm : permute(remaining)) {
                List<Mopoken> newPerm = new ArrayList<>();
                newPerm.add(current);
                newPerm.addAll(perm);
                result.add(newPerm);
            }
        }

        return result;
    }
}
