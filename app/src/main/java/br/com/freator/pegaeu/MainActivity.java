package br.com.freator.pegaeu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;

import static android.R.layout.simple_dropdown_item_1line;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> heroesList = new ArrayList<>(Arrays.asList("Abaddon","Alchemist","Axe","Beastmaster","Brewmaster","Bristleback","Centaur Warrunner","Chaos Knight","Clockwerk","Doom","Dragon Knight","Earth Spirit","Earthshaker","Elder Titan","Huskar","Io","Kunkka","Legion Commander","Lifestealer","Lycan","Magnus","Mars","Night Stalker","Omniknight","Phoenix","Pudge","Sand King","Slardar","Spirit Breaker","Sven","Tidehunter","Timbersaw","Tiny","Treant Protector","Tusk","Underlord","Undying","Wraith King",
            "Anti-Mage","Arc Warden","Bloodseeker","Bounty Hunter","Broodmother","Clinkz","Drow Ranger","Ember Spirit","Faceless Void","Gyrocopter","Juggernaut","Lone Druid","Luna","Medusa","Meepo","Mirana","Monkey King","Morphling","Naga Siren","Nyx Assassin","Pangolier","Phantom Assassin","Phantom Lancer","Razor","Riki","Shadow Fiend","Slark","Sniper","Spectre","Templar Assassin","Terrorblade","Troll Warlord","Ursa","Vengeful Spirit","Venomancer","Viper","Weaver",
            "Ancient Apparition","Bane","Batrider","Chen","Crystal Maiden","Dark Seer","Dark Willow","Dazzle","Death Prophet","Disruptor","Enchantress","Enigma","Grimstroke","Invoker","Jakiro","Keeper of the Light","Leshrac","Lich","Lina","Lion","Natures Prophet","Necrophos","Ogre Magi","Oracle","Outworld Devourer","Puck","Pugna","Queen of Pain","Rubick","Shadow Demon","Shadow Shaman","Silencer","Skywrath Mage","Storm Spirit","Techies","Tinker","Visage","Warlock","Windranger","Winter Wyvern","Witch Doctor","Zeus"));


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView textViewA1, textViewA2, textViewA3, textViewA4, textViewA5, textViewE1, textViewE2, textViewE3, textViewE4, textViewE5;
        textViewA1 = findViewById(R.id.Ally1);
        textViewA2 = findViewById(R.id.Ally2);
        textViewA3 = findViewById(R.id.Ally3);
        textViewA4 = findViewById(R.id.Ally4);
        textViewA5 = findViewById(R.id.Ally5);
        textViewE1 = findViewById(R.id.Enemy1);
        textViewE2 = findViewById(R.id.Enemy2);
        textViewE3 = findViewById(R.id.Enemy3);
        textViewE4 = findViewById(R.id.Enemy4);
        textViewE5 = findViewById(R.id.Enemy5);

        ArrayList <AutoCompleteTextView>  autoCompleteTextViews = new ArrayList<>();
        autoCompleteTextViews.add(textViewA1);
        autoCompleteTextViews.add(textViewA2);
        autoCompleteTextViews.add(textViewA3);
        autoCompleteTextViews.add(textViewA4);
        autoCompleteTextViews.add(textViewA5);
        autoCompleteTextViews.add(textViewE1);
        autoCompleteTextViews.add(textViewE2);
        autoCompleteTextViews.add(textViewE3);
        autoCompleteTextViews.add(textViewE4);
        autoCompleteTextViews.add(textViewE5);

        ArrayList<TextView> textViews = new ArrayList<>();
        TextView textViewSuggestion1 = findViewById(R.id.textPick1);
        textViews.add(textViewSuggestion1);
        TextView textViewSuggestion2 = findViewById(R.id.textPick2);
        textViews.add(textViewSuggestion2);
        TextView textViewSuggestion3 = findViewById(R.id.textPick3);
        textViews.add(textViewSuggestion3);
        TextView textViewSuggestion4 = findViewById(R.id.textPick4);
        textViews.add(textViewSuggestion4);

        autoComplete(autoCompleteTextViews);
        new ListenerClass(autoCompleteTextViews, heroesList, textViews);

    }

    public void autoComplete(ArrayList<AutoCompleteTextView> autoCompleteTextViews)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, simple_dropdown_item_1line, heroesList);
        for (AutoCompleteTextView autoComplete: autoCompleteTextViews) {
            autoComplete.setAdapter(adapter);
            
        }
    }




}
