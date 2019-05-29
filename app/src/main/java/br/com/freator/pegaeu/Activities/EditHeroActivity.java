package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.Helpers.HeroInfo;
import br.com.freator.pegaeu.R;

public class EditHeroActivity extends AppCompatActivity {


    private Database db;
    private String name;
    private Spinner spinner;
    private HeroInfo heroInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hero);

        db = Database.getDatabase(EditHeroActivity.this);
        TextView textView = findViewById(R.id.selectedHeroEdit);
        textView.setText(heroInfo.getName());

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, db.heroDAO().getHeroes());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void buttonSave(View view){
//        heroInfo.removeCon(heroInfo.getCon().get(0)); //mudar ao implementar mais de um ponto fraco
//        heroInfo.setCon(spinner.getSelectedItem().toString());
//        db.deleteHero(heroInfo.getName());
//        db.addHero(heroInfo);
//
//
//        Intent result = new Intent();
//        result.putExtra("FakeBase", db);
//        setResult(1, result);
//
//        finish();

    }


    public void buttonDelete(View view){
        /*
        *
        *Lembrar de apagar tanto do BD, tanto das fraquezas em Advantages;
        *
        */
//        db.heroDAO().delete();
//
//        Intent result = new Intent();
//        result.putExtra("FakeBase", db);
//        setResult(1, result);
//
//        finish();
    }

}
