package br.com.freator.pegaeu.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.Entity.Hero;
import br.com.freator.pegaeu.R;

public class AddHeroActivity extends AppCompatActivity {

    static Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hero);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                db = Database.getDatabase(AddHeroActivity.this);
            }
        });
    }

    public void buttonSave(View view){
        TextView textView = findViewById(R.id.addHeroName);
        final Hero hero = new Hero();
        hero.setName(textView.getText().toString());
        boolean waitThread = true;

        while (waitThread){
            if(db != null){
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        db.heroDAO().insert(hero);
                        finish();
                    }
                });
                waitThread = false;
            }
        }



    }
}
