package br.com.freator.pegaeu.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


import br.com.freator.pegaeu.Entity.Hero;

@Dao
public interface HeroDAO {

    @Insert
    void insert(Hero hero);

    @Delete
    void delete(Hero hero);

    @Query("Select name from hero")
    List<String> getHeroes();

    @Query("Select id from hero where name = :name")
    long getHeroID(String name);
}
