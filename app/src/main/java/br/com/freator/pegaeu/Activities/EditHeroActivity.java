package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.R;

public class EditHeroActivity extends AppCompatActivity {


    private Database db;
    private String name;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hero);
        spinner = findViewById(R.id.spinner);
        TextView textView = findViewById(R.id.selectedHeroEdit);


//        textView.setText(heroInfo.getName());

        AsyncTask.execute(new Runnable() {
                              @Override
                              public void run() {
                                  db = Database.getDatabase(EditHeroActivity.this);
                                  ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, db.heroDAO().getHeroes());
                                  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                  spinner.setAdapter(adapter);
                              }
                          });
    }

    public void buttonSave(View view){


        finish();
    }


    public void buttonDelete(View view){
        /*
        *
        *Lembrar de apagar tanto do BD, tanto das fraquezas em Advantages;
        *
        */
        finish();
    }

}
