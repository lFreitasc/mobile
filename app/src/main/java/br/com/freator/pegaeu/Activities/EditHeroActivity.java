package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.freator.pegaeu.Helpers.HeroInfo;
import br.com.freator.pegaeu.Helpers.fakeDataBase;
import br.com.freator.pegaeu.R;

public class EditHeroActivity extends AppCompatActivity {


    static fakeDataBase db;
    private int position;
    private Spinner spinner;
    private HeroInfo heroInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hero);

        final Intent internIntent = getIntent();
        Bundle bundle = internIntent.getExtras();

        if(bundle != null){
            db = (fakeDataBase) bundle.getSerializable("FakeBase");
            position = bundle.getInt("position");
        }
        try {
            heroInfo = db.getHero(db.getHeroes().get(position));
        } catch (Exception e) {
            finish();
        }
        TextView textView = findViewById(R.id.selectedHeroEdit);
        textView.setText(heroInfo.getName());

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, db.getHeroes());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void buttonSave(View view){
        heroInfo.removeCon(heroInfo.getCon().get(0)); //mudar ao implementar mais de um ponto fraco
        heroInfo.setCon(spinner.getSelectedItem().toString());
        db.deleteHero(heroInfo.getName());
        db.addHero(heroInfo);
        finish();
//        Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

    }
}
