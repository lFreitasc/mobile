package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import br.com.freator.pegaeu.Adapters.Adapter;
import br.com.freator.pegaeu.Helpers.RecyclerItemClickListener;
import br.com.freator.pegaeu.Helpers.fakeDataBase;
import br.com.freator.pegaeu.R;

public class CrudActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    static fakeDataBase db;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        recyclerView = findViewById(R.id.recyclerView);

        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            db = (fakeDataBase) bundle.getSerializable("FakeBase");

        }

        Adapter adapter = new Adapter(db);

        //config recycler layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(getApplicationContext(), recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            callEditHero(position);
                        }


                        @Override
                        public void onLongItemClick(View view, int position) {
                            //implementar multipla seleção para excluir -- não essencial até fim da matéria
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );
    }

    public void callEditHero(int position){
        intent = new Intent(this, EditHeroActivity.class);
        intent.putExtra("FakeBase", db);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    public void callAddHero(View view){
        intent = new Intent(this, AddHeroActivity.class);
        intent.putExtra("FakeBase", db);
        startActivity(intent);
    }
}
