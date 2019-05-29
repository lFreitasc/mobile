package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.freator.pegaeu.Adapters.Adapter;
import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.Helpers.RecyclerItemClickListener;
import br.com.freator.pegaeu.R;

public class CrudActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Database db;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        db = Database.getDatabase(CrudActivity.this);

        recyclerView = findViewById(R.id.recyclerView);

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
                        public void onItemClick(View view, int position)
                        {

                            callEditHero(recyclerView.findViewHolderForAdapterPosition(position).toString());
                            System.out.println(recyclerView.findViewHolderForAdapterPosition(position).toString()); //debbug
//                            callEditHero(((TextView) recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.title)).getText().toString());
                            //this one works, but lets try something diferent
                        }


                        @Override
                        public void onLongItemClick(View view, int position) {
                            //implementar multipla seleção para excluir -- não essencial até fim da matéria
                            //menu contextual ?
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //menu contextual ?
                        }
                    }
            )
        );
    }

    public void callEditHero(String position){
        intent = new Intent(this, EditHeroActivity.class);
        intent.putExtra("name", position);
        startActivityForResult(intent, 1);
    }

    public void callAddHero(View view){
        intent = new Intent(this, AddHeroActivity.class);
        startActivityForResult(intent, 1);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            Intent result = new Intent();
//            result.putExtra("FakeBase", db);
//            setResult(1, result);
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
