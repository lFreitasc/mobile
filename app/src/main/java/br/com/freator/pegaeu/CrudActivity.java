package br.com.freator.pegaeu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            fakeDataBase db = (fakeDataBase) bundle.getSerializable("FakeBase");

        }
    }
}
