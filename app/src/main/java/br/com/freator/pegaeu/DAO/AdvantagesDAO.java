package br.com.freator.pegaeu.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


import br.com.freator.pegaeu.Entity.Advantages;

@Dao
public interface AdvantagesDAO {

    @Insert
    void insert(Advantages advantages);

    @Delete
    void delete(Advantages advantages);

    @Update
    void update(Advantages advantages);

//    @Query("SELECT * FROM advantages WHERE id = :id")
//    Advantages queryGetAdvantages(long id);

    @Query("SELECT name FROM advantages WHERE hero_id = :id")
    List<String> queryGetNames(long id);
}
