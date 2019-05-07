package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.freator.pegaeu.Helpers.ListenerClass;
import br.com.freator.pegaeu.Helpers.fakeDataBase;
import br.com.freator.pegaeu.R;

import static android.R.layout.simple_dropdown_item_1line;


public class MainActivity extends AppCompatActivity {

    fakeDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = new fakeDataBase();
        db.fillDataBase();
        ArrayList<String> heroesList = db.getHeroes();


        final AutoCompleteTextView textViewE1, textViewE2, textViewE3, textViewE4, textViewE5;
        textViewE1 = findViewById(R.id.Enemy1);
        textViewE2 = findViewById(R.id.Enemy2);
        textViewE3 = findViewById(R.id.Enemy3);
        textViewE4 = findViewById(R.id.Enemy4);
        textViewE5 = findViewById(R.id.Enemy5);

        ArrayList <AutoCompleteTextView>  autoCompleteTextViews = new ArrayList<>();
        autoCompleteTextViews.add(textViewE1);
        autoCompleteTextViews.add(textViewE2);
        autoCompleteTextViews.add(textViewE3);
        autoCompleteTextViews.add(textViewE4);
        autoCompleteTextViews.add(textViewE5);
        autoComplete(autoCompleteTextViews, heroesList);


        ArrayList<TextView> textViews = new ArrayList<>();
        TextView textViewSuggestion1 = findViewById(R.id.textPick1);
        textViews.add(textViewSuggestion1);
        TextView textViewSuggestion2 = findViewById(R.id.textPick2);
        textViews.add(textViewSuggestion2);
        TextView textViewSuggestion3 = findViewById(R.id.textPick3);
        textViews.add(textViewSuggestion3);
        TextView textViewSuggestion4 = findViewById(R.id.textPick4);
        textViews.add(textViewSuggestion4);


        new ListenerClass(autoCompleteTextViews, heroesList, textViews, db);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.crudToolbar:
                intent = new Intent(this, CrudActivity.class);
                intent.putExtra("FakeBase", db);
                startActivity(intent);

                return true;

            case R.id.aboutToolbar:
                intent = new Intent(this, AboutActivity.class);

                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void autoComplete(ArrayList<AutoCompleteTextView> autoCompleteTextViews, ArrayList<String> heroesList)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, simple_dropdown_item_1line, heroesList);
        for (AutoCompleteTextView autoComplete: autoCompleteTextViews) {
            autoComplete.setAdapter(adapter);
            
        }
    }




}
