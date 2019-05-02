package br.com.freator.pegaeu;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

class ListenerClass {

    private ArrayList<String> heroesList;
    private ArrayList<TextView> textViews;
    private String[] suggestionHeroes = new String[4];
    private String[] allyHeroes = new String[5];
    private String[] enemyHeroes = new String[5];

    ListenerClass(ArrayList<AutoCompleteTextView> autoCompleteTextViews, ArrayList<String> heroesList, ArrayList<TextView> textViews) {
        this.heroesList = heroesList;
        int i = 0;
        for(AutoCompleteTextView each : autoCompleteTextViews){
            setListener(each, i);
            i++;
        }
        this.textViews = textViews;
    }



    private void setListener(final AutoCompleteTextView autoCompleteTextViews, final int index){
        autoCompleteTextViews.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String thisHero = verifyHero(s.toString());
                if(!thisHero.equals("")){
                    if(index < 5) allyHeroes[index] = thisHero;
                    else enemyHeroes[index - 5] = thisHero;

                    suggestionHeroes = new PickClass().getSuggestions(allyHeroes, enemyHeroes);
                    int index = 0;
                    for(String each : suggestionHeroes){
                        if(each != null){
                            textViews.get(index).setText(each);
                            Log.e("hero", each);
                        }else{
                            textViews.get(index).setText("");
                        }
                        index++;
                    }
                }

            }
        });
    }

    private String verifyHero(String typedHero){
        for(String eachHero : heroesList){
            if(eachHero.equals(typedHero)){
                return typedHero;
            }
        }
        return "";
    }
}
