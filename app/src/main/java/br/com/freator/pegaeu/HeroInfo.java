package br.com.freator.pegaeu;

import java.util.ArrayList;

public class HeroInfo {
    private String name;
    private ArrayList<String> con = new ArrayList<>();


    public HeroInfo(String name){
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
