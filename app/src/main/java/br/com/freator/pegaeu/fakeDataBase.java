package br.com.freator.pegaeu;

import java.util.ArrayList;

public class fakeDataBase {

    public ArrayList<HeroInfo> data = new ArrayList<>();

    public ArrayList<String> con(String hero){
        try{
            return getHero(hero).getCon();
        }catch (Exception e){
            return new ArrayList<>();
        }

    }

    void fillDataBase(){
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

    public HeroInfo getHero(String heroName) throws Exception{
        for(HeroInfo each : data){
            if(each.getName().equals(heroName)){
                return each;
            }
        }
        throw new Exception("HeroFindingException");
    }

    public ArrayList<String> getHeroes(){
        ArrayList<String> heroes = new ArrayList<>();
        for(HeroInfo each : data){
            heroes.add(each.getName());
        }
        return heroes;
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
