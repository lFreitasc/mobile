package br.com.freator.pegaeu.Helpers;

import java.io.Serializable;
import java.util.ArrayList;

public class HeroInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private ArrayList<String> con;



    public HeroInfo(String name){
        con = new ArrayList<>();
        this.name = name;
    }

    public void setCon(String con) {
        this.con.add(con);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCon() {
        return con;
    }


    public boolean removeCon(String name){
        int size = con.size();
        for(int index = 0; index < size; index++){
            if(con.get(index).equals(name)){
                con.remove(index);
                return true;
            }
        }
        return false;
    }
}