package br.com.freator.pegaeu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import br.com.freator.pegaeu.Adapters.Adapter;
import br.com.freator.pegaeu.Database.Database;
import br.com.freator.pegaeu.Entity.Advantages;
import br.com.freator.pegaeu.Entity.Hero;
import br.com.freator.pegaeu.Helpers.RecyclerItemClickListener;
import br.com.freator.pegaeu.R;

public class CrudActivity extends AppCompatActivity {

    private Intent intent;
    private Database db;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView recyclerView;





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);


        recyclerView = findViewById(R.id.recyclerView);
        db = Database.getDatabase(CrudActivity.this);
        adapter = new Adapter(db.heroDAO().getHeroes());

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
                                callEditHero(db.heroDAO().getHeroes().get(position));
                            }


                            @Override
                            public void onLongItemClick(View view, int position) {
//                                Toast.makeText(getApplication().getBaseContext(), db.heroDAO().getHeroes().get(position),Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );



    }

    public void callEditHero(String name){
        intent = new Intent(this, EditHeroActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
        this.recreate();
    }

    public void callAddHero(View view){
        System.out.println("Calling new intent");
        intent = new Intent(this, AddHeroActivity.class);
        startActivity(intent);
        this.recreate();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 322:
                Hero hero = new Hero();
                hero.setName(db.heroDAO().getHeroes().get(item.getGroupId()));
                hero.setId(db.heroDAO().getHeroID(db.heroDAO().getHeroes().get(item.getGroupId())));
//                System.out.println(db.heroDAO().getHeroes().get(item.getGroupId()));
                Advantages advantages = new Advantages(hero.getId());
                advantages.setId(db.advantagesDAO().queryGetID(advantages.getHero_id()));
                db.advantagesDAO().delete(advantages);
                db.heroDAO().delete(hero);
                this.recreate();
                return true;


            default:
                return super.onContextItemSelected(item);
        }

    }
}
