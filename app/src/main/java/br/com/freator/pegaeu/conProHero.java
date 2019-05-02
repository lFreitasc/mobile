package br.com.freator.pegaeu;

import java.util.ArrayList;

public class conProHero {
    private String name;
    private ArrayList<String> con = new ArrayList<>();
    private ArrayList<String> pro = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setCon(String con) {
        this.con.add(con);
    }

    public void setPro(String pro) {
        this.pro.add(pro);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCon() {
        return con;
    }

    public ArrayList<String> getPro() {
        return pro;
    }
}
