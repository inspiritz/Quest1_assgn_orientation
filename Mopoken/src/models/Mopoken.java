package models;

public class Mopoken {
    private int level;
    private String type;

    public Mopoken(String type, int level){
        this.type = type;
        this.level = level;
    }

    public String getType(){
        return this.type;
    }

    public int getLevel(){
        return this.level;
    }

}
