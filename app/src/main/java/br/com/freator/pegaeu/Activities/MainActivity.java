package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.Helpers.ListenerClass;
import br.com.freator.pegaeu.R;

import static android.R.layout.simple_dropdown_item_1line;


public class MainActivity extends AppCompatActivity {

    private Database db;
    private ArrayList <AutoCompleteTextView>  autoCompleteTextViews;
    List<String> heroesList;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<TextView> textViews = new ArrayList<>();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                db = Database.getDatabase(MainActivity.this);
                heroesList = db.heroDAO().getHeroes();
                new ListenerClass(autoCompleteTextViews, textViews, db);
            }
        });



        final AutoCompleteTextView textViewE1, textViewE2, textViewE3, textViewE4, textViewE5;
        textViewE1 = findViewById(R.id.Enemy1);
        textViewE2 = findViewById(R.id.Enemy2);
        textViewE3 = findViewById(R.id.Enemy3);
        textViewE4 = findViewById(R.id.Enemy4);
        textViewE5 = findViewById(R.id.Enemy5);

        autoCompleteTextViews = new ArrayList<>();
        autoCompleteTextViews.add(textViewE1);
        autoCompleteTextViews.add(textViewE2);
        autoCompleteTextViews.add(textViewE3);
        autoCompleteTextViews.add(textViewE4);
        autoCompleteTextViews.add(textViewE5);
        autoComplete(autoCompleteTextViews);


        TextView textViewSuggestion1 = findViewById(R.id.textPick1);
        textViews.add(textViewSuggestion1);
        TextView textViewSuggestion2 = findViewById(R.id.textPick2);
        textViews.add(textViewSuggestion2);
        TextView textViewSuggestion3 = findViewById(R.id.textPick3);
        textViews.add(textViewSuggestion3);
        TextView textViewSuggestion4 = findViewById(R.id.textPick4);
        textViews.add(textViewSuggestion4);


        //Verificar como chamar isso após rodar athread + código acima
//        new ListenerClass(autoCompleteTextViews, textViews, db);


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
                startActivityForResult(intent, 1);

                return true;

            case R.id.aboutToolbar:
                intent = new Intent(this, AboutActivity.class);

                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void autoComplete(ArrayList<AutoCompleteTextView> autoCompleteTextViews)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, simple_dropdown_item_1line, heroesList);
        for (AutoCompleteTextView autoComplete: autoCompleteTextViews) {
            autoComplete.setAdapter(adapter);
            
        }
    }


}
