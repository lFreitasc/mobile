package br.com.freator.pegaeu.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.Entity.Advantages;
import br.com.freator.pegaeu.Entity.Hero;
import br.com.freator.pegaeu.R;

public class AddHeroActivity extends AppCompatActivity {

    static Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hero);

        db = Database.getDatabase(AddHeroActivity.this);
    }

    public void buttonSave(View view){
        TextView textView = findViewById(R.id.addHeroName);
        Hero hero = new Hero();

        hero.setName(textView.getText().toString());
        db.heroDAO().insert(hero);
        Advantages advantages = new Advantages(db.heroDAO().getHeroID(hero.getName()));
        advantages.setName("");
        db.advantagesDAO().insert(advantages);
        finish();

    }
}
