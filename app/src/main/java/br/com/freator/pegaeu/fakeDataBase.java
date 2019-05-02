package br.com.freator.pegaeu;

import java.util.ArrayList;

public class fakeDataBase {

    ArrayList<HeroInfo> data = new ArrayList<>();

    public String pro(String hero){

        return "pro";
    }
    public String con(String hero){
        return "con";
    }

    public void fillDataBase(){
        HeroInfo ancient = new HeroInfo("Ancient Apparition");
        HeroInfo alch = new HeroInfo("Alchemist");
        HeroInfo pl = new HeroInfo("Phantom Lancer");

        ancient.setCon("Phantom Lancer");
        alch.setCon("Ancient Apparition");
        pl.setCon("Alchemist");

        data.add(ancient);
        data.add(alch);
        data.add(pl);
    }

    public ArrayList<String> getHeros(){
        ArrayList<String> result = new ArrayList<>();
        for(HeroInfo each : data){
            result.add(each.getName());
        }
        return result;
    }

    public void addHero(HeroInfo hero){
        data.add(hero);
    }

    public boolean deleteHero(String name){
        int size = data.size();
        for(int index = 0; index < size; index++){
            if(data.get(index).getName().equals(name)){
                data.remove(index);
                return true;
            }
        }
        return false;
    }




}
