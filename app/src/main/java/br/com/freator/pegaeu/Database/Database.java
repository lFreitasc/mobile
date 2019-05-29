package br.com.freator.pegaeu.Database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.freator.pegaeu.DAO.AdvantagesDAO;
import br.com.freator.pegaeu.DAO.HeroDAO;
import br.com.freator.pegaeu.Entity.Advantages;
import br.com.freator.pegaeu.Entity.Hero;

@android.arch.persistence.room.Database(entities = {Hero.class, Advantages.class},version = 1)
public abstract class Database extends RoomDatabase {

    public abstract HeroDAO heroDAO();

    public abstract AdvantagesDAO advantagesDAO();

    private static Database instance;

    public static Database getDatabase(final Context context){

        if (instance == null){

            synchronized (Database.class){
                if (instance == null){
                    RoomDatabase.Builder builder = Room.databaseBuilder(context, Database.class, "database.db");

                    instance = (Database) builder.build();
                }
            }
        }


        return instance;
    }


}
