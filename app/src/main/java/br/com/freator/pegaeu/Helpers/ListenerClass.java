package br.com.freator.pegaeu.Helpers;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.freator.pegaeu.Database.Database;

public class ListenerClass extends Activity {

    private List<String> heroesList;
    private ArrayList<TextView> textViews;
    private String[] suggestionHeroes = new String[4];
    private Database db;
    private String[] enemyHeroes = new String[5];


    public ListenerClass(ArrayList<AutoCompleteTextView> autoCompleteTextViews, ArrayList<TextView> textViews) {

        db = Database.getDatabase(ListenerClass.this);
        heroesList = db.heroDAO().getHeroes();

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
                    enemyHeroes[index] = thisHero;
                }else{
                    enemyHeroes[index] = null;
                }
                suggestionHeroes = new PickClass().getSuggestions(enemyHeroes);
                int index2 = 0;
                for(String each : suggestionHeroes){
                    if(each != null){
                        textViews.get(index2).setText(each);
                    }else{
                        textViews.get(index2).setText("");
                    }
                    index2++;
                }

            }
        });
    }

    private String verifyHero(String typedHero){
        for(String eachHero : heroesList){
            if(eachHero.equals(typedHero)){
                System.out.println("Retornando Heroi Válido: "+typedHero);
                System.out.println(db.advantagesDAO().queryGetName(db.advantagesDAO().queryGetID(db.heroDAO().getHeroID(typedHero))));
                return typedHero;
            }
        }
        return "";
    }
}
