package br.com.freator.pegaeu.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.freator.pegaeu.Helpers.fakeDataBase;
import br.com.freator.pegaeu.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private fakeDataBase db;
    public Adapter(fakeDataBase db) {
        this.db = db;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View heroList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_list, viewGroup, false);

        return new MyViewHolder(heroList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.heroName.setText(db.getHeroes().get(i));


    }

    @Override
    public int getItemCount() {
        return db.getHeroes().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView heroName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            heroName = itemView.findViewById(R.id.textHeroAdapter);

        }
    }
}