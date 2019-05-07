package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.com.freator.pegaeu.Helpers.HeroInfo;
import br.com.freator.pegaeu.Helpers.fakeDataBase;
import br.com.freator.pegaeu.R;

public class AddHeroActivity extends AppCompatActivity {

    static fakeDataBase db;
    private HeroInfo heroInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hero);

        final Intent internIntent = getIntent();
        Bundle bundle = internIntent.getExtras();

        if(bundle != null){
            db = (fakeDataBase) bundle.getSerializable("FakeBase");
        }
    }

    public void buttonSave(View view){
        TextView textView = findViewById(R.id.addHeroName);
        HeroInfo heroInfo = new HeroInfo(textView.getText().toString());
        db.addHero(heroInfo);

        Intent result = new Intent();
        result.putExtra("FakeBase", db);
        setResult(1, result);
        finish();

    }
}
