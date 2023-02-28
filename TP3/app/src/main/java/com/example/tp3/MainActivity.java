package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File dir = getFilesDir();
        File file = new File(dir, "MORLOT--PINTAMORVAN");
        String fileContents = "Bonjour Mme FEUILLATRE";
        try{
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(fileContents.getBytes());
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        try{
            FileInputStream fis = new FileInputStream(file);
            fis.read();
            fis.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}