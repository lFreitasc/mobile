package br.com.freator.pegaeu.Entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(indices = @Index(value = {"name"}, unique = true))
public class Hero {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    private String name;

    /*
    *
    * GETTERS e SETTERS
    *
    * */
    public long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }


    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
