package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.freator.pegaeu.Adapters.Adapter;
import br.com.freator.pegaeu.Helpers.fakeDataBase;
import br.com.freator.pegaeu.R;

public class CrudActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private fakeDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        recyclerView = findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            db = (fakeDataBase) bundle.getSerializable("FakeBase");

        }

        Adapter adapter = new Adapter(db);

        //config recycler layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
