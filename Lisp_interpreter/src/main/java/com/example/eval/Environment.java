package com.example.eval;

import java.util.Map;
import java.util.HashMap;

public class Environment{
    private static Environment instance;
    private final Map<String, Integer> variables = new HashMap<>();

    private Environment() {}

    public static Environment getInstance(){
        if (instance == null){
            instance = new Environment();
        }
        return instance;
    }


    public void set(String name, int value){
        variables.put(name, value);
    }

    public Integer get(String name){
        return variables.get(name);
    }

    public boolean contains(String name){
        return variables.containsKey(name);
    }

//    public void clear(){
//        variables.clear();
//    }
}