package br.com.freator.pegaeu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.layout.simple_dropdown_item_1line;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fakeDataBase db = new fakeDataBase();
        db.fillDataBase();
        ArrayList<String> heroesList = db.getHeros();


        final AutoCompleteTextView textViewA1, textViewA2, textViewA3, textViewA4, textViewA5, textViewE1, textViewE2, textViewE3, textViewE4, textViewE5;
        textViewA1 = findViewById(R.id.Ally1);
        textViewA2 = findViewById(R.id.Ally2);
        textViewA3 = findViewById(R.id.Ally3);
        textViewA4 = findViewById(R.id.Ally4);
        textViewA5 = findViewById(R.id.Ally5);
        textViewE1 = findViewById(R.id.Enemy1);
        textViewE2 = findViewById(R.id.Enemy2);
        textViewE3 = findViewById(R.id.Enemy3);
        textViewE4 = findViewById(R.id.Enemy4);
        textViewE5 = findViewById(R.id.Enemy5);

        ArrayList <AutoCompleteTextView>  autoCompleteTextViews = new ArrayList<>();
        autoCompleteTextViews.add(textViewA1);
        autoCompleteTextViews.add(textViewA2);
        autoCompleteTextViews.add(textViewA3);
        autoCompleteTextViews.add(textViewA4);
        autoCompleteTextViews.add(textViewA5);
        autoCompleteTextViews.add(textViewE1);
        autoCompleteTextViews.add(textViewE2);
        autoCompleteTextViews.add(textViewE3);
        autoCompleteTextViews.add(textViewE4);
        autoCompleteTextViews.add(textViewE5);

        ArrayList<TextView> textViews = new ArrayList<>();
        TextView textViewSuggestion1 = findViewById(R.id.textPick1);
        textViews.add(textViewSuggestion1);
        TextView textViewSuggestion2 = findViewById(R.id.textPick2);
        textViews.add(textViewSuggestion2);
        TextView textViewSuggestion3 = findViewById(R.id.textPick3);
        textViews.add(textViewSuggestion3);
        TextView textViewSuggestion4 = findViewById(R.id.textPick4);
        textViews.add(textViewSuggestion4);

        autoComplete(autoCompleteTextViews, heroesList);
        new ListenerClass(autoCompleteTextViews, heroesList, textViews);

    }

    public void autoComplete(ArrayList<AutoCompleteTextView> autoCompleteTextViews, ArrayList<String> heroesList)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, simple_dropdown_item_1line, heroesList);
        for (AutoCompleteTextView autoComplete: autoCompleteTextViews) {
            autoComplete.setAdapter(adapter);
            
        }
    }




}
