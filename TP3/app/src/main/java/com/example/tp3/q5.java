package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class q5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);
        Button ok = findViewById(R.id.button);
        File dir = getFilesDir();
        EditText editableText = (EditText) findViewById (R.id.b);
        if(editableText.toString().isEmpty() == false){
            File file = new File(dir, editableText.toString());
            String fileContents = "Bonjour Mme FEUILLATRE";
            ok.setOnClickListener(view -> {
                try{
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(fileContents.getBytes());
                    fos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            });
        } else{
            System.out.print("Le champ de texte est vide");
        }
        ListView myList = (ListView) findViewById(R.id.myList);
    }

}