package br.com.freator.pegaeu.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;


@Entity (foreignKeys = @ForeignKey(entity = Hero.class, parentColumns = "id", childColumns = "hero_id"))
public class Advantages {

    @PrimaryKey(autoGenerate = true)
    private long id;


    private String name;

    @ColumnInfo(index = true)
    private long hero_id;


    // Construtor
    public Advantages(Long hero_id)
    {
        this.hero_id = hero_id;
    }

    public long getId() {return id;}

    public String getName() {return name;}

    public long getHero_id() {return hero_id;}

    public void setId(long id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setHero_id(long hero_id) {this.hero_id = hero_id;}
}
