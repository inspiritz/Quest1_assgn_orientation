import java.util.*;
import models.Breeder;
import models.Mopoken;
import Fight.fightWins;
import Fight.Rules;

public class Main {

    public static void main (String[] args) {
        String myInput = "Fire#10;Water#20;Fighting#6;Psychic#10;Electric#12";
        String oppInput = "Water#10;Fighting#10;Psychic#10;Fire#12;Grass#2";


        Breeder myBreeder = parseBreeder(myInput);
        Breeder opponent = parseBreeder(oppInput);

        Rules rules = new Rules();
        fightWins fighter = new fightWins(rules);


        combinationSolver solver = new combinationSolver(fighter);

        List<Mopoken> optimal = solver.findOptimalSequence(myBreeder, opponent);


        if (optimal.isEmpty()) {
            System.out.println("There are no chance of winning");
        } else {
            System.out.println("Optimal sequence for battles:");
            System.out.println(String.join(";", optimal.stream().map(Mopoken::toString).toList()));
        }
    }

    public static Breeder parseBreeder(String line) {
        Breeder breeder = new Breeder();
        String[] tokens = line.split(";");
        for (String token : tokens) {
            String[] parts = token.split("#");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid input: " + token);
            }
            String type = parts[0];
            int level = Integer.parseInt(parts[1]);
            breeder.addMopoken(new Mopoken(type, level));
        }
        return breeder;
    }


}
