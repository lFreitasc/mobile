package br.com.freator.pegaeu.Helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.freator.pegaeu.Database.Database;


public class PickClass{

    public String[] getSuggestions(String[] enemyHeroes, Database db){
        String[] resultSuggestion = new String[4];
        ArrayList<Integer> countList = new ArrayList<>();
        ArrayList<String> singleHero = new ArrayList<>();
        Long heroID;

        for (String each : enemyHeroes) {

            heroID = db.heroDAO().getHeroID(each);
            List<String> suggestionReturn = db.advantagesDAO().queryGetNames(heroID);

            for (String hero: suggestionReturn) {
                if (singleHero.contains(hero)){
                    int index = singleHero.indexOf(hero);
                    int valueCount = countList.get(index) + 1;
                    countList.remove(index);
                    countList.add(index, valueCount);

                } else{
                    singleHero.add(hero);
                    countList.add(1);
                }
            }
        }
        for(int i = 0; i < 4; i++){
            if(!countList.isEmpty()){
                int maxValue = Collections.max(countList);
                int index = countList.indexOf(maxValue);
                resultSuggestion[i] = singleHero.get(index);
                singleHero.remove(index);
                countList.remove(index);
            }
        }

        return resultSuggestion;

    }
}
