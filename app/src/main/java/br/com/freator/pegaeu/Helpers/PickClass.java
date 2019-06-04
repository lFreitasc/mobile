package br.com.freator.pegaeu.Helpers;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;

import br.com.freator.pegaeu.Database.Database;


public class PickClass extends Activity {

    Database db;

    PickClass(){
        db = Database.getDatabase(PickClass.this);
    }

    public String[] getSuggestions(String[] enemyHeroes){
        String[] resultSuggestion = new String[4];
        ArrayList<Integer> countList = new ArrayList<>();
        ArrayList<String> singleHero = new ArrayList<>();

        for (String each : enemyHeroes) {
            String suggestionReturn = db.advantagesDAO().queryGetName(db.advantagesDAO().queryGetID(db.heroDAO().getHeroID(each)));

            if (singleHero.contains(suggestionReturn)){
                int index = singleHero.indexOf(suggestionReturn);
                int valueCount = countList.get(index) + 1;
                countList.remove(index);
                countList.add(index, valueCount);

            } else{
                singleHero.add(suggestionReturn);
                countList.add(1);
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