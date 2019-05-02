package br.com.freator.pegaeu;

import java.util.ArrayList;
import java.util.HashMap;

public class PickClass{

    public String[] getSuggestions(String[] allyHeroes, String[] enemyHeroes, fakeDataBase db){
        String[] suggestionHeros = new String[4];
        HashMap<String, Integer> dic = new HashMap<String, Integer>();

        for (String each: enemyHeroes) {
            if(dic.containsKey(each)){
                dic.put(each, dic.get(each) + 1);
            }else dic.put(each, 1);
        }





        return suggestionHeros;

    }
}
