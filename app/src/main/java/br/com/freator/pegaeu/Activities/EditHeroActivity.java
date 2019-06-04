package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.Entity.Advantages;
import br.com.freator.pegaeu.Entity.Hero;
import br.com.freator.pegaeu.R;

public class EditHeroActivity extends AppCompatActivity {


    private Database db;
    private String name;
    private Spinner spinner;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hero);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.selectedHeroEdit);

        Intent internIntent = getIntent();
        Bundle bundle = internIntent.getExtras();

        if(bundle != null){
            name = bundle.getString("name");
            textView.setText(name);

            db = Database.getDatabase(EditHeroActivity.this);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, db.heroDAO().getHeroes());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }


    }

    public void buttonSave(View view){

        Advantages advantages = new Advantages(db.heroDAO().getHeroID(textView.getText().toString()));
        //apagar
        advantages.setId(db.advantagesDAO().queryGetID(advantages.getHero_id()));
        advantages.setName(db.advantagesDAO().queryGetName(advantages.getId()));
        db.advantagesDAO().delete(advantages);


        //adicionar
        advantages.setName(spinner.getSelectedItem().toString());
        db.advantagesDAO().insert(advantages);
        System.out.println("Salvando modificacao de vantavem: "+ db.advantagesDAO().queryGetName(advantages.getId()));
        finish();

    }


    public void buttonDelete(View view){
        Hero hero = new Hero();
        hero.setName(name);
        hero.setId(db.heroDAO().getHeroID(name));


        Advantages advantages = new Advantages(hero.getId());
        advantages.setId(db.advantagesDAO().queryGetID(advantages.getHero_id()));
        db.advantagesDAO().delete(advantages);
        db.heroDAO().delete(hero);
        finish();

    }

}
