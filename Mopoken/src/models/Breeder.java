package models;

import java.util.*;
public class Breeder {
    private Map<String, Mopoken> mopokens= new HashMap<>();

    public void addMopoken(Mopoken mop){
        if (mopokens.size()==5){
            throw new IllegalArgumentException("A breeder must have only 5 mopokens");
        }

        if (mopokens.containsKey(mop.getType())) {
            throw new IllegalArgumentException("Only one mopoken can be of one type");
        }

        mopokens.put(mop.getType(), mop);
    }

    public List<Mopoken> getMopokens(){
        return new ArrayList<>(mopokens.values());
    }
}
