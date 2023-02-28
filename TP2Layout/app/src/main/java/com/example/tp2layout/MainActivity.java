package com.example.tp2layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private MainActivity activity;

    // Create a message handling object
    private AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            // Do something in response to the click
            String departement = (String) parent.getItemAtPosition(position);
            Map population = new HashMap();
            population.put("Côtes-d'Armor",596518);
            population.put("Finistère",905000);
            population.put("Morbihan",751309);
            population.put("Ille-et-Vilaine",1079498);
            AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
            if(departement.equals("Côtes-d'Armor - Bretagne")){
                myPopup.setMessage("Côtes-d'Armor "+population.get("Côtes-d'Armor"));
                myPopup.show();
            }
            if(departement.equals("Finistère - Bretagne")){
                myPopup.setMessage("Finistère "+population.get("Finistère"));
                myPopup.show();
            }
            if(departement.equals("Morbihan - Bretagne")){
                myPopup.setMessage("Morbihan "+population.get("Morbihan"));
                myPopup.show();
            }
            if(departement.equals("Ille-et-Vilaine - Bretagne")){
                myPopup.setMessage("Ille-et-Vilaine "+population.get("Ille-et-Vilaine"));
                myPopup.show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q6);
        this.activity = this;
        //ListView myList = (ListView) findViewById(R.id.myList);
        ListView myList0 = findViewById(R.id.myList0);
        //String[] departements = new String[]{"Finistère", "Morbihan", "Ille-et-Vilaine", "Côtes-d'Armor"};
        String[] départements0 = new String[]{"Finistère - Bretagne", "Morbihan - Bretagne", "Ille-et-Vilaine - Bretagne", "Côtes-d'Armor - Bretagne"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departements);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, départements0);
        //myList.setAdapter(adapter);
        myList0.setAdapter(adapter0);
        myList0.setOnItemClickListener(messageClickedHandler);
    }

}